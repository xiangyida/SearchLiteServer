package xyh;

import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

public class StreamingJob {

	private static final String CREATE_SOURCE = "source_kafka.sql";
	private static final String CREATE_SINK = "sink_mysql.sql";
	private static final String OPERATOR_FREQUENCY_COUNT = "operator_frequency_count.sql";
	public static void main(String[] args) throws Exception {

		EnvironmentSettings settings = EnvironmentSettings.newInstance()
				.useBlinkPlanner()
				.inStreamingMode()
				.build();

		TableEnvironment tEnv = TableEnvironment.create(settings);

		String create_source_sql = FileUtil.readFileAsString(CREATE_SOURCE);
		String create_sink_sql= FileUtil.readFileAsString(CREATE_SINK);
		String operator_frequency_count_sql = FileUtil.readFileAsString(OPERATOR_FREQUENCY_COUNT);

		//source
		tEnv.sqlUpdate(create_source_sql);
		//sink
		tEnv.sqlUpdate(create_sink_sql);
		//operator
		tEnv.sqlUpdate(operator_frequency_count_sql);

		tEnv.execute("SEARCH FREQUENCY COUNT");
	}
}
