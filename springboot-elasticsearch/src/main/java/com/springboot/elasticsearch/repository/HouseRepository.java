package com.springboot.elasticsearch.repository;

import com.springboot.elasticsearch.document.HouseDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhaojw
 * Date: 2017/10/30
 * Time: 10:46
 *
 * @author: zhaojw
 */
@Repository
public interface HouseRepository extends ElasticsearchRepository<HouseDocument,Long> {

}
