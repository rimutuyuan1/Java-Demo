package com.forezp.thread;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
@SpringBootApplication
public class ThreadApplication {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
        String format = localDateTime.format(dtf);
        System.out.println(format);
    }



}
