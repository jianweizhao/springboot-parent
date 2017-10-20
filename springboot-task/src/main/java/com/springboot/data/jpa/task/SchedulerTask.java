package com.springboot.data.jpa.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 17:00
 *
 * @author: zhaojw
 */
@Component
public class SchedulerTask {

    private static Logger logger= LoggerFactory.getLogger(SchedulerTask.class);

    private int count=0;

    public SchedulerTask(){
        logger.info("SchedulerTask>>>>>>>>已加载。。。。");
    }

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
