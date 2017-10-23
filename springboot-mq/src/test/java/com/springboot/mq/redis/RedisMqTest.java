package com.springboot.mq.redis;

import com.springboot.mq.SpringbootMqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhaojw
 * Date: 2017/10/23
 * Time: 10:46
 *
 * @author: zhaojw
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMqApplication.class)
public class RedisMqTest {

    private static Logger logger= LoggerFactory.getLogger(RedisMqTest.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private CountDownLatch latch;

    @Test
    public void 测试redisMq() throws Exception{
        logger.info("开始发送消息了。。。。");
        redisTemplate.convertAndSend("chat","hello redis mq");
        latch.await();
    }
}
