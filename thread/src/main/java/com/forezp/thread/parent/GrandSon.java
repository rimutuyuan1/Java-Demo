package com.forezp.thread.parent;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-03  11:40
 **/
public class GrandSon extends Parent {

    @Override
    public void printP() {
        System.out.println(" i am grandSon");
    }

    public void printG() {
        System.out.println("i am grandSon 2");
    }

    public static void main(String[] args) {
        Parent p = new Child();
        p.printP();
        Child c = (Child) p;
        c.printC();
        Parent p1 = new GrandSon();
        p1.printP();
        GrandSon g = (GrandSon) p1;
        g.printG();
    }
}
