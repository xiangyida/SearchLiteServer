CREATE TABLE KAFKA_SOURCE_SEARCH_DATA (
    data VARCHAR,
    ts timestamp
    ) WITH (
    'connector.type' = 'kafka',
    'connector.version' = 'universal',
    'connector.topic' = 'search_data',
    'connector.startup-mode' = 'earliest-offset',
    'connector.properties.zookeeper.connect' = 'localhost:2181',
    'connector.properties.bootstrap.servers' = 'localhost:9092',
    'format.type' = 'json',
    'format.derive-schema' = 'true'
)