package com.springboot.mq.rabbit.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojw
 * Date: 2017/10/24
 * Time: 17:36
 *
 * @author: zhaojw
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutRevicer2 {

    private static Logger logger= LoggerFactory.getLogger(FanoutRevicer2.class);

    @RabbitHandler
    public void revicer(String message){
        logger.info("B接收到消息:{}",message);
    }
}
