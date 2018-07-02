package com.springboot.base.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaojw
 * @version 1.0
 * @date 2018/4/18 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainTest.class)
public class MainTest {

    @Test
    public void run() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConofig.class);

        AsyncTaskService taskService = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            taskService.executeAsyncTask(i);
            taskService.executeAsyncTaskPlus(i);
        }

        context.close();
    }
}
