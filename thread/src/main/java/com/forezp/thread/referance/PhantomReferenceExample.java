package com.forezp.thread.referance;

import java.lang.ref.*;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-30  12:46
 **/
public class PhantomReferenceExample {

    public static void main(String[] args) {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        PhantomReference<Object> phantomRef = new PhantomReference<>(obj, referenceQueue);

        // obj现在不再有强引用，但它仍然存在，可以在finalize()方法中执行特定操作

        // 垃圾回收
        obj = null;
        System.gc();

        // 检查引用队列
        Reference<?> refFromQueue = referenceQueue.poll();
        if (refFromQueue == phantomRef) {
            System.out.println("虚引用已被添加到引用队列");
        }
    }

}
