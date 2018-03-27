package com.springboot.elastic.job.springbootelasticjob.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhaojw
 * @version 1.0
 * @date 2018/3/26 17:46
 */
@Slf4j
@Component("elasticJobTask")
public class ElasticJobTask implements SimpleJob{

    private static final String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("当前执行任务的时间是：", DateFormatUtils.format(new Date(),DATE_FORMAT));
    }
}
