package com.springboot.base.autoconfig;

import lombok.Data;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/25 20:21
 */
@Data
public class HelloService {

    private String message;

    public String sayHello(){
        return "Hello"+message;
    }
}
