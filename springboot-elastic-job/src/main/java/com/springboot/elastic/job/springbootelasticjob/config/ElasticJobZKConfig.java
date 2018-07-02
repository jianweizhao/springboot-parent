package com.springboot.elastic.job.springbootelasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaojw
 * @version 1.0
 * @date 2018/3/26 19:23
 */
@Configuration
@ConditionalOnExpression("'${elasticJob.zk.serverLists}'.length()>0")
public class ElasticJobZKConfig {

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(@Value("${elasticJob.zk.serverLists}") final String serverList,
                                             @Value("${elasticJob.zk.namespace}") final String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }
}
