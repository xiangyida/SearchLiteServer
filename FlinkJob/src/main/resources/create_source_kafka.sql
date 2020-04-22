CREATE TABLE KAFKA_SOURCE_SEARCH_DATA (
    data VARCHAR,
    ts TIMESTAMP(3),
    WATERMARK FOR ts as ts - INTERVAL '5' SECOND
) WITH (
    'connector.type' = 'kafka',  -- 使用 kafka connector
    'connector.version' = 'universal',  -- kafka 版本，universal 支持 0.11 以上的版本
    'connector.topic' = 'search_data',  -- kafka topic
    'connector.startup-mode' = 'earliest-offset',  -- 从起始 offset 开始读取
    'connector.properties.zookeeper.connect' = '172.12.35.21:2181',  -- zookeeper 地址
    'connector.properties.bootstrap.servers' = '172.12.35.31:9092',  -- kafka broker 地址
    'format.type' = 'json'  -- 数据源格式为 json
)