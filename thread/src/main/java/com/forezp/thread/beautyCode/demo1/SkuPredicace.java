package com.forezp.thread.beautyCode.demo1;

@FunctionalInterface
public interface SkuPredicace {

    String BOOKS = "诛仙";

    boolean filter(Sku sku);

    default boolean printStr(Sku sku) {
        System.out.println("默认的接口方法" + BOOKS);
        return true;
    }

    static void staticPrintStr() {
        System.out.println("静态的接口方法" + BOOKS);
    }
}
