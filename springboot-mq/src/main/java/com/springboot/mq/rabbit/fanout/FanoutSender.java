package com.springboot.mq.rabbit.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojw
 * Date: 2017/10/24
 * Time: 17:32
 *
 * @author: zhaojw
 */
@Component
public class FanoutSender {

    private static Logger logger= LoggerFactory.getLogger(FanoutSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1(String message){
      logger.info("发送消息:{}",message);
        this.amqpTemplate.convertAndSend("fanoutExchange","",message);
    }
}
