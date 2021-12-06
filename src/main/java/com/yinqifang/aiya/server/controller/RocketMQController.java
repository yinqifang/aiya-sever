package com.yinqifang.aiya.server.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * RocketMQ接口类
 * @author Chris Yin
 * @date 2021-08-12
 */
//@Controller
@RequestMapping("/rocketmq")
public class RocketMQController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送消息
     */
    @ResponseBody
    @PostMapping("/send")
    public String sendMessage(@RequestParam("topic") String topic, @RequestParam("msg") String msg) {
        rocketMQTemplate.convertAndSend(topic, msg);

        return "发送成功：" + msg;
    }
}
