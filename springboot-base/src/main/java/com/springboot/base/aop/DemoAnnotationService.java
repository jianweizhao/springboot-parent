package com.springboot.base.aop;

import org.springframework.stereotype.Service;

/**
 * <p>
 *     使用@Action注解的拦截类
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/22 20:11
 */
@Service
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void addAnnotation(){}
}
