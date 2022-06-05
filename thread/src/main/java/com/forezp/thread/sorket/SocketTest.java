package com.forezp.thread.sorket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/4/30 6:01 下午
 **/
public class SocketTest {

    private static final Logger logger = LoggerFactory.getLogger(SocketTest.class);
    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(
            10, 10, 5,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("accept a ip ,port is : " + socket.getPort());
            EXECUTOR_SERVICE.execute(() -> {
                try {
                    InputStream is = socket.getInputStream();
                    BufferedReader bis = new BufferedReader(new InputStreamReader(is));
                    while (true) {
                        System.out.println(bis.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("error : {}", e.getMessage());
                }
            });
        }
    }
}
