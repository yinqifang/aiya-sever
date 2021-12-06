package com.yinqifang.aiya.server.mq.consumer;

/**
 * @author Yin Qifang
 * @date 2021-12-04
 */
public interface MQConsumer {
    /**
     * 接收到消息后处理
     */
    void onMessage(String msg);
}
