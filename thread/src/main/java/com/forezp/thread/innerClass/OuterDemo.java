package com.forezp.thread.innerClass;

public class OuterDemo {

    public static void main(String[] args) {
        Outerr.method().show();  // 能用Outerr直接调用method方法 说明method方法是一个静态方法  能在继续调用show方法说明 method方法有返回值  该返回值实现了Inter接口
    }
}
