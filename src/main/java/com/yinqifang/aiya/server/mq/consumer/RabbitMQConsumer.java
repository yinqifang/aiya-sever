package com.yinqifang.aiya.server.mq.consumer;

import com.yinqifang.aiya.server.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Yin Qifang
 * @date 2021-12-06
 */
@Service
@Slf4j
public class RabbitMQConsumer implements MQConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_AIYA)
    public void listen(String msg) {
        this.onMessage(msg);
    }

    @Override
    public void onMessage(String msg) {
        log.info("Got message: {}", msg);
    }
}
