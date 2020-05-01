-- 搜题频率计算
-----------------------------------------------
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
'connector.properties.zookeeper.connect' = 'localhost:2181',
'connector.properties.bootstrap.servers' = 'kafka1:9094',
'format.type' = 'json'
)

CREATE TABLE MYSQL_SINK_SEARCH_FREQUENCY (
    cnt BIGINT,
    cnt_time timestamp(3)
) WITH (
    'connector.type' = 'jdbc',
    'connector.url' = 'jdbc:mysql://123.207.11.229:3306/search_lite?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false',
    'connector.table' = 'user_search_frequency',
    'connector.username' = 'root',
    'connector.password' = 'yxyj6900@',
    'connector.write.flush.max-rows' = '1'
)

INSERT INTO MYSQL_SINK_SEARCH_FREQUENCY(cnt,cnt_time)
SELECT
COUNT(*) as cnt,
TUMBLE_START(ts, INTERVAL '10' MINUTE) as cnt_time
FROM KAFKA_SOURCE_SEARCH_DATA
GROUP BY TUMBLE(ts, INTERVAL '10' MINUTE)

-- 词频
-----------------------------------------------
CREATE TABLE KAFKA_SOURCE_SEARCH_WORD_COUNT (
    data VARCHAR
) WITH (
'connector.type' = 'kafka',
'connector.version' = 'universal',
'connector.properties.group.id' = 'group-word_cloud',
'connector.topic' = 'search_data',
'connector.startup-mode' = 'earliest-offset',
'connector.properties.zookeeper.connect' = 'localhost:2181',
'connector.properties.bootstrap.servers' = 'kafka1:9094',
'format.type' = 'json'
)