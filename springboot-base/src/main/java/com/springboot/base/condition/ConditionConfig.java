package com.springboot.base.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 15:02
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(MacCondition.class)
    public ListService macListService(){
        return new MacListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService(){
        return new LinuxListSerivce();
    }
}
