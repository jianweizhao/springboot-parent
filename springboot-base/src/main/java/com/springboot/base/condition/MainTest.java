package com.springboot.base.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 15:05
 */
public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.err.println(context.getEnvironment().getProperty("os.name")+"系统下的列表命令是："+
                listService.showListCmd());

        context.close();

    }
}
