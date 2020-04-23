CREATE TABLE MYSQL_SINK_SEARCH_FREQUENCY (
    cnt BIGINT,
    cnt_time timestamp
) WITH (
    'connector.type' = 'jdbc',
    'connector.url' = 'jdbc:mysql://172.12.35.3:3306/search_lite',
    'connector.table' = 'user_search_frequency',
    'connector.username' = 'root',
    'connector.password' = '123456',
    'connector.write.flush.max-rows' = '1'
)