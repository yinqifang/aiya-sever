package com.yinqifang.aiya.server.mq.consumer.impl;

import com.yinqifang.aiya.server.mq.consumer.RabbitMQConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author Yin Qifang
 * @date 2021-12-06
 */
@Service
@Slf4j
public class RabbitMQConsumerImpl implements RabbitMQConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String receive(String queueName) {
        Message msg = rabbitTemplate.receive(queueName);
        if (msg == null) {
            log.info("No message find");
            return null;
        }
        return new String(msg.getBody(), StandardCharsets.UTF_8);
    }

    //    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_AIYA)
    //    public void listen(String msg) {
    //        this.onMessage(msg);
    //    }
    //
    //    @Override
    //    public void onMessage(String msg) {
    //        log.info("Got message: {}", msg);
    //    }

}
