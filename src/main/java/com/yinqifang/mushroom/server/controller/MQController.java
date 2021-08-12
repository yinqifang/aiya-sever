package com.yinqifang.mushroom.server.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chris Yin
 * @date 2021-08-12
 */
@Controller
@RequestMapping("/mq")
public class MQController {

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
