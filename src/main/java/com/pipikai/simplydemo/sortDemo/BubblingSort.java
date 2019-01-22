package com.pipikai.simplydemo.sortDemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2019/1/18 16:17
 */
@Slf4j
public class BubblingSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] t = {2, 3, 4, 1, 5};
        sort(t);
        for (int i1 : t) {
            System.out.print(i1 + " ");
        }
    }

}
