package xyh;

public class ExecSQL {
    //搜题频率统计
    //-----------------------------------------------------------------------------------------
    public static final String KAFKA_SOURCE_SEARCH_DATA = "CREATE TABLE KAFKA_SOURCE_SEARCH_DATA (\n" +
            "    data VARCHAR,\n" +
            "    ts timestamp(3),\n" +
            "    WATERMARK FOR ts as ts - INTERVAL '5' SECOND\n" +
            ") WITH (\n" +
            "'connector.type' = 'kafka',\n" +
            "'connector.version' = 'universal',\n" +
            "'connector.properties.group.id' = 'group-flink-search_frequency',\n" +
            "'connector.topic' = 'search_data',\n" +
            "'connector.startup-mode' = 'earliest-offset',\n" +
            "'connector.properties.zookeeper.connect' = 'localhost:2181',\n" +
            "'connector.properties.bootstrap.servers' = 'kafka1:9094',\n" + //PROD:kafka1:9094
            "'format.type' = 'json'\n" +
            ")";

    public static final String MYSQL_SINK_SEARCH_FREQUENCY = "CREATE TABLE MYSQL_SINK_SEARCH_FREQUENCY (\n" +
            "    cnt_time varchar,\n" +
            "    cnt BIGINT\n" +
            ") WITH (\n" +
            "    'connector.type' = 'jdbc',\n" +
            "    'connector.url' = 'jdbc:mysql://123.207.11.229:3306/search_lite?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false',\n" +
            "    'connector.table' = 'user_search_frequency',\n" +
            "    'connector.username' = 'root',\n" +
            "    'connector.password' = 'yxyj6900@',\n" +
            "    'connector.write.flush.max-rows' = '1'\n" +
            ")";

    public static final String OPERATOR_FREQUENCY_COUNT = "INSERT INTO MYSQL_SINK_SEARCH_FREQUENCY(cnt_time,cnt)\n" +
            " SELECT\n" +
            " CAST(TUMBLE_START(ts, INTERVAL '10' minute) AS STRING) cnt_time,\n" +
            " COUNT(*) as cnt\n" +
            " FROM KAFKA_SOURCE_SEARCH_DATA\n" +
            " GROUP BY TUMBLE(ts, INTERVAL '10' minute)";

    //word count
    //-----------------------------------------------------------------------------------------
    public static final String KAFKA_SOURCE_SEARCH_WORD_COUNT ="CREATE TABLE KAFKA_SOURCE_SEARCH_WORD_COUNT (\n" +
            "    data VARCHAR\n" +
            ") WITH (\n" +
            "'connector.type' = 'kafka',\n" +
            "'connector.version' = 'universal',\n" +
            "'connector.properties.group.id' = 'group-flink-word_cloud',\n" +
            "'connector.topic' = 'search_data',\n" +
            "'connector.startup-mode' = 'earliest-offset',\n" +
            "'connector.properties.zookeeper.connect' = 'localhost:2181',\n" +
            "'connector.properties.bootstrap.servers' = 'kafka1:9094',\n" + //PROD:kafka1:9094
            "'format.type' = 'json'\n" +
            ")";

    public static final String SEARCH_WORD_QUERY = "SELECT * FROM KAFKA_SOURCE_SEARCH_WORD_COUNT";
}
