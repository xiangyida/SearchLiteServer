CREATE TABLE KAFKA_SOURCE_SEARCH_DATA (
    data VARCHAR,
    ts timestamp(3),
    WATERMARK FOR ts as ts - INTERVAL '5' SECOND
) WITH (
'connector.type' = 'kafka',
'connector.version' = 'universal',
'connector.properties.group.id' = 'group-flink',
'connector.topic' = 'search_data',
'connector.startup-mode' = 'earliest-offset',
'connector.properties.zookeeper.connect' = 'zk1:2181',
'connector.properties.bootstrap.servers' = 'kafka1:9092',
'format.type' = 'json'
)