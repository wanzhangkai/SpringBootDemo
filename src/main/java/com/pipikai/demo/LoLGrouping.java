package com.pipikai.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/10/1 16:38
 */
public class LoLGrouping {

    private static final Map<Integer, String> MEMBER_NUM_AND_RANK = new HashMap<Integer, String>() {{
        put(1, "万彰凯@6");
        put(2, "徐志@6");
        put(3, "徐园@4");
        put(4, "郭凯@4");
        put(5, "王宇翔@5");
        put(6, "袁勋@5");
        put(7, "奚望@5");
        put(8, "詹凯鹏@4");
        put(9, "江峰@3");
        put(10, "孟顺@3");
        put(11, "胡聪@4");
        put(12, "张婉君@1");
        put(13, "李栋@2");
        put(14, "宋翌@2");
        put(15, "宋柯@3");
        put(16, "余晚霖@2");
        put(17, "马效@2");
    }};

    public static void main(String[] args) {
        // TODO: 2018/10/1 input
        String input = "";
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MEMBER_NUM_AND_RANK.size(); i++) {


        }
        for (Integer i : MEMBER_NUM_AND_RANK.keySet()) {
            if (i % 5 == 0) {
                System.out.println(sb.toString());
                sb.delete(0, sb.length());
            }
            sb.append(i).append(":").append(MEMBER_NUM_AND_RANK.get(i)).append("  ");
        }
        System.out.println("请输入参加成员:");
        String[] inputTmp = input.split(",");
        if (inputTmp.length != 10) {
//            System.out.println("人数只能为10个");
        }
        double sum = 0;
        double averageRank = 0;
//        for (String str : inputTmp) {
//            String menber = MEMBER_NUM_AND_RANK.get(Integer.valueOf(str));
//            int rank = Integer.valueOf(menber.split("@")[1]);
//            sum += rank;
//        }
        averageRank = sum / 2;


    }

}