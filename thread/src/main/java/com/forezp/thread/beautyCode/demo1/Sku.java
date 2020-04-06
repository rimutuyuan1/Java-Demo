package com.forezp.thread.beautyCode.demo1;

import lombok.Data;

@Data
public class Sku {

    private int id;

    private String name;

    private int price;

    private String type;

    Sku(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
