package com.springboot.base.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 14:33
 */
@Service
public class DemoScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate属性设置每隔固定时间执行
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次" + dateFormat.format(new Date()));
    }

    /**
     * cron属性可以设置指定时间执行，cron表达式跟linux一样
     */
    @Scheduled(cron = "0 45 14 ? * *")
    public void fixTimeExecution() {
        System.out.println("指定时间 "+dateFormat.format(new Date())+"执行");
    }
}
