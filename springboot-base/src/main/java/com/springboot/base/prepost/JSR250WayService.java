package com.springboot.base.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <p>
 *     JSR250的
 *     @PostConstruct： 在构造函数执行完之后执行
 *     @PreDestroy ：在Bean销毁之前执行
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 17:53
 */
public class JSR250WayService {

    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService() {
        super();
        System.out.println("初始化构造函数-JSR250WayService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }
}
