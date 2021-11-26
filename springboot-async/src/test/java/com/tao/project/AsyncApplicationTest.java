package com.tao.project;

import com.tao.project.component.AsyncTasks;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

/**
 * @author YangTao
 * @date 2021-11-14 20:59
 */
@Slf4j
@SpringBootTest
class AsyncApplicationTest {

    @Autowired
    AsyncTasks asyncTasks;

    @Test
    void contextLoads() throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<String> task1 = asyncTasks.doTaskOne();
        CompletableFuture<String> task2 = asyncTasks.doTaskTwo();
        CompletableFuture<String> task3 = asyncTasks.doTaskThree();

        CompletableFuture.allOf(task1, task2, task3).join();

        long end = System.currentTimeMillis();

        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}