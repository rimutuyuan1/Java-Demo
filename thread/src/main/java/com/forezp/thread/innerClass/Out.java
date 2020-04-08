package com.forezp.thread.innerClass;

class Out {

    private static int a = 0;

    private int b;

    class Inner {
        void print() {
            System.out.println(a);
        }
    }
}
