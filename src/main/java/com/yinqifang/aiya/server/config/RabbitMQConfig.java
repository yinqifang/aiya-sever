package com.yinqifang.aiya.server.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yin Qifang
 * @date 2021-12-06
 */
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME_AIYA = "queue.aiya";
    public static final String EXCHANGE_NAME_AIYA = "exchange.aiya";
    public static final String ROUTING_KEY_AIYA = "routing.aiya";

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME_AIYA);
    }

    @Bean
    public Exchange myExchange() {
        return new DirectExchange(EXCHANGE_NAME_AIYA);
    }

    @Bean
    public Binding myBinding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(myQueue()).to(myExchange()).with(ROUTING_KEY_AIYA).noargs();
    }
}
