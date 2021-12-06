package com.yinqifang.aiya.server.mq.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Chris Yin
 * @date 2021-08-09
 */
//@Service
@Slf4j
public class RocketMQProducer implements MQProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMsg(String msg) {
        log.info("Start to send message...");
        //send message synchronously
        rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
        //send spring message
        rocketMQTemplate
            .send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        //        //send messgae asynchronously
        //        rocketMQTemplate
        //            .asyncSend("test-topic-2", new OrderPaidEvent("T_001", new BigDecimal("88.00")), new
        //            SendCallback() {
        //                @Override
        //                public void onSuccess(SendResult var1) {
        //                    System.out.printf("async onSucess SendResult=%s %n", var1);
        //                }
        //
        //                @Override
        //                public void onException(Throwable var1) {
        //                    System.out.printf("async onException Throwable=%s %n", var1);
        //                }
        //
        //            });
        //        //Send messages orderly
        //        rocketMQTemplate
        //            .syncSendOrderly("orderly_topic", MessageBuilder.withPayload("Hello, World").build(), "hashkey");
        //
        //        // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this
        //        rocketMQTemplate
        //        //rocketMQTemplate.destroy();
        log.info("Finished to send message...");
    }

    @Data
    @AllArgsConstructor
    public class OrderPaidEvent implements Serializable {
        private String orderId;
        private BigDecimal paidMoney;
    }

}
