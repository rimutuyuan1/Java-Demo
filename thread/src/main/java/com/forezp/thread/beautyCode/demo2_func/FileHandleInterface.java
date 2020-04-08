package com.forezp.thread.beautyCode.demo2_func;

@FunctionalInterface
public interface FileHandleInterface {

    void FileHandle(String url);

    default void defaultFileHandle() {
        System.out.println("默认接口实现方法");
    }

}
