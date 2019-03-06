package com.pipikai.simplydemo.overridedemo;

/**
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2019/2/26 14:51
 */
public class Sun extends Father {


    public void eat(String arg1, int arg2) {
        System.out.println(arg1+"sun- "+arg2);
    }

    public static void main(String[] args) {
        Sun sun = new Sun();
        sun.eat("wan",12);
    }


}
