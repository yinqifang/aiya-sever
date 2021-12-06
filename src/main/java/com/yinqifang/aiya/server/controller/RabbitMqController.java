package com.yinqifang.aiya.server.controller;

import com.yinqifang.aiya.server.mq.producer.MQProducer;
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
    private MQProducer mqProducer;

    @PostMapping("/send")
    public String send(@RequestParam("msg") String msg) {
        mqProducer.sendMsg(msg);
        return msg;
    }
}
