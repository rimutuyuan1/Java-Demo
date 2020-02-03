package com.forezp.thread.publish;

import com.forezp.thread.annoations.NotRecommend;
import com.forezp.thread.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;


/**
 * 发布对象: 使一个对象能够被当前范围之外的代码所看到
 * 对象逸出: 一种错误的发布，当一个对象还没有构造完成时，就使它能够被其他线程所看到
 *
 * 安全发布对象：
 * 1. 在静态初始化函数中初始化一个对象引用
 * 2. 在对象的引用保存到volatile类型域或者AtomicReference对象中
 * 3. 将对象的引用保存到某个正确构造的final类型域中
 * 4. 将对象的引用保存到一个由锁保护的域中
 * */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape () {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass () {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
