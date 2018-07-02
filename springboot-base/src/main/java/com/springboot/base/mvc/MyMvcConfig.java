package com.springboot.base.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * <p>
 * @EnableWebMvc 开启spring对webmvc的支持
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/24 17:30
 */
@Configuration
@ComponentScan("com.springboot.base.mvc")
@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 视图解析器的配置
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("页面的局路径（到文件夹）");
        // 文件类型
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        return viewResolver;
    }

    /**
     * addResourceLocations指的是文件放置的目录， addResourceHandler指的是对外暴露的访问路径。
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("值对外访问暴露的访问路径").addResourceLocations("静态文件的访问文件夹,");
    }
}
