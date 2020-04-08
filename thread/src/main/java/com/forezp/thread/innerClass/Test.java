package com.forezp.thread.innerClass;

public class Test {

    public int num = 10;

    class Inner {
        public int num  = 20;

        public void show() {
            int num = 30;
            Test t = new Test();

            System.out.println(num);
            System.out.println(t.new Inner().num);
            System.out.println(t.num);
        }
    }

    public static void main(String[] args) {
        new Test().new Inner().show();
    }
}
