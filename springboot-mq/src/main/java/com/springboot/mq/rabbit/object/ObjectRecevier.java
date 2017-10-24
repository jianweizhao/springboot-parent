package com.springboot.mq.rabbit.object;

import com.springboot.mq.rabbit.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojw
 * Date: 2017/10/24
 * Time: 9:39
 *
 * @author: zhaojw
 */
@Component
@RabbitListener(queues = "user")
public class ObjectRecevier {

    private static Logger logger= LoggerFactory.getLogger(ObjectRecevier.class);

    @RabbitHandler
    public void process(User user){
        logger.info("接受对象消息：{}",user);
    }
}
