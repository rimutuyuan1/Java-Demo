package com.forezp.thread.beautyCode.demo1;

public class SkuEnumFilter implements SkuPredicace {

    @Override
    public boolean filter(Sku sku) {
        return SkuEnum.BOOK.getType() == sku.getType();
    }
}
