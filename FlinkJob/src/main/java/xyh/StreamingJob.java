package xyh;

import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

public class StreamingJob {

	private static final String CREATE_SOURCE = "CREATE TABLE KAFKA_SOURCE_SEARCH_DATA (\n" +
			"    data VARCHAR,\n" +
			"    ts timestamp(3),\n" +
			"    WATERMARK FOR ts as ts - INTERVAL '5' SECOND\n" +
			") WITH (\n" +
			"'connector.type' = 'kafka',\n" +
			"'connector.version' = 'universal',\n" +
			"'connector.topic' = 'search_data',\n" +
			"'connector.startup-mode' = 'earliest-offset',\n" +
			"'connector.properties.zookeeper.connect' = 'localhost:2181',\n" +
			"'connector.properties.bootstrap.servers' = 'localhost:9092',\n" +
			"'format.type' = 'json'\n" +
			")";
	private static final String CREATE_SINK = "CREATE TABLE MYSQL_SINK_SEARCH_FREQUENCY (\n" +
			"    cnt BIGINT,\n" +
			"    cnt_time timestamp(3)\n" +
			") WITH (\n" +
			"    'connector.type' = 'jdbc',\n" +
			"    'connector.url' = 'jdbc:mysql://127.0.0.1:3306/search_lite?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC',\n" +
			"    'connector.table' = 'user_search_frequency',\n" +
			"    'connector.username' = 'root',\n" +
			"    'connector.password' = '123456',\n" +
			"    'connector.write.flush.max-rows' = '1'\n" +
			")";
	private static final String OPERATOR_FREQUENCY_COUNT = "INSERT INTO MYSQL_SINK_SEARCH_FREQUENCY(cnt,cnt_time)\n" +
			"SELECT\n" +
			"COUNT(*) as cnt ,\n" +
			"TUMBLE_START(ts, INTERVAL '1' MINUTE) as cnt_time\n" +
			"FROM KAFKA_SOURCE_SEARCH_DATA\n" +
			"GROUP BY TUMBLE(ts, INTERVAL '1' MINUTE)";

	public static void main(String[] args) throws Exception {

		EnvironmentSettings settings = EnvironmentSettings.newInstance()
				.useBlinkPlanner()
				.inStreamingMode()
				.build();

		TableEnvironment tEnv = TableEnvironment.create(settings);


		//source
		tEnv.sqlUpdate(CREATE_SOURCE);
		//sink
		tEnv.sqlUpdate(CREATE_SINK);
		//operator
		tEnv.sqlUpdate(OPERATOR_FREQUENCY_COUNT);

		tEnv.execute("SEARCH FREQUENCY COUNT");
	}
}
