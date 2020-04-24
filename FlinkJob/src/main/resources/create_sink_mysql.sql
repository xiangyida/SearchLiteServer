CREATE TABLE MYSQL_SINK_SEARCH_FREQUENCY (
    cnt BIGINT,
    cnt_time timestamp(3)
) WITH (
    'connector.type' = 'jdbc',
    'connector.url' = 'jdbc:mysql://127.0.0.1:3306/search_lite?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC',
    'connector.table' = 'user_search_frequency',
    'connector.username' = 'root',
    'connector.password' = '123456',
    'connector.write.flush.max-rows' = '1'
)