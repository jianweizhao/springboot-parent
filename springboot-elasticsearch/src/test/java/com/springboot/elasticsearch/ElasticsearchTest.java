package com.springboot.elasticsearch;

import com.springboot.elasticsearch.service.ElasticsearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhaojw
 * Date: 2017/10/30
 * Time: 14:01
 *
 * @author: zhaojw
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootElasticsearchApplication.class)
@Configuration
public class ElasticsearchTest {

    private  static Logger logger= LoggerFactory.getLogger(ElasticsearchTest.class);

    @Autowired
    private ElasticsearchService elasticsearchService;

    /**
     * 索引名称
     */
    @Value("${es.index.name}")
    private String indexName;

    /**
     * 文档类型
     */
    @Value("${es.type.name}")
    private String typeName;

    @Test
    public void 创建索引(){
       boolean result = elasticsearchService.createIndex(indexName);
        if (result){
            logger.info("创建成功");
        }
    }
}
