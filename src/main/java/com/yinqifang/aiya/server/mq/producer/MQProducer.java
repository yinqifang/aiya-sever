package com.yinqifang.aiya.server.mq.producer;

/**
 * @author Yin Qifang
 * @date 2021-12-04
 */
public interface MQProducer {
    /**
     * 发送消息
     * @param msg
     */
    void sendMsg(String msg);
}
