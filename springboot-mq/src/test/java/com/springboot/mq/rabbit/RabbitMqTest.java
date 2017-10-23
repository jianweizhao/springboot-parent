package com.springboot.mq.rabbit;

import com.springboot.mq.SpringbootMqApplication;
import com.springboot.mq.rabbit.send.RabbitMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhaojw
 * Date: 2017/10/23
 * Time: 15:28
 *
 * @author: zhaojw
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMqApplication.class)
public class RabbitMqTest {

    @Autowired
    private RabbitMqSender mqSender;

    @Test
    public void 测试rabbitmq消息机制(){
        mqSender.send("hello rabbitmq");
    }

    @Test
    public void 测试rabbitmq一对多发送(){
        for (int i=0;i<10;i++){
            mqSender.send("第"+i+"次发送hello rabbitmq");
        }
    }
}
