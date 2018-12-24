package com.pipikai.imooc.design.pattern.creational.simplefactory;

/**
 * Created by wanzhangkai
 * 2018/12/11 17:54
 * Email: zhangkaiwan@qq.com
 */
public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制Java视频");
    }
}
