package com.springboot.base.junit;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 *     @ContextConfiguration(classes = {TestConfig.class}) 用来加载ApplicationContext，其中classes属性用来加载配置类
 *     @ActiveProfiles("pro") 用来生命活动的profile
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 17:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("pro")
public class MainTest {
}
