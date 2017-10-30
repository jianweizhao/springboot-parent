package com.springboot.elasticsearch.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * Created by zhaojw
 * Date: 2017/10/30
 * Time: 11:18
 * 封装对elasticsearch的节点操作，例如：创建索引以及文档类型
 * @author: zhaojw
 */
@Configuration
public class ElasticsearchConfig {

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client){
        return new ElasticsearchTemplate(client);
    }
}
