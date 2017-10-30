package com.springboot.elasticsearch.service;

import org.elasticsearch.common.xcontent.XContentBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created by zhaojw
 * Date: 2017/10/30
 * Time: 12:18
 * 操作elasticsearch节点
 * @author: zhaojw
 */
public interface ElasticsearchService {
    /**
     * 创建索引
     * @param indexName
     * @return
     */
    boolean createIndex(String indexName);

    /**
     * 插入文档
     * @return
     */
    boolean putMapping(String indexName, String type, XContentBuilder xContentBuilder);

    /**
     * 删除索引
     * @param indexName
     * @return
     */
    boolean deleteIndex(String indexName);
}
