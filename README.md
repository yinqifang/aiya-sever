# aiya-sever
## 关于aiya
字母计划系列的首个项目，取哎呀谐音，目标是提供一个C/S结构的本地化工具用于提升办公效率
## 服务端开发语言
Java
## 说明
* 初期计划使用RocketMQ，结果发现没有对应的Python客户端，于是转向RabbitMQ。
* RocketMQ在windows命令行启动时，需要使用jdk1.8，且jdk目录不能包含空格（例如Program Files目录就有问题）
## 脚本
### 启动RabbitMQ
* Windows  
开始菜单有启动命令
Win+Q, RabbitMQ Service - start
* CentOS  
设置自动启动
    ~~~
    chkconfig rabbitmq-server on
    ~~~
  启动
    ~~~
    /sbin/service rabbitmq-server start
    ~~~
### 查看RabbitMQ状态
* Windows  
rabbitmqctl.bat脚本在安装目录的sbin目录下
    ~~~
    rabbitmqctl.bat status
    ~~~
* CentOS
    ~~~
    /sbin/service rabbitmq-server status
    ~~~
### 停止RabbitMQ
* Windows  
rabbitmqctl.bat脚本在安装目录的sbin目录下
    ~~~
    rabbitmqctl.bat stop
    ~~~
* CentOS
    ~~~
    /sbin/service rabbitmq-server stop
    ~~~
### 启用RabbitMQ管理插件
管理页面地址: http://{node-hostname}:15672/
~~~
rabbitmq-plugins enable rabbitmq_management
~~~
### RabbitMQ添加用户
* 查看用户
    ~~~
    rabbitmqctl list_users
    ~~~
* 创建用户
    ~~~
    rabbitmqctl add_user {username} {password}
    ~~~
* 授权管理员
    ~~~
    rabbitmqctl set_user_tags {username} administrator
    ~~~
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
* [RabbitMQ安装-Windows](https://www.rabbitmq.com/install-windows.html#installer)
* [RabbitMQ安装-CentOS 8](https://www.rabbitmq.com/install-rpm.html#apt-cloudsmith)
* [RabbitMQ管理插件](https://www.rabbitmq.com/management.html)
* [RabbitMQ Exchange介绍](https://www.javainuse.com/messaging/rabbitmq/exchange)
* [RocketMQ Quick Start](https://rocketmq.apache.org/docs/quick-start/)
* [RocketMQ 开发者指南](https://github.com/apache/rocketmq/tree/master/docs/cn)
* [RocketMQ Console（Web管理）](https://github.com/apache/rocketmq-externals/tree/master/rocketmq-console)
* [RocketMQ 配置外网可访问](https://blog.csdn.net/kkgbn/article/details/78255471)
* [RocketMQ 配置公网可访问](https://blog.csdn.net/hekf2010/article/details/81080755)