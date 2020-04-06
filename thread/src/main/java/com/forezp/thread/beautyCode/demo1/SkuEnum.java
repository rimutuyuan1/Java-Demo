package com.forezp.thread.beautyCode.demo1;

public enum SkuEnum {
    // TODO 枚举类

    BOOK(1,  "图书"),
    LIVING(2, "生活");

    private int id;

    private String type;

    SkuEnum(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
