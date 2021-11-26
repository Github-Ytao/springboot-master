package com.tao.project.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author YangTao
 * @date 2021-11-14 20:54
 */
@Slf4j
@Component
public class AsyncTasks {

    private static Random random = new Random();

    @Async
    public CompletableFuture<String> doTaskOne() throws Exception {
        log.info("开始做任务一");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (endTime - startTime) + "毫秒");
        return CompletableFuture.completedFuture("完成任务一");
    }

    @Async
    public CompletableFuture<String> doTaskTwo() throws Exception {
        log.info("开始做任务二");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (endTime - startTime) + "毫秒");
        return CompletableFuture.completedFuture("完成任务二");
    }

    @Async
    public CompletableFuture<String> doTaskThree() throws Exception {
        log.info("开始做任务三");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (endTime - startTime) + "毫秒");
        return CompletableFuture.completedFuture("完成任务三");
    }
}
