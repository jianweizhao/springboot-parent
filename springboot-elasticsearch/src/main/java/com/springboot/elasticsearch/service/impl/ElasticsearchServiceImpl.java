package com.springboot.elasticsearch.service.impl;

import com.springboot.elasticsearch.service.ElasticsearchService;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaojw
 * Date: 2017/10/30
 * Time: 12:41
 *
 * @author: zhaojw
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {

    private static Logger logger= LoggerFactory.getLogger(ElasticsearchServiceImpl.class);

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public boolean createIndex(String indexName) {
        return  elasticsearchTemplate.createIndex(indexName);
    }

    /**
     * 插入文档
     * mappings对应的key ： name：列名称   type：列类型   index：是否分词
     * @return
     */
    @Override
    public boolean putMapping(String indexName, String type, XContentBuilder xContentBuilder) {
        return elasticsearchTemplate.putMapping(indexName,type,xContentBuilder);
    }

    /**
     * 删除索引
     *
     * @param indexName
     * @return
     */
    @Override
    public boolean deleteIndex(String indexName) {
        return elasticsearchTemplate.deleteIndex(indexName);
    }
}
