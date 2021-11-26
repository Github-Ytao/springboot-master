package com.tao.project.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Service;

/**
 * @author YangTao
 * @date 2021-11-14 19:44
 */
@Slf4j
@Service
public class MySimpleJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("MySimpleJob start : tao.com {}", System.currentTimeMillis());
    }
}
