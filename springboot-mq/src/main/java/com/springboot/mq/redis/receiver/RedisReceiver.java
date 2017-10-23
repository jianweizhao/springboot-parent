package com.springboot.mq.redis.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhaojw
 * Date: 2017/10/23
 * Time: 10:13
 *
 * @author: zhaojw
 */
public class RedisReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);

    private CountDownLatch latch;

    @Autowired
    public RedisReceiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("收到消息，消息内容： <{} >",message);
        latch.countDown();
    }
}
