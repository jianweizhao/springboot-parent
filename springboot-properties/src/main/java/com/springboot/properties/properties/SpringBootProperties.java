package com.springboot.properties.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 这里需要把此类放在与Application启动类放在同一个包下才能被扫描到后注册近Spring容器中。
 * 如果放在别处，需要在Application手动指定扫描报的路径。
 *
 */
@Component
@ConfigurationProperties(prefix = "springboot")
public class SpringBootProperties {

    private String email;

    private Integer age;

    private String content;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
