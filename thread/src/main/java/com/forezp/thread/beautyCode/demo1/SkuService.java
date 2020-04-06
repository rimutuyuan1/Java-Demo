package com.forezp.thread.beautyCode.demo1;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class SkuService {

    private static List<Sku> skuList = new ArrayList<Sku>(){
        {
            add(new Sku(65536, "短袖", 200, "衣服"));
            add(new Sku(65537, "零食", 15,"日常"));
            add(new Sku(65538, "鞋子", 1500, "衣服"));
            add(new Sku(65539, "漫画", 50, "图书"));
            add(new Sku(65540, "小说", 80, "图书"));
            add(new Sku(65541, "手机", 7500, "工具"));
            add(new Sku(65542, "电脑", 15000, "工具"));
            add(new Sku(65543, "馒头", 3, "饮食"));
            add(new Sku(65544, "鲜花", 30, "生活"));
            add(new Sku(65545, "牛奶", 12, "饮食"));
            add(new Sku(65545, "教程", 120, "图书"));
            add(new Sku(65545, "回忆录", 20, "图书"));
        }
    };

    public List<Sku> getSkuList() {
        return skuList;
    }

    private static List<Sku> filterSkus(List<Sku> list, SkuPredicace skuPredicace) {
        List<Sku> res = new ArrayList<>();
        for (Sku sku : list) {
            if (skuPredicace.filter(sku)) {
                res.add(sku);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Sku> skus = filterSkus(skuList, o -> o.getType().equals(SkuEnum.BOOK.getType()));

        System.out.println(JSON.toJSONString(skus, true));
    }
}
