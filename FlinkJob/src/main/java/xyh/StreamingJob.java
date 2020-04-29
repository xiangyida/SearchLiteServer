package xyh;

import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.java.StreamTableEnvironment;

public class StreamingJob {
	public static void main(String[] args) throws Exception {
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		EnvironmentSettings settings = EnvironmentSettings.newInstance()
				.useBlinkPlanner()
				.inStreamingMode()
				.build();

		env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

		StreamTableEnvironment tEnv = StreamTableEnvironment.create(env, settings);



		//source
		tEnv.sqlUpdate(ExecSQL.CREATE_SOURCE);
		//sink
		tEnv.sqlUpdate(ExecSQL.CREATE_SINK);


		//operator
		tEnv.sqlUpdate(ExecSQL.OPERATOR_FREQUENCY_COUNT);
		//Table result = tEnv.sqlQuery(query);
		//tEnv.toAppendStream(result, Row.class).print();

		tEnv.execute("SEARCH FREQUENCY COUNT");
	}
}
