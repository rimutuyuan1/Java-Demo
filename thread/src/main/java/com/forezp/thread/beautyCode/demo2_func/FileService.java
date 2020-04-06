package com.forezp.thread.beautyCode.demo2_func;

import java.io.*;

public class FileService {

    private static final String FilePath = "/Users/rimutuyuan/Desktop";

    private void FileHandle(String path, FileHandleInterface handleInterface) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(new File(path))));

        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        handleInterface.FileHandle(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();
        fileService.FileHandle(FilePath + "/hi.txt", System.out::println);
    }
}
