package com.pipikai.demo.alibabaquestion;

import lombok.extern.slf4j.Slf4j;

/**
 * 将ip地址转换成整数
 * int存储占用4个字节，ip字符串存储大于4个字节，而且不一定字节对齐，
 * 如果数据量很大，无法控制存储空间。
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2019/1/19 11:26
 */
@Slf4j
public class Ipv4ToInt {

    public static Integer ip2int(String ip) {
        String[] temp1 = ip.split("\\.");
        Integer intIp = (Integer.parseInt(temp1[0]) << 24) +
                (Integer.parseInt(temp1[1]) << 16) +
                (Integer.parseInt(temp1[2]) << 8) +
                Integer.parseInt(temp1[3]);
        return intIp;
    }

    public static String int2ip(Integer intIp) {
        int a = intIp >> 24;
        int b = (intIp&0x00FF0000) >> 16;
        int c = (intIp&0x0000FF00) >> 8;
        int d = intIp&0x000000FF;
        String ip = a + "." +
                b + "." +
                c + "." +
                d;
        return ip;
    }

    public static void main(String[] args) {
        int ip = ip2int("123.56.46.1");
        System.out.println(ip);
        System.out.println(int2ip(ip));
    }

}
