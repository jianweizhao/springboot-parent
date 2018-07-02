package com.springboot.base.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     ApplicationListener<DemoEvent>：指定监听事件的类型
 *     实现onApplicationEvent方法对消息进行接受处理
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 23:44
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent>{

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.err.println("监听器DemoListener接收到了DemoPublisher发布的消息："+msg);
    }
}
