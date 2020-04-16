package com.forezp.thread;

import com.forezp.thread.singleton.SingletonTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@EnableAspectJAutoProxy
@SpringBootApplication
public class ThreadApplication extends SpringBootServletInitializer implements CommandLineRunner {

    static {
        SingletonTest singletonTest = SingletonTest.getInstance();
        SingletonTest singletonTest1 = SingletonTest.getInstance();
    }

    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(ThreadApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        System.out.println("get all springboot beans :");
        for (String bean : beans)
        {
            System.out.println(bean + "  -------->  " + appContext.getBean(bean).getClass());
        }
    }
}
