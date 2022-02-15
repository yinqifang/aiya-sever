package com.yinqifang.aiya.server.vo;

import lombok.Data;

/**
 * 接收消息请求入参
 *
 * @author Yin Qifang
 * @date 2022-02-15
 */
@Data
public class RabbitMQReceiveRequestVO {
    /**
     * 队列名称
     */
    private String queueName;
}
