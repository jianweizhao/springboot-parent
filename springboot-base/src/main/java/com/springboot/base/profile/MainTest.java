package com.springboot.base.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 *     context.getEnvironment().setActiveProfiles("dev");
 *     通过Environment的ActiveProfiles来设定当前context需要使用的配置环境，在开发中使用@Profile注解或者方法
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 23:24
 */
public class MainTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("dev");
        // 后置注册Bean配置类，因为此时并没有确定需要哪个环境，但是有两个环境
        context.register(ProfileConfig.class);
        // 刷新容器
        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);

        System.err.println(demoBean.getContent());

        context.close();
    }
}
