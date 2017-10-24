package com.springboot.mq.rabbit.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojw
 * Date: 2017/10/23
 * Time: 15:23
 *
 * @author: zhaojw
 */
@Component
@RabbitListener(queues = "hello")
public class RabbitMqReceiver2 {

    private static Logger logger= LoggerFactory.getLogger(RabbitMqReceiver2.class);

    @RabbitHandler
    public void process(String message) {
        logger.info("监听器《2》接收到消息：{}",message);
    }
}
