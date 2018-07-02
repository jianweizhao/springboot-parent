package com.springboot.base.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/25 20:34
 */
@RestController
@SpringBootApplication
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/index")
    public String index(){
        return helloService.sayHello();
    }

    public static void main(String[] args){
        SpringApplication.run(HelloController.class,args);
    }
}
