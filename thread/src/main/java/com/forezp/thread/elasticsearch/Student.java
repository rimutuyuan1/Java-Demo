package com.forezp.thread.elasticsearch;

import lombok.Data;

@Data
public class Student{

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("被回收了");
    }

    public static void main(String[] args) {
        Student student = null;
        System.gc();
        student.setName("小红");
        System.out.println(student.toString());
    }

}
