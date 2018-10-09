package com.pipikai.demo;

public class TestDemo {

    private static void test1() {
        String s = "wanzhang";
        String s1 = "12";
        String s2 = "11";
        String s3 = "10";
        String s4 = "10121231231312321321323";
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
    }

    public static void main(String[] args) {
        test1();
    }

}
