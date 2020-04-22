CREATE TABLE KAFKA_SOURCE_SEARCH_DATA (
    data VARCHAR,
    ts TIMESTAMP(3),
    WATERMARK FOR ts as ts - INTERVAL '5' SECOND
) WITH (
    'connector.type' = 'kafka',
    'connector.version' = 'universal',
    'connector.topic' = 'search_data',
    'connector.startup-mode' = 'earliest-offset',
    'connector.properties.0.key' = 'zookeeper.connect',
    'connector.properties.0.value' = '172.12.35.21:2181',
    'connector.properties.1.key' = 'bootstrap.servers',
    'connector.properties.1.value' = '172.12.35.31:9092',
    'update-mode' = 'append',
    'format.type' = 'json',
    'format.derive-schema' = 'true'
)