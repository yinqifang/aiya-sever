package com.yinqifang.aiya.server.vo;

import lombok.Data;

/**
 * 发送消息请求入参
 * @author Yin Qifang
 * @date 2022-02-15
 */
@Data
public class RabbitMQSendRequestVO {
    /**
     * 交换机名称
     */
    private String exchangeName;
    /**
     * routing key
     */
    private String routingKey;
    /**
     * 消息内容
     */
    private String msg;
}
