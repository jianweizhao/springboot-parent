package com.springboot.base.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p>
 *     切面
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/22 20:14
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 注解的切点
     */
    @Pointcut("@annotation(com.springboot.base.aop.Action)")
    public void annotationPointCut(){}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截："+action.name());
    }

    @Before("execution(* com.springboot.base.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        Method method = signature.getMethod();
        System.out.println("方法式拦截："+method.getName());
    }
}
