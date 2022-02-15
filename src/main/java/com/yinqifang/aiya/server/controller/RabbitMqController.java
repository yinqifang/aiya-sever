package com.yinqifang.aiya.server.controller;

import com.yinqifang.aiya.server.config.RabbitMQConfig;
import com.yinqifang.aiya.server.mq.consumer.RabbitMQConsumer;
import com.yinqifang.aiya.server.mq.producer.RabbitMQProducer;
import com.yinqifang.aiya.server.vo.RabbitMQReceiveRequestVO;
import com.yinqifang.aiya.server.vo.RabbitMQSendRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String send(@RequestBody RabbitMQSendRequestVO param) {
        String exchangeName = param.getExchangeName();
        String routingKey = param.getRoutingKey();
        String msg = param.getMsg();
        producer.sendMsg(exchangeName, routingKey, msg);
        return msg;
    }

    /**
     * 接收一条消息
     */
    @PostMapping("/receive")
    public String receive(@RequestBody RabbitMQReceiveRequestVO param) {
        String queueName = param.getQueueName();
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
