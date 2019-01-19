package com.pipikai.demo.alibabaquestion;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * 蚂蚁金服二面手写题
 * 在List<Integer> sortedList = new LinkedList<>()中
 * 新增一个可以排序的add方法，例如输入[21245],输出顺序为[12245]
 *
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2019/1/19 10:27
 */
@Slf4j
public class SortedListDemo {

    public static List<Integer> sortedList = new LinkedList<>();

    public void addBySort(Integer e) {
        int temp = 0;
        if (sortedList.isEmpty()) {
            sortedList.add(e);
            return;
        }
        for (int i = 0; i < sortedList.size(); i++) {
            if (e <= sortedList.get(i)) {
                temp = i;
                sortedList.add(temp, e);
                break;
            }
            if (i == sortedList.size() - 1) {
                sortedList.add(e);
                break;
            }
        }
    }

    public static void main(String[] args) {
        SortedListDemo sortedListDemo = new SortedListDemo();
        sortedListDemo.addBySort(2);
        sortedListDemo.addBySort(1);
        sortedListDemo.addBySort(0);
        sortedListDemo.addBySort(2);
        sortedListDemo.addBySort(3);
        sortedListDemo.addBySort(4);
        sortedListDemo.addBySort(-1);
        System.out.println(SortedListDemo.sortedList);
    }

}