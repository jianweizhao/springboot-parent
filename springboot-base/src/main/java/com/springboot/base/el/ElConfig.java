package com.springboot.base.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * <p>
 *     注入配置文件需要使用@PropertySource指定文件地址，若使用@Value注入，则需要配置一个PropertySourcesPlaceholderConfigurer的Bean
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/23 16:03
 */
@Configuration
@ComponentScan("com.springboot.base.el")
@PropertySource("classpath:test.properties")
public class ElConfig {
    /**
     * 注入普通的字符串
     */
    @Value("I love you")
    private String normal;

    /**
     * 注入操作系统的属性
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 注入表达式的结构
     */
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private String randomNumber;

    /**
     * 注入其他bean的属性
     */
    @Value("#{demoService.other}")
    private String fromAnother;

    /**
     * 注入文件资源
     */
    @Value("classpath:test.properties")
    private Resource testFile;

    /**
     * 注入网址资源
     */
    @Value("http://www.baidu.com")
    private Resource testUrl;

    /**
     * 注入配置文件
     */
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    /**
     * 启用@Value的使用
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println("normal:"+normal);
            System.out.println("osName"+osName);
            System.out.println("randomNumber:"+randomNumber);
            System.out.println("fromAnother:"+fromAnother);
            System.out.println("testFile:"+IOUtils.toString(testFile.getInputStream()));
            System.out.println("testUrl:"+IOUtils.toString(testUrl.getInputStream()));
            System.out.println("bookName:"+bookName);
            System.out.println("bookAuthor:"+environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
