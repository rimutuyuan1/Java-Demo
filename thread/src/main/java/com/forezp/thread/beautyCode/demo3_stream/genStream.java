package com.forezp.thread.beautyCode.demo3_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class genStream {

    // 生辰流的四种方式  值创建、集合创建、文件创建、方法创建
    public static void main(String[] args) throws IOException {
        genStreamByParam();
        genStreamByFile();
        genStreamByArray();
        genStreamByFunc();
    }

    private static void genStreamByParam() {
        Stream stream = Stream.of(1,2,3,4,5);
        stream.forEach(System.out::println);
    }

    private static void genStreamByFile() throws IOException {
        System.out.println("------------------------------------------");
        Stream<String> lines = Files.lines(Paths.get("/Users/rimutuyuan/springcloud/" +
                "sc-f-chapter1/thread/src/main/java/com/forezp/thread/beautyCode/demo3_stream/" +
                "genStream.java"));
        lines.forEach(System.out::println);
    }

    private static void genStreamByArray() {
        System.out.println("------------------------------------------");
        String[] arr = {"1", "2", "3"};
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
    }

    private static void genStreamByFunc() {
        System.out.println("------------------------------------------");
        //Stream stream = Stream.iterate(0, o -> o + 1);
        Stream stream = Stream.generate(Math::random);
        stream.limit(100).forEach(System.out::println);

    }
}
