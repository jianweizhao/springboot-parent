package com.springboot.base.aop;

import java.lang.annotation.*;

/**
 * <p>
 * 注解本身是没有功能的， 就和xml 一样。注解和xml都是一种元数据，元数据即解释数据的数据， 这就是所谓配置。
   注解的功能来自用这个注解的地方。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/22 20:08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
