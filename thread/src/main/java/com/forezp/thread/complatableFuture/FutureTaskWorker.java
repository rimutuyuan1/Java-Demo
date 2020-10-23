package com.forezp.thread.complatableFuture;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/10/22 11:39 下午
 **/
@Data
@AllArgsConstructor
public class FutureTaskWorker<T, R> {

    /**
     * @description 需要异步执行的任务
     */
    private List<T> taskList;
    /**
     * @description 需要执行的方法
     */
    private Function<T, CompletableFuture<R>> workFunction;

    /**
     * @description 搜集执行结果
     * @author gang.tu
     * @return: java.util.List<R>
     */
    public List<R> getAllResult() {
        List<CompletableFuture<R>> futureList = taskList.stream().map(workFunction).collect(Collectors.toList());
        CompletableFuture<Void> allCompletableFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        return allCompletableFuture.thenApply(e -> futureList.stream().map(CompletableFuture::join).collect(Collectors.toList())).join();
    }
}
