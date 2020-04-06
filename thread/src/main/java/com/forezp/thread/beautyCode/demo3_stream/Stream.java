package com.forezp.thread.beautyCode.demo3_stream;

import com.alibaba.fastjson.JSON;
import com.forezp.thread.beautyCode.demo1.Sku;
import com.forezp.thread.beautyCode.demo1.SkuEnum;
import com.forezp.thread.beautyCode.demo1.SkuService;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Stream {

    private static List<Sku> skuList;
    private static volatile AtomicReference<Integer> totalMoney;

    static {
        SkuService skuService = new SkuService();
        skuList = skuService.getSkuList();
        totalMoney = new AtomicReference<>(0);
    }

    public static void main(String[] args) {

        List<String> collect = skuList.stream()
                .filter(sku -> sku.getType().equals(SkuEnum.BOOK.getType()))
                .sorted(Comparator.comparing(Sku::getPrice).reversed())
                .limit(3)
                .peek(sku -> totalMoney.set(totalMoney.get() + sku.getPrice()))
                //map 将一个元素转换成另一个元素
                .map(Sku::getName)
                //收集并转成相对应的集合
                .collect(Collectors.toList());
                //.count(); 取个数
                // skip和limit函数配合使用可以做分页  *****感觉最好在sql中用limit处理 否则每次都会取出所有的数据*****
                // skip((i - 1) * 3).limit(3)  第一页 取三条
        System.out.println(JSON.toJSONString(collect, true));
        System.out.printf("商品总价为: %s", totalMoney.get() + "\n");
        System.out.println("------------------------------------------");
        getSomeDate();  //去重
        boolean b = allMatch(); //是否所有的元素都匹配条件，返回boolean
        System.out.printf("判断是否大于100：%s\n", b ? "是" : "否");
        boolean c = anyMatch();
        System.out.printf("判断list中是否含有大于100的数， %s\n", c ? "是" : "否");
        boolean d = noneMatch();
        System.out.printf("判断list中是否有含有大于10000的数， %s\n", d ? "是" : "否");
        findFirst();
        findAny();
        max();
        min();
    }

    private static void getSomeDate() {

        skuList.stream().map(Sku::getType)
                //去重
                .distinct()
                .forEach(o -> System.out.println(JSON.toJSONString(o, true)));
    }

    // 终端操作、短路：当检测一个集合中有不满足条件的元素后直接返回true
    private static boolean allMatch() {
        System.out.println("------------------------------------------");
        return skuList.stream()
                .peek(sku -> System.out.println(sku.getName()))
                .allMatch(o -> o.getPrice() > 100);
    }

    // 终端操作、短路：当检测一个集合中只要有一个满足条件的元素后直接返回true
    private static boolean anyMatch() {
        System.out.println("------------------------------------------");
        return skuList.stream()
                .peek(sku -> System.out.println(sku.getName()))
                .anyMatch(sku -> sku.getPrice() > 100);

    }

    // 终端操作、短路：当集合中每一个元素都不匹配的话  返回true
    private static boolean noneMatch() {
        System.out.println("------------------------------------------");
        return skuList.stream()
                .peek(sku -> System.out.println(sku.getName()))
                .noneMatch(sku -> sku.getPrice() > 10000);
    }

    // 查找操作
    // findFirst 查找到第一个存在的元素就返回
    private static void findFirst() {
        System.out.println("------------------------------------------");
        Optional<Sku> first = skuList.stream()
                .findFirst();
        System.out.println(JSON.toJSONString(first.get()));
    }

    // findAny 找到任意一个元素只要存在就返回
    private static void findAny() {
        System.out.println("------------------------------------------");
        Optional<Sku> optionalSku = skuList.stream()
                .findAny();
        System.out.println(JSON.toJSONString(optionalSku.get(), true));
    }

    // max
    private static void max() {
        System.out.println("------------------------------------------");
        OptionalInt max = skuList.stream()
                .mapToInt(Sku::getPrice)
                .max();

        System.out.println("max is :" + max.getAsInt());
    }

    // min
    private static void min() {
        System.out.println("------------------------------------------");
        OptionalInt min = skuList.stream()
                .mapToInt(Sku::getPrice)
                .min();

        System.out.println("max is :" + min.getAsInt());
    }



















}
