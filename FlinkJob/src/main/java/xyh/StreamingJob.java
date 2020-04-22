package xyh;

import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

public class StreamingJob {

	private static final String CREATE_SOURCE = "create_source_table.sql";

	public static void main(String[] args) throws Exception {

		EnvironmentSettings settings = EnvironmentSettings.newInstance()
				.useBlinkPlanner()
				.inStreamingMode()
				.build();

		TableEnvironment tEnv = TableEnvironment.create(settings);

		String create_source_sql = FileUtil.readFileAsString(CREATE_SOURCE);

		System.out.println(create_source_sql);

		//tEnv.execute("SQL Job");
	}
}
