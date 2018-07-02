package com.springboot.base.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;


/**
 * @author zhaojw
 * @version 1.0
 * @date 2018/4/18 16:15
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware,BeanFactoryAware{

    private String name;

    private ResourceLoader resourceLoader;

    private BeanFactory beanFactory;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void outputResult(){
        System.out.println("加载的BeanName的名称是:"+name);
        System.out.println("当前的BeanFactory的名称是："+beanFactory.getType(name));
        try {
            Resource resources = resourceLoader.getResource("classpath:test.txt");
            System.out.println("加载到的文件内容为："+ IOUtils.toString(resources.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
