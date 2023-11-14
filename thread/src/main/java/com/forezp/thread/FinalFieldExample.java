package com.forezp.thread;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-30  20:24
 **/
public class FinalFieldExample {

    final Integer x;
    int y;
    static FinalFieldExample f;

    public FinalFieldExample() {
        x = 3;
        //y = 4;
    }

    static void writer() {
        f = new FinalFieldExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;  // 程序一定能得到 3
            int j = f.y;  // 也许会看到 0
        }
    }

    public static void main(String[] args) {

    }
}
