package com.forezp.thread.singleton;

public class SingletonByThreadLocal {

    private static final ThreadLocal<SingletonByThreadLocal> singleton = ThreadLocal.withInitial(SingletonByThreadLocal::new);

    private SingletonByThreadLocal () {}

    public static SingletonByThreadLocal getInstance() {
        return singleton.get();
    }

    public static void main(String[] args) {
        SingletonByThreadLocal s1 = SingletonByThreadLocal.getInstance();
        SingletonByThreadLocal s2 = SingletonByThreadLocal.getInstance();
        System.out.println(s1.equals(s2));
    }
}
