package com.forezp.thread.beautyCode.demo4_resourceClose;

import com.forezp.thread.beautyCode.demo2_func.FileHandleInterface;

import java.io.*;

public class resourceClose {

    // 资源不需要关闭的情况
    // 1. 当资源需要被return的情况下 不需要关闭
    // 2. 当流为ByteArrayInputStream的情况下  不需要关闭  因为源码中close方法没有任何实现
    // 3. 当使用socket获取的InputStream和OutputStream的情况下 不需要关闭

    private static final String FilePath = "/Users/rimutuyuan/Desktop";

    private static void FileHandle(String path, FileHandleInterface handleInterface) throws IOException {

           try (FileInputStream fis = new FileInputStream(new File(path));
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            handleInterface.FileHandle(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        FileHandle(FilePath + "/hi.txt", System.out::println);
    }
}
