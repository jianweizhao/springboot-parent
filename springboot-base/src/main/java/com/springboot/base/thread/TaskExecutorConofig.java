package com.springboot.base.thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * springboot 实现多线程
 * @EnableAsync 注解支持开启异步
 * 配置类实现了AsyncConfigurer接口并重写了getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor
 * 这样我们就获得了一个基于线程池TaskExecutor
 *
 * @author zhaojw
 * @version 1.0
 * @date 2018/4/18 16:52
 */
@Configuration
@ComponentScan("com.springboot.base.thread")
@EnableAsync
public class TaskExecutorConofig implements AsyncConfigurer{


    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setQueueCapacity(25);
        executor.setMaxPoolSize(10);
        executor.initialize();
        return executor;
    }


    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
