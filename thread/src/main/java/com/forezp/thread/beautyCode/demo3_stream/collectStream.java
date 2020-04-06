package com.forezp.thread.beautyCode.demo3_stream;

import com.alibaba.fastjson.JSON;
import com.forezp.thread.beautyCode.demo1.Sku;
import com.forezp.thread.beautyCode.demo1.SkuService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class collectStream {

    private static List<Sku> skuList;

    static {
        SkuService skuService = new SkuService();
        skuList = skuService.getSkuList();
    }

    public static void main(String[] args) {
        // collect 作为一个终端操作  调用collect()将stream处理好的集合或者数据聚合起来
        // collector 是一个接口 collect方法可以接受一个接口去处理
        // collectors 是collector接口的实现 TODO
        toList();
        toMap();
        toPartition();
    }

    private static void toList() {
        List<String> collect = skuList.stream()
                .map(Sku::getName)
                .filter(StringUtils::isNotBlank)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect, true));
    }

    private static void toMap() {
        System.out.println("-------------------------------------------");
        Map<String, List<Sku>> collect = skuList.stream().collect(Collectors.groupingBy(Sku::getType));
        System.out.println(JSON.toJSONString(collect, true));
    }

    private static void toPartition() {
        System.out.println("-------------------------------------------");
        Map<Boolean, List<Sku>> collect = skuList.stream().collect(Collectors.partitioningBy(sku -> sku.getPrice() > 100));
        System.out.println(JSON.toJSONString(collect, true));
    }
}
