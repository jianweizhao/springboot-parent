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
 * Time: 11:35
 *
 * @author: zhaojw
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {

    private static Logger logger= LoggerFactory.getLogger(TopicReceiver2.class);

    @RabbitHandler
    public void process(String user){
        logger.info("《2》接收到的对象消息：{}",user);
    }
}
