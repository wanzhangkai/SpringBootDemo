package com.pipikai.simplydemo.inetdemo;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class InetAddressDemo {

    private static void test1() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());
            byte[] bytes = inetAddress.getAddress();
            System.out.println(inetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        try {
            URL url = new URL("http://www.baidu.com");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            InputStream in = url.openStream();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream(), "utf-8")
            );
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("demo/InetDemo.html"), "utf-8"
                    )
            );
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
//                bw.newLine();
                bw.flush();
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        test1();
//        test2();
    }

}