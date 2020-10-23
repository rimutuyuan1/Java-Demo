package com.forezp.thread;

import com.forezp.thread.aop.IUserInterface;
import com.forezp.thread.complatableFuture.CompletableFutureTest;
import com.forezp.thread.complatableFuture.FutureTaskWorker;
import com.forezp.thread.jdbc.JdbcTest;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;


@SpringBootTest
@RunWith(SpringRunner.class)
public class jdbcTests {

    @Autowired
    private JdbcTest stringTest;
    @Resource
    IUserInterface iUserInterface;
    @Resource
    private CompletableFutureTest futureTest;

    @Test
    public void jdbcTest() {
        stringTest.jdbcTest("王鑫涛", "25");
    }

    @Test
    public void test() {
        iUserInterface.query();
    }

    @Test
    public void test1() {
        List<String> list = Lists.newArrayList("王鑫涛", "马高伟", "李振", "马高伟2", "李振3",  "马高伟3", "李振4");
        Map<String, CompletableFutureTest.Student> map = Maps.newHashMap();
        list.forEach(o -> {
            try {
                CompletableFutureTest.Student student = new CompletableFutureTest.Student();
                student.setName(CompletableFuture.supplyAsync(() -> futureTest.buildName("zhangsan")).get());
                student.setSex(CompletableFuture.supplyAsync(() -> futureTest.buildSex("男")).get());
                student.setAge(CompletableFuture.supplyAsync(() -> futureTest.buildAge("18")).get());
                map.put(o, student);
            } catch (Exception e) {
                System.out.println("error");
            }
        });
        System.out.println(map);
    }

    @Test
    public void testFuture() {
        List<Long> list = new ArrayList<>(3);
        list.add(1000L);
        list.add(2000L);
        list.add(3000L);
        FutureTaskWorker<Long,String> futureTaskWorker = new FutureTaskWorker<>(list, this::getThreadName);
        long begin = System.currentTimeMillis();
        List<String> allResult = futureTaskWorker.getAllResult();
        long end = System.currentTimeMillis();
        System.out.println(allResult);
        System.out.println("结束耗时:"+(end-begin));
    }

    private CompletableFuture<String> getThreadName(long sleepTime) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(sleepTime);
                System.out.println(Thread.currentThread().getName()+"已经睡眠"+sleepTime+"毫秒");
                return Thread.currentThread().getName();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

}
