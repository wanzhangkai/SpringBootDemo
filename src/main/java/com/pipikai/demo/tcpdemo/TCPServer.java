package com.pipikai.demo.tcpdemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/10/14 15:40
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("socket服务端启动");

        while (true) {
            System.out.println("socket监听中...");
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            BufferedReader bw = new BufferedReader(
                    new InputStreamReader(is)
            );
            String clientInfo = null;
            while ((clientInfo = bw.readLine()) != null) {
                System.out.println("服务端响应：" + clientInfo);
            }
            socket.close();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}