package com.springboot.base.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 16:19
 */
public class MainTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ResourceConfig.class);

        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.outputResource();

        context.close();
    }
}
