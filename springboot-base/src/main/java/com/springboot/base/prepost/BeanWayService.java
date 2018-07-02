package com.springboot.base.prepost;

/**
 * <p>
 *      @Bean 形式的bean的初始化与销毁
 *      使用@Bean的initMethod和destroyMethod，相当于xml配置的init-method和destroy-method
 * </p>
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 17:48
 */
public class BeanWayService {

    public void init() {
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        super();
        System.out.println("初始化构造函数-BeanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}
