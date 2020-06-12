#!/bin/bash

IK_PLUGIN_URL="https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.8.4/elasticsearch-analysis-ik-6.8.4.zip"
MYSQL_ROOT_PASSWORD="123456"
# 挂载目录
VOLUMES_ROOT="/docker/"
# 安装es插件
echo "=========> 安装IK分词器"
mkdir -p "$VOLUMES_ROOT/es/plugins"
wget -P /$VOLUMES_ROOT/es/plugins/ $IK_PLUGIN_URL
unzip $VOLUMES_ROOT/es/plugins/elasticsearch-analysis-ik-6.8.4.zip


# docker 创建网络
echo "=========> 开始创建docker网络: searchlite_net"
docker network rm searchlite_net
docker network create \
--driver bridge \
--subnet 172.12.35.0/24 \
--gateway 172.12.35.1  searchlite_net


# 创建容器
docker-compose --project-name searchlite up -d

# 导入mysql数据
echo "=========> 开始导入数据到mysql"
mysql -uroot -p$MYSQL_ROOT_PASSWORD
source search_lite.sql


echo "=========> 开始打包SearchLiteService.jar"
mvn clean package --file ../SearchLiteService/pom.xml -DskipTests

echo "=========> 开始打包SearchWordCount.jar"
mvn clean package --file ../SearchWordCount/pom.xml -DskipTests

echo "=========> 开始打包SearchWordCount.jar"
mvn clean package --file ../SearcFrequency/pom.xml -DskipTests




