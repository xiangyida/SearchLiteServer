########### jar ####################
#flink-dist_2.11-1.10.0.jar
#flink-jdbc_2.11-1.10.0.jar
#flink-json-1.10.0.jar
#flink-sql-connector-kafka_2.11-1.10.0.jar
#flink-table-blink_2.11-1.10.0.jar
#flink-table_2.11-1.10.0.jar
#log4j-1.2.17.jar
#mysql-connector-java-5.1.48.jar
#slf4j-log4j12-1.7.15.jar
#ikanalyzer-2012_u6.jar
#flink-connector-redis_2.11-1.0.jar
###################################
wget -P ./lib/ https://maven.aliyun.com/repository/public/org/apache/flink/flink-sql-connector-kafka_2.11/1.10.0/flink-sql-connector-kafka_2.11-1.10.0.jar | \
wget -P ./lib/ https://maven.aliyun.com/repository/public/org/apache/flink/flink-json/1.10.0/flink-json-1.10.0.jar | \
wget -P ./lib/ https://maven.aliyun.com/repository/public/org/apache/flink/flink-jdbc_2.11/1.10.0/flink-jdbc_2.11-1.10.0.jar | \
wget -P ./lib/ https://maven.aliyun.com/repository/public/mysql/mysql-connector-java/5.1.48/mysql-connector-java-5.1.48.jar | \
wget -P ./lib/ https://maven.aliyun.com/repository/public/com/janeluo/ikanalyzer/2012_u6/ikanalyzer-2012_u6.jar | \
wget -P ./lib/ https://maven.aliyun.com/repository/public/com/github/yang69/flink-connector-redis_2.11/1.0/flink-connector-redis_2.11-1.0.jar