package com.forezp.thread.atomicAndOther;

import com.forezp.thread.annoations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO 知识点 cas
 * TODO 工作内存：一个线程独享的内存  主内存：就是内存
 * TODO cas的核心是  当前线程工作内存的值如果和主内存的值不一致 则不替换  如果一致  则替换
 * TODO CompareAndSwap cas 比较和替换
 *
 * */
@ThreadSafe
public class CountExampleAtomic {

    private static final Logger logger = LoggerFactory.getLogger(CountExampleAtomic.class);

    private static int threadTotal = 200;
    private static int clientTotal = 5000;
    static final CountDownLatch countDownLatch = new CountDownLatch(threadTotal);

    private static AtomicInteger count  = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++ ) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e) {
                    logger.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        exec.shutdown();
        logger.info(String.format("count : {%d}", count.get()));
    }

    private static void add() {
        count.incrementAndGet();//先增加再获取
        //count.getAndIncrement(); 先获取再增加
    }
}
