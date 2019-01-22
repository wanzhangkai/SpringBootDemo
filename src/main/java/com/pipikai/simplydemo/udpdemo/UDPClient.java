package com.pipikai.simplydemo.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/10/14 14:06
 */
public class UDPClient {

    public static void main(String[] args) throws IOException {

        try (DatagramSocket socket = new DatagramSocket()) {
            //发送请求
            InetAddress addresses = InetAddress.getByName("localhost");
            byte[] data = "用户名：小王；密码：123456".getBytes();
            int port = 8110;
            DatagramPacket packet = new DatagramPacket(data, data.length, addresses, port);
            byte[] data2 = new byte[1024];
            socket.send(packet);
            //接收响应信息
            DatagramPacket packet2 = new DatagramPacket(data2, 0, data2.length);
            socket.receive(packet2);
            String info = new String(data2,0,packet2.getLength());
            System.out.println("接收到服务器的响应信息："+info);
        }



    }
}