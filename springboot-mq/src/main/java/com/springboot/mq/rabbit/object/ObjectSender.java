package com.springboot.mq.rabbit.object;

import com.springboot.mq.rabbit.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by zhaojw
 * Date: 2017/10/24
 * Time: 9:35
 *
 * @author: zhaojw
 */
@Component
public class ObjectSender {

    private static Logger logger= LoggerFactory.getLogger(ObjectSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user){
        logger.info("发送对象消息：{}",user);
        this.amqpTemplate.convertAndSend("user",user);
    }
}
