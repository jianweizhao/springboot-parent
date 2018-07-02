package com.springboot.base.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 事件发布类，使用容器发布
 * 使用publishEvent发布
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 23:47
 */
@Component
public class DemoPublisher {
    /**
     * 使用容器发布
     */
    @Autowired
    private ApplicationContext context;

    public void publish(String msg) {
        context.publishEvent(new DemoEvent(this,msg));
    }
}
