package com.springboot.mq.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhaojw on 2017/10/15.
 */
@Aspect
@Configuration
public class HttpAspject {

    private static Logger logger= LoggerFactory.getLogger(HttpAspject.class);

    @Pointcut("execution(* com.springboot.data.jpa.controller..*(..))")
    public void pointCut(){
      logger.info("进入切面");
    }

    /**
     * 打印url执行之前的日志
     * @param joinPoint
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("请求的url={}",request.getRequestURL());
        //方式
        logger.info("请求方式={}",request.getMethod());
        //ip
        logger.info("请求ip={}",request.getRemoteAddr());
        //请求执行的类方法
        logger.info("请求类方法={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //请求参数
        logger.info("请求参数={}",joinPoint.getArgs());
    }

    @AfterReturning(returning = "object",pointcut = "pointCut()")
    public void doAfterReturning(Object object){
        logger.info("返回respons={}",object);//object可以实现toString方法
    }
}
