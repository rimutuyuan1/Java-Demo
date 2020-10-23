package com.forezp.thread.complatableFuture;

import lombok.Data;
import org.springframework.stereotype.Service;


/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/10/22 10:50 下午
 **/
@Service
public class CompletableFutureTest {

    public String buildName(String name) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }
    public String buildSex(String sex) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sex;
    }
    public String buildAge(String age) {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return age;
    }

    @Data
    public static class Student {
        private String name;
        private String sex;
        private String age;
    }
}
