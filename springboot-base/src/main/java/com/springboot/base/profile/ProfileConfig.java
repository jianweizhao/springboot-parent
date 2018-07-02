package com.springboot.base.profile;

import org.springframework.context.annotation.*;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 23:22
 */
@Configuration
@ComponentScan("com.springboot.base.profile")
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean(){
        return new DemoBean("from devDemoBean profile");
    }

    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean(){
        return new DemoBean("from prodDemoBean profile");
    }
}
