package com.forezp.thread.ThreadAndRunnable;

public class threadStudy {

    // 线程6种状态
    // 1. 新建状态  new Thread
    // 2. 运行状态  执行start方法
    // 3. 无限等待状态  object.wait() -> 未设置timeOut参数 / Thread.join() -> 未设置timeOut参数 / LockSupport.park()  需要显式被唤醒 notify/notifyAll/unpark方法
    // 4. 有限期等待状态  sleep() / object.wait() -> 已设置timeOut参数 / Thread.join() -> 已设置timeOut参数 / LockSupport.parkNanos() / LockSupport.parkUntil()
    // 5. 阻塞状态  线程未获取到排它锁sync -> synchronized / Lock.lock()
    // 6. 结束状态  线程被销毁

    // thread.sleep和object.wait方法区别
    // sleep方法是线程类中的native方法， wait方法是object类中的底层方法
    // sleep只会让出cpu，但不会让出锁， wait让出cpu并且让出锁

    // wait   notify   notifyAll
    // 等待池 和  锁池
    // 一个线程如果想调用同步方法或同步块，同步方法如果被其他线程占用  则该线程进入锁池中等待
    // 一个线程如果调用了wait方法 则当前线程会进入等待池中并且释放锁  另外一个线程进入同步方法执行完后调用notify方法会从等待池中随即取出一个线程进入锁池去竞争锁
    // 如果另外一个线程调用notifyAll方法后 等待池中所有线程都去锁池竞争

    // wait()和join()方法 如果设置超时时间，时间一过 当前线程就会从等待池(等待队列)中转到锁池中继续竞争锁，和notify/notifyAll相同

    // interrupt 中断函数
    // a线程调用interrupt方法去中断b线程
    // 当b线程处于被阻塞状态中  线程立刻抛出interruptException异常
    // 当b线程处于正在运行状态中 将b线程中断标志置为true 但b线程会继续正常运行 不受影响
}
