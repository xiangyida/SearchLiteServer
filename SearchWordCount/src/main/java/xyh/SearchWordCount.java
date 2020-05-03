package xyh;

import com.alibaba.fastjson.JSONObject;
import com.github.yang69.flink.streaming.connectors.redis.RedisSink;
import com.github.yang69.flink.streaming.connectors.redis.common.config.FlinkJedisPoolConfig;
import com.github.yang69.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import com.github.yang69.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import com.github.yang69.flink.streaming.connectors.redis.common.mapper.RedisMapper;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SearchWordCount {
	public static void main(String[] args) throws Exception {
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "kafka1:9094");
		properties.setProperty("group.id", "group-flink-word_count");
		FlinkKafkaConsumer<String> kafkaConsumer = new FlinkKafkaConsumer<>(
				"search_data",
				new SimpleStringSchema(),
				properties);
		kafkaConsumer.setStartFromEarliest();
		DataStream<String> input = env.addSource(kafkaConsumer);

		//词频统计
		DataStream<Tuple2<String, Integer>> counts = input.flatMap(new WordAnalysis())
				.keyBy(0).sum(1);

		//sink到redis
		FlinkJedisPoolConfig config = new FlinkJedisPoolConfig.Builder().setHost("172.18.0.3").setPort(6379).build();
		RedisSink<Tuple2<String,Integer>> redisSink = new RedisSink<>(config,new WordCountRedisMapper());
		counts.addSink(redisSink);


		env.execute("SearchLite AnalysisModel FlinkJob");
	}





	public static final class WordAnalysis implements FlatMapFunction<String, Tuple2<String, Integer>> {

		@Override
		public void flatMap(String source, Collector<Tuple2<String, Integer>> out) {
			String searchSentence = JSONObject.parseObject(source).get("data").toString();
			analysis(searchSentence).forEach(word -> out.collect(new Tuple2<>(word,1)));
		}
	}

	public static final class WordCountRedisMapper implements RedisMapper<Tuple2<String,Integer>>{
		@Override
		public RedisCommandDescription getCommandDescription() {
			return new RedisCommandDescription(RedisCommand.HSET,"word_count");
		}
		@Override
		public String getKeyFromData(Tuple2<String, Integer> data) {
			return data.f0;
		}
		@Override
		public int getSecondsFromData(Tuple2<String, Integer> data) {
			return 0;
		}
		@Override
		public String getValueFromData(Tuple2<String, Integer> data) {
			return String.valueOf(data.f1);
		}
	}
	//分词
	public static List<String> analysis(String source){
		List<String> list =new ArrayList<>();
		Analyzer analyzer = new IKAnalyzer(true);
		TokenStream ts = null;
		try {
			ts = analyzer.tokenStream(",",source);
			CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
			ts.reset();
			while (ts.incrementToken()) {
				list.add(term.toString());
			}
			ts.end();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ts != null) {
				try {
					ts.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
