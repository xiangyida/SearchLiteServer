#!/bin/bash

IK_PLUGIN_URL="https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.8.4/elasticsearch-analysis-ik-6.8.4.zip"
MYSQL_ROOT_PASSWORD="123456"
# 挂载目录
VOLUMES_ROOT="/docker/"
# 安装es插件
mkdir -p "$VOLUMES_ROOT/es/plugins"
wget -P /$VOLUMES_ROOT/es/plugins/ $IK_PLUGIN_URL
unzip $VOLUMES_ROOT/es/plugins/elasticsearch-analysis-ik-6.8.4.zip
echo "IK分词器已安装"

# docker 创建网络
docker network rm searchlite_net
docker network create \
--driver bridge \
--subnet 172.12.35.0/24 \
--gateway 172.12.35.1  searchlite_net
echo "已创建网络searchlite_net"

# 创建容器
docker-compose --project-name searchlite up -d

# 导入mysql数据
mysql -uroot -p$MYSQL_ROOT_PASSWORD
source search_lite.sql



