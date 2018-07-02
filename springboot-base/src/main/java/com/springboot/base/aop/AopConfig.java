package com.springboot.base.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>
 *     配置类，开启aop的支持
 *     @EnableAspectJAutoProxy: 开启pring对Aspectj的代理的支持
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/22 20:49
 */
@Configuration
@ComponentScan("com.springboot.base.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
