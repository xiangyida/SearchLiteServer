package xyh;

public class ExecSQL {
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

    public static final String SEARCH_WORD_QUERY = "SELECT data FROM KAFKA_SOURCE_SEARCH_WORD_COUNT";
}
