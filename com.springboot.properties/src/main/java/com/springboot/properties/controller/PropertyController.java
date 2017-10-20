package com.springboot.properties.controller;

import com.springboot.properties.properties.SpringBootProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 19:42
 *
 * @author: zhaojw
 */
@RestController
public class PropertyController {

    @Value("${email}")
    private String email;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(String name){
        return "hello spring boot! age: "+age+" email:"+email+" content:"+content+" name:"+name;
    }

    @Autowired
    private SpringBootProperties springBootProperties;

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String say1(){
        return "hello spring boot! email:"+springBootProperties.getEmail()+" age"+springBootProperties.getAge()+" content:"+springBootProperties.getContent();
    }
}
