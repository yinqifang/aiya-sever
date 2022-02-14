package com.yinqifang.aiya.server.mq.producer;

/**
 * RabbitMQ消息发送
 *
 * @author Yin Qifang
 * @date 2021-12-04
 */
public interface RabbitMQProducer {

    /**
     * 发送消息
     *
     * @param msg          消息内容
     * @param exchangeName exchange名称
     * @param routingKey   routingKey名称
     */
    void sendMsg(String exchangeName, String routingKey, String msg);
}
