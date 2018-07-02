package com.springboot.base.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>
 *     @EnableScheduling : 开启计划任务的支持
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 14:39
 */
@Configuration
@ComponentScan("com.springboot.base.schedule")
@EnableScheduling
public class ScheduledTaskConfig {
}
