package com.pipikai.demo.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/10/14 14:06
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {
        //接收请求
        DatagramSocket socket = new DatagramSocket(8110);//指定服务器端口
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);//创建数据报，用于接收客户端发送的数据
        System.out.println("========服务器已启动，正在等待客户端发送数据======");
        while (true) {
            socket.receive(packet);//此方法在接收到客户端数据之前会一直阻塞
//            String info =  new String(packet.getData(), 0, packet.getLength());
            String info = new String(packet.getData());
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            System.out.println("接收到客户端的消息是：" + info);
            //发送响应信息
            byte[] data2 = "这是服务器的响应信息：登录成功".getBytes();
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
            try {
                socket.send(packet2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}