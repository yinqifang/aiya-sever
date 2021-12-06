package com.yinqifang.aiya.server.mq.producer;

import com.yinqifang.aiya.server.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yin Qifang
 * @date 2021-12-04
 */
@Service
public class RabbitMQProducer implements MQProducer{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME_AIYA, RabbitMQConfig.ROUTING_KEY_AIYA, msg);
    }
}
