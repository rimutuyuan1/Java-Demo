package com.forezp.thread.innerClass;

class Outerr{

    static Inter method() {
        return () -> System.out.println("hello world");
    }
}
