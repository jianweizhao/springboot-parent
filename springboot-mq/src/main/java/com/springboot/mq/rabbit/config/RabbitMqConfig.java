package com.springboot.mq.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhaojw
 * Date: 2017/10/23
 * Time: 15:19
 *
 * @author: zhaojw
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue(){
       return new Queue("hello");
    }

    @Bean
    public Queue userQuene(){
        return new Queue("user");
    }
}
