package com.pipikai.simplydemo.tcpdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/10/14 15:39
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        System.out.println("socket客户端");

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("用户名：admin2,密码：123");
        pw.flush();
        socket.close();
    }

}