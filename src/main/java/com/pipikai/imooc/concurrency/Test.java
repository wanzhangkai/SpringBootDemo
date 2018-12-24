package com.pipikai.imooc.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wanzhangkai
 * 2018/12/1 15:25
 * Email: zhangkaiwan@qq.com
 */
@Slf4j
public class Test {

    private static void test(List<Integer> l1){
        Iterator<Integer> iterator = l1.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if (i.equals(3)){
                l1.remove(i);
            }
        }
    }

    private static void test1(List<Integer> l1){
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i).equals(3)){
                l1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        test1(list);
    }
}
