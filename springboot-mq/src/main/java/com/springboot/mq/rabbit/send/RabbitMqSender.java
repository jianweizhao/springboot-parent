package com.springboot.mq.rabbit.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaojw
 * Date: 2017/10/23
 * Time: 15:21
 *
 * @author: zhaojw
 */
@Component
public class RabbitMqSender {

    private static Logger logger= LoggerFactory.getLogger(RabbitMqSender.class);

    private static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        logger.info("发送消息为：{},发送时间为：{}",message,df.format(new Date()));
        this.amqpTemplate.convertAndSend("hello", message);
    }
}
