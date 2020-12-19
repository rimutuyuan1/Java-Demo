package com.forezp.thread.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/10/28 10:27 上午
 **/
@Slf4j
public class ListTest {

    private static void testLinkedList(){
        LinkedList<String> list=new LinkedList<>();
        int maxTestCount=10000;

        //测试添加
        long start =System.currentTimeMillis();

        for(int i =0;i<maxTestCount;i++){
            list.add(0,String.valueOf(i));
        }

        long end =System.currentTimeMillis();

        log.info("LinkedList add cost time :"+(end-start));

        //测试查询
        start =System.currentTimeMillis();

        for(int i =0;i<maxTestCount;i++){
            list.get(i);
        }

        end =System.currentTimeMillis();

        log.info("LinkedList get cost time :"+(end-start));


        //测试查询
        start =System.currentTimeMillis();

        for(int i =maxTestCount;i>0;i--){
            list.remove(0);
        }

        end =System.currentTimeMillis();

        log.info( "LinkedList remove cost time :"+(end-start));

    }

    private static void testArrayList(){
        ArrayList<String> list=new ArrayList<>();
        int maxTestCount=10000;

        //测试添加
        long start =System.currentTimeMillis();

        for(int i =0;i<maxTestCount;i++){
            list.add(0,String.valueOf(i));
        }

        long end =System.currentTimeMillis();

         log.info( "ArrayList add cost time :"+(end-start));

        //测试查询
        start =System.currentTimeMillis();

        for(int i =0;i<maxTestCount;i++){
            list.get(i);
        }

        end =System.currentTimeMillis();

         log.info( "ArrayList get cost time :"+(end-start));

        //测试查询
        start =System.currentTimeMillis();

        for(int i =maxTestCount;i>0;i--){
            list.remove(0);
        }

        end =System.currentTimeMillis();

         log.info( "ArrayList remove cost time :"+(end-start));

    }

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }
}
