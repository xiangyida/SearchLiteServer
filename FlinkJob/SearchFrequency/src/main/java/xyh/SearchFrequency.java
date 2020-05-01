package xyh;


import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.java.StreamTableEnvironment;

public class SearchFrequency {
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


		tEnv.execute("SearchLite AnalysisModel SearchFrequency FlinkJob");
	}
}
