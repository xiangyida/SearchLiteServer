package xyh;

public class ExecSQL {
    public static final String CREATE_SOURCE = "CREATE TABLE KAFKA_SOURCE_SEARCH_DATA (\n" +
            "    data VARCHAR,\n" +
            "    ts timestamp(3),\n" +
            "    WATERMARK FOR ts as ts - INTERVAL '0' SECOND\n" +
            ") WITH (\n" +
            "'connector.type' = 'kafka',\n" +
            "'connector.version' = 'universal',\n" +
            "'connector.properties.group.id' = 'group-flink',\n" +
            "'connector.topic' = 'search_data',\n" +
            "'connector.startup-mode' = 'earliest-offset',\n" +
            "'connector.properties.zookeeper.connect' = 'localhost:2181',\n" +
            "'connector.properties.bootstrap.servers' = 'localhost:9092',\n" +
            "'format.type' = 'json'\n" +
            ")";
    public static final String CREATE_SINK = "CREATE TABLE MYSQL_SINK_SEARCH_FREQUENCY (\n" +
            "    cnt_time varchar,\n" +
            "    cnt BIGINT\n" +
            ") WITH (\n" +
            "    'connector.type' = 'jdbc',\n" +
            "    'connector.url' = 'jdbc:mysql://127.0.0.1:3306/search_lite',\n" +
            "    'connector.table' = 'user_search_frequency',\n" +
            "    'connector.username' = 'root',\n" +
            "    'connector.password' = '123456',\n" +
            "    'connector.write.flush.max-rows' = '1'\n" +
            ")";
    public static final String OPERATOR_FREQUENCY_COUNT = "INSERT INTO MYSQL_SINK_SEARCH_FREQUENCY(cnt_time,cnt)\n" +
            " SELECT\n" +
            " CAST(TUMBLE_START(ts, INTERVAL '10' minute) AS STRING) cnt_time,\n" +
            " COUNT(*) as cnt\n" +
            " FROM KAFKA_SOURCE_SEARCH_DATA\n" +
            " GROUP BY TUMBLE(ts, INTERVAL '10' minute)";
}
