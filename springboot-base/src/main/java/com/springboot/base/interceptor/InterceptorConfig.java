package com.springboot.base.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>
 *     逌过重写WebMvcConfigurer Adapter的addInterceptors方法来注册自定义的拦截器
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 21:18
 */
@Configuration
@ComponentScan("com.springboot.base.interceptor")
public class InterceptorConfig extends WebMvcConfigurerAdapter{

    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(demoInterceptor());
    }
}
