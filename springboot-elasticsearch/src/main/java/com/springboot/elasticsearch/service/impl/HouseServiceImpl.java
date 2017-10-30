package com.springboot.elasticsearch.service.impl;

import com.springboot.elasticsearch.repository.HouseRepository;
import com.springboot.elasticsearch.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/30
 * Time: 11:03
 *
 * @author: zhaojw
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;


}
