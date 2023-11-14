package com.forezp.thread.singleton;

import org.springframework.stereotype.Component;

@Component
public class SingletonTest {

    // 单例模式  --> 不能用构造方法去构造实例对象  只能通过类的静态方法 在程序启动的时候在类的内部创造一个全局唯一的实例 getInstance()

    // 单例模式下 构造方法使用private禁止外部new SingletonTest()来确保全局只有一个singletonTest实例
    // line15  双检锁第一个if判断  可以省略 但是如果省略效率会降低
    // 因为第一个判断去掉之后 无论singletonTest是否已经被实例化 都会走synchronized(line17) -> 加锁严重消耗性能

    // line17 加synchronized是因为防止多个线程同时调用getInstance方法同时实例化singletonTest对象

    // 第四个注意点：getInstance方法中的第二个判空条件是不可以去除，如果去除了，并且刚好有两个线程a和b都通过了第一个判空条件。
    // 此时假设a先获得锁，进入synchronized的代码块，初始化instance，a释放锁。接着b获得锁，进入synchronized的代码块，
    // 也直接初始化instance，instance被初始化多遍不符合单例模式的要求~。加上第二个判空条件之后，b获得锁进入synchronized的代码块，
    // 此时instance不为空，不执行初始化操作。

    // 第五个注意点：instance的声明有一个volatile关键字，如果不用该关键字，有可能会出现异常。因为instance = new LRUCache();并不是一个原子操作，会被编译成三条指令，如下所示。
    // 1.给Test的实例分配内存 2.初始化Test的构造器 3.将instance对象指向分配的内存空间（注意 此时instance就不为空）
    // 然后咧，java会指令重排序，JVM根据处理器的特性，充分利用多级缓存，多核等进行适当的指令重排序，使程序在保证业务运行的同时，
    // 充分利用CPU的执行特点，最大的发挥机器的性能！简单来说就是jvm执行上面三条指令的时候，不一定是1-2-3这样执行，有可能是1-3-2这样执行。
    // 如果jvm是按照1-3-2来执行的话，当1-3执行完2还没执行的时候，如果另外一个线程调用getInstance()，因为3执行了此时instance不为空，
    // 直接返回instance。问题是2还没执行，此时instance相当于什么都没有，肯定是有问题的。然后咧，volatile有一个特性就是禁止指令重排序，
    // 上面的三条指令是按照1-2-3执行的，这样就没有问题了。


    private volatile static SingletonTest instance;

    private SingletonTest () {

    }

    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }
}
