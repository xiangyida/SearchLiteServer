REPOSITORY_DIR="/Users/xiangyida/maven/repository"
TARGET_DIR="fc126dd02bda:/opt/flink/lib/"
#docker cp $REPOSITORY_DIR/org/apache/flink/flink-connector-kafka_2.11/1.10.0/flink-connector-kafka_2.11-1.10.0.jar $TARGET_DIR
#docker cp $REPOSITORY_DIR/org/apache/flink/flink-json/1.10.0/flink-json-1.10.0.jar $TARGET_DIR
#docker cp $REPOSITORY_DIR/org/apache/flink/flink-connector-kafka-base_2.11/1.10.0/flink-connector-kafka-base_2.11-1.10.0.jar $TARGET_DIR
docker cp $REPOSITORY_DIR/mysql/mysql-connector-java/8.0.19/mysql-connector-java-8.0.19.jar $TARGET_DIR
#docker cp $REPOSITORY_DIR/org/apache/kafka/kafka-clients/2.2.0/kafka-clients-2.2.0.jar $TARGET_DIR
docker cp $REPOSITORY_DIR/org/apache/flink/flink-jdbc_2.11/1.10.0/flink-jdbc_2.11-1.10.0.jar $TARGET_DIR