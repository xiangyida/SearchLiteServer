package xyh;

import com.github.yang69.flink.streaming.connectors.redis.RedisSink;
import com.github.yang69.flink.streaming.connectors.redis.common.config.FlinkJedisPoolConfig;
import com.github.yang69.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import com.github.yang69.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import com.github.yang69.flink.streaming.connectors.redis.common.mapper.RedisMapper;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.java.StreamTableEnvironment;
import org.apache.flink.util.Collector;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreamingJob {
	public static void main(String[] args) throws Exception {
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		EnvironmentSettings settings = EnvironmentSettings.newInstance()
				.useBlinkPlanner()
				.inStreamingMode()
				.build();

		env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

		StreamTableEnvironment tEnv = StreamTableEnvironment.create(env, settings);


		//search frequency count
		//---------------------------------------------------------------------------
		//source
		tEnv.sqlUpdate(ExecSQL.KAFKA_SOURCE_SEARCH_DATA);
		//sink
		tEnv.sqlUpdate(ExecSQL.MYSQL_SINK_SEARCH_FREQUENCY);
		//operator
		tEnv.sqlUpdate(ExecSQL.OPERATOR_FREQUENCY_COUNT);

		//---------------------------------------------------------------------------

		//word count
		//---------------------------------------------------------------------------
		//source
		tEnv.sqlUpdate(ExecSQL.KAFKA_SOURCE_SEARCH_WORD_COUNT);
		Table result = tEnv.sqlQuery(ExecSQL.SEARCH_WORD_QUERY);
		DataStream<SearchData> dataStream = tEnv.toAppendStream(result,SearchData.class);
		//词频统计
		DataStream<Tuple2<String, Integer>> counts = dataStream.flatMap(new WordAnalysis())
				.keyBy(0).sum(1);
		//sink到redis
		FlinkJedisPoolConfig config = new FlinkJedisPoolConfig.Builder().setHost("127.0.0.1").setPort(6379).build();
		RedisSink<Tuple2<String,Integer>> redisSink = new RedisSink<>(config,new WordCountRedisMapper());
		counts.addSink(redisSink);

		//----------------------------------------------------------------------------

		tEnv.execute("SearchLite AnalysisModel FlinkJob");
	}

	public static class SearchData{
		public String data;

		public SearchData(String data) {
			this.data = data;
		}

		public SearchData() {
		}

		@Override
		public String toString() {
			return this.data;
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

	public static final class WordAnalysis implements FlatMapFunction<SearchData, Tuple2<String, Integer>> {

		@Override
		public void flatMap(SearchData source, Collector<Tuple2<String, Integer>> out) {
			analysis(source.data).forEach(word -> out.collect(new Tuple2<>(word,1)));
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

}
