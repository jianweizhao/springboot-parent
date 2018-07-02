package com.springboot.base.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 17:58
 */
public class MainTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);

        // 鄙人认为这里没有必要了，context已经加载了配置文件上下文，配置文件中已经将两者放入了Spring容器中，即执行了初始化，
        // context关闭，容器关闭后执行销毁
        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);

        context.close();
    }
}
