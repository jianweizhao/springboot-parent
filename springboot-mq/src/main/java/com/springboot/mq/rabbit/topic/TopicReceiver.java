package com.springboot.mq.rabbit.topic;

import com.springboot.mq.rabbit.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojw
 * Date: 2017/10/24
 * Time: 11:17
 *
 * @author: zhaojw
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

    private static Logger logger= LoggerFactory.getLogger(TopicReceiver.class);

    @RabbitHandler
    public void process(String message){
        logger.info("《1》接收到的消息：{}",message);
    }

}
