package com.springboot.base.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 *     自定义自动加载属性
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/25 20:18
 */
@Data
@ConfigurationProperties(prefix = "hello.zhaojw")
public class HelloServiceProperties {

    private static final String MESSAGE = "world";

    private String message = MESSAGE;
}
