# aiya-sever
## 关于aiya
字母计划系列的首个项目，取哎呀谐音，目标是提供一个C/S结构的本地化工具用于提升办公效率
## 服务端开发语言
Java
## 说明
* RocketMQ在windows命令行启动时，需要使用jdk1.8，且jdk目录不能包含空格（例如Program Files目录就有问题）
## 脚本
### 启动RocketMQ NamerSrv
~~~
nohup sh bin/mqnamesrv &
~~~
### 启动RocketMQ Broker
~~~
nohup sh bin/mqbroker -n XX.XX.XX.XX:9876 -c conf/broker.conf autoCreateTopicEnable=true &
~~~
### 关闭RocketMQ Broker
~~~
sh bin/mqshutdown broker
~~~
## 参考文档
* [RocketMQ Quick Start](https://rocketmq.apache.org/docs/quick-start/)
* [RocketMQ 开发者指南](https://github.com/apache/rocketmq/tree/master/docs/cn)
* [RocketMQ Console（Web管理）](https://github.com/apache/rocketmq-externals/tree/master/rocketmq-console)
* [RocketMQ 配置外网可访问](https://blog.csdn.net/kkgbn/article/details/78255471)
* [RocketMQ 配置公网可访问](https://blog.csdn.net/hekf2010/article/details/81080755)