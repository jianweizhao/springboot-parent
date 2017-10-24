package com.springboot.mq.rabbit;

import com.springboot.mq.SpringbootMqApplication;
import com.springboot.mq.rabbit.fanout.FanoutSender;
import com.springboot.mq.rabbit.model.User;
import com.springboot.mq.rabbit.object.ObjectSender;
import com.springboot.mq.rabbit.send.RabbitMqSender;
import com.springboot.mq.rabbit.send.RabbitMqSender2;
import com.springboot.mq.rabbit.topic.TopicSender;
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

    @Autowired
    private RabbitMqSender2 mqSender2;

    @Autowired
    private ObjectSender objectSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

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

    @Test
    public void 测试rabitmq多对多发送(){
        for(int i=1;i<11;i++){
            mqSender.send("第"+i+"次发送hello rabbitmq");
            mqSender2.send("第"+i+"次发送hello rabbitmq");
        }
    }

    @Test
    public void 测试rabbit发送对象消息(){
       objectSender.send(new User("zhaojw","25"));
    }

    @Test
    public void 测试TopicExchange(){
        topicSender.send1("topic.message");
        topicSender.send2(">>>>topic.messages");
    }

    @Test
    public void 测试测试Fanout(){
        fanoutSender.send1("Fanout Exchange");
    }
}
