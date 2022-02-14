package com.yinqifang.aiya.server.mq.consumer;

/**
 * @author Yin Qifang
 * @date 2021-12-06
 */
public interface RabbitMQConsumer {

    /**
     * 读取队列中的一条消息
     */
    String receive(String queueName);
}
