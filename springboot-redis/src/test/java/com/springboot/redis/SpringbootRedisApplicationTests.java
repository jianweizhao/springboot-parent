package com.springboot.redis;

import com.springboot.redis.entity.UserForRedis;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =SpringbootRedisApplication.class )
@Configuration
public class SpringbootRedisApplicationTests {


	private static Logger logger= LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;


	@Test
	public void 测试往redis中加String数据(){
		stringRedisTemplate.opsForValue().set("age","18");
		Assert.assertEquals("18",stringRedisTemplate.opsForValue().get("age"));
	}

	@Test
	public void redis存储对象() throws Exception{
		UserForRedis userForRedis=new UserForRedis("zhaojw","zhaojw_420@163.com","123456");
		ValueOperations<String,UserForRedis> operations=redisTemplate.opsForValue();
		operations.set("userForReis",userForRedis);
		operations.set("userForRedis2",userForRedis,1, TimeUnit.SECONDS);
		Thread.sleep(1000);

		if (redisTemplate.hasKey("userForRedis2")){
			logger.info("存在key》userForRedis2");
		}else{
			logger.info("不存在key》userForRedis2");
		}
	}

}
