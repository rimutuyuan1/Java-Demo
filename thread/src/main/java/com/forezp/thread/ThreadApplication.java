package com.forezp.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@Repository
@SpringBootApplication
public class ThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadApplication.class, args);

        Dog dog = new Dog() {
            @Override
            public String say() {
                return "hello cat";
            }
        };
        System.out.println(dog.say());
    }

    Dog.Cat cat = new Dog.Cat();


}
