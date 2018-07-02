package com.springboot.base.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *     c
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/22 20:51
 */
public class MainTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        DemoAnnotationService annotationService = context.getBean(DemoAnnotationService.class);

        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

        annotationService.addAnnotation();

        demoMethodService.addMethod();

        context.close();
    }
}
