package com.forezp.thread.innerClass;

/**
 *  非静态内部类
 *
 * */
public class Outer {

    private int a = 10;
    private static int q = 20;

    private void innerCall() {
        new Inner().printInfo(3);
        int bbb = new Inner().b;
        System.out.println(bbb); // 外部类不能直接访问非静态内部类的实例变量和方法，如果想要访问的话，
        System.out.println("Inner Call");  // 必须要创建非静态内部类的实例进而调用该实例的成员。
    }

    class Inner {

        private int b = 5;
        //private static int c = 6; 非静态内部类不能创建静态变量、静态块、静态方法

        public void printInfo(int a) {
            System.out.println("a = " + a);  //a = 10  Inner Call
            Outer.this.innerCall(); // 非静态内部类持有的外部类的引用
        }

    }

    private static class staticInner {
        public void printStaticInner () {
            System.out.println(q);
            //System.out.println(a); 静态内部类只能调用外部类的静态方法和变量
        }
    }

    public void test() {

        Inner inner = new Inner();
        inner.printInfo(1);

        //在该方法的局部变量找
        //方法所在的内部类找
        //内部类所在的外部类找
        //如果都没有则编译报错

    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        //outer.test();
        int b = outer.new Inner().b;
        System.out.println(b);
    }

}
