package com.forezp.thread.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LombokTest {

    @SneakyThrows
    private static void test() {
        throw new RuntimeException("");
    }

    public static void main(String[] args) throws IOException {
        @Cleanup InputStream is = new FileInputStream("");
        is.close();
        test();
    }
}
