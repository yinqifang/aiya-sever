package com.yinqifang.aiya.server.controller;

import com.yinqifang.aiya.server.config.RabbitMQConfig;
import com.yinqifang.aiya.server.mq.consumer.RabbitMQConsumer;
import com.yinqifang.aiya.server.mq.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yin Qifang
 * @date 2021-12-04
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {

    @Autowired
    private RabbitMQProducer producer;
    @Autowired
    private RabbitMQConsumer consumer;

    /**
     * 发送一条消息
     */
    @PostMapping("/send")
    public String send(@RequestParam("exchangeName") String exchangeName, @RequestParam("routingKey") String routingKey,
        @RequestParam("msg") String msg) {
        producer.sendMsg(exchangeName, routingKey, msg);
        return msg;
    }

    /**
     * 接收一条消息
     */
    @PostMapping("/receive")
    public String receive(@RequestParam("queueName") String queueName) {
        return consumer.receive(queueName);
    }

    /**
     * 测试
     */
    @PostMapping("/sendDemo")
    public String sendDemo(@RequestParam("msg") String msg) {
        producer.sendMsg(RabbitMQConfig.EXCHANGE_NAME_AIYA, RabbitMQConfig.ROUTING_KEY_AIYA, msg);
        return msg;
    }
}
