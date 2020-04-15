package com.forezp.thread.singleton;

public class SingletonByThreadLocal {

    private static final ThreadLocal<SingletonByThreadLocal> singleton = ThreadLocal.withInitial(SingletonByThreadLocal::new);

    private SingletonByThreadLocal () {}

    static SingletonByThreadLocal getInstance() {
        return singleton.get();
    }

}
