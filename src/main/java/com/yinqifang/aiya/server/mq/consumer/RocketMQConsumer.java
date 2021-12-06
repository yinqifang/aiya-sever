package com.yinqifang.aiya.server.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.springframework.stereotype.Service;

/**
 * @author Chris Yin
 * @date 2021-08-12
 */
//@Service
@Slf4j
@RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1")
//@RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-2")
public class RocketMQConsumer implements MQConsumer {
    @Override
    public void onMessage(String msg) {
        log.info("received message: {}", msg);
    }

    //    @Service
    //    @RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1")
    //    public class MyConsumer1 implements RocketMQListener<String> {
    //        public void onMessage(String message) {
    //            log.info("received message: {}", message);
    //        }
    //    }
    //
    //    @Slf4j
    //    @Service
    //    @RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-2")
    //    public class MyConsumer2 implements RocketMQListener<RocketMQProducer.OrderPaidEvent> {
    //        public void onMessage(RocketMQProducer.OrderPaidEvent orderPaidEvent) {
    //            log.info("received orderPaidEvent: {}", orderPaidEvent);
    //        }
    //    }
}
