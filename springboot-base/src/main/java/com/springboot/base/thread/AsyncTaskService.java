package com.springboot.base.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     通过@Async 注解表明该方法是个异步方法，如果注解加载了类级别，则表明该类所有的方法都是异步法方法，
 *     而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor。
 * </p>
 *
 * @author zhaojw
 * @version 1.0
 * @date 2018/4/18 16:56
 */
@Service
public class AsyncTaskService {

    /**
     * 通过@Async 注解表明该方法是个异步方法，
     * @param i
     */
    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1：" + (i+1));
    }
}
