package com.yinqifang.aiya.server.mq.producer.impl;

import com.yinqifang.aiya.server.mq.producer.RabbitMQProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yin Qifang
 * @date 2021-12-04
 */
@Service
public class RabbitMQProducerImpl implements RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String exchangeName, String routingKey, String msg) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, msg);
    }

}
