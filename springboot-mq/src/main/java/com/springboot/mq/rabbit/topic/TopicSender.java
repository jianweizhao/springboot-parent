package com.springboot.mq.rabbit.topic;

import com.springboot.mq.rabbit.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojw
 * Date: 2017/10/24
 * Time: 10:59
 *
 * @author: zhaojw
 */
@Component
public class TopicSender {

    private static Logger logger= LoggerFactory.getLogger(TopicSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息
     * @param message
     */
    public void send1(String message){
        logger.info("《1》发送消息:{}",message);
        this.amqpTemplate.convertAndSend("topicExchange","topic.message",message);
    }

    /**
     * 发送send2只有topic.#可以匹配所有只有Receiver2监听到消息
     * @param message
     */
    public void send2(String message){
        logger.info("《2》发送对象消息：{}",message);
        this.amqpTemplate.convertAndSend("topicExchange","topic.messages",message);
    }
}
