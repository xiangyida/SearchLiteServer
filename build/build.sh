#!/bin/bash

# docker 创建网络
docker network rm searchlite_net
docker network create \
--driver bridge \
--subnet 172.12.35.0/24 \
--gateway 172.12.35.1  searchlite_net
# 运行sql脚本
#docker exec
#mysql -uroot  -p123456 -Dxyh_blog</blog_init.sql
