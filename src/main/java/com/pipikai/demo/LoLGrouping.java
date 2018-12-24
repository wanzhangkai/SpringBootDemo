package com.pipikai.demo;

import java.util.*;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/10/1 16:38
 */
public class LoLGrouping {

    private static final Map<Integer, String> MEMBER_NUM_AND_RANK = new HashMap<Integer, String>() {{
        put(1, "徐志@6");
        put(2, "徐园@4");
        put(3, "郭凯@4");
        put(4, "王宇翔@5");
        put(5, "袁勋@5");
        put(6, "奚望@5");
        put(7, "詹凯鹏@4");
        put(8, "万彰凯@6");
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
        StringBuilder sb3 = new StringBuilder();
        for (Integer i : MEMBER_NUM_AND_RANK.keySet()) {
            String temp = MEMBER_NUM_AND_RANK.get(i).substring(0, MEMBER_NUM_AND_RANK.get(i).length() - 2);
            sb3.append(i).append(":").append(temp).append(" ");
        }
        System.out.println("可选列表：");
        System.out.println("【" + sb3.toString() + "】");
        System.out.println("请输入参加成员的编号：");
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                System.out.println("输入的不是整数！");
                scanner.next();
                continue;
            }
            if (!MEMBER_NUM_AND_RANK.keySet().contains(input)) {
                System.out.println("请输入列表上的整数！");
                scanner.next();
                continue;
            }
            if (list.contains(input)) {
                System.out.println("请勿重复选人！");
                continue;
            }
            list.add(input);
            if (list.size() == 10) {
                StringBuilder sb = new StringBuilder();
                for (Integer i : list) {
                    String temp = MEMBER_NUM_AND_RANK.get(i).substring(0, MEMBER_NUM_AND_RANK.get(i).length() - 2);
                    sb.append(i).append(":").append(temp).append(" ");
                }
                System.out.println();
                System.out.println("============================================================================================");
                System.out.println("已选择：【" + sb.toString() + "】");
                break;
            }
            StringBuilder sb = new StringBuilder();
            int num = 0;
            for (Integer i : list) {
                String temp = MEMBER_NUM_AND_RANK.get(i).substring(0, MEMBER_NUM_AND_RANK.get(i).length() - 2);
                sb.append(i).append(":").append(temp).append(" ");
                num++;
            }
            StringBuilder sb2 = new StringBuilder();
            for (Integer i : MEMBER_NUM_AND_RANK.keySet()) {
                if (!list.contains(i)) {
                    String temp = MEMBER_NUM_AND_RANK.get(i).substring(0, MEMBER_NUM_AND_RANK.get(i).length() - 2);
                    sb2.append(i).append(":").append(temp).append(" ");
                }
            }
            System.out.println();
            System.out.println("已选择：【" + sb.toString() + "】");
            System.out.println("还需选择 " + (10 - num) + " 人!");
            System.out.println("待选列表：【" + sb2.toString() + "】");
        }
        boolean xukai = false;
        if (list.contains(2) && list.contains(3)) {
            System.out.println("徐园郭凯是否必须一边（y/n）:");
            while (scanner.hasNext()) {
                String c = scanner.next();
                if (c.equals("Y") || c.equals("y")) {
                    xukai = true;
                    break;
                } else if (c.equals("N") || c.equals("n")) {
                    break;
                }
                System.out.println("徐园郭凯是否必须一边（y/n）:");
            }
        }
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        int sumA = 0;
        int numA = 0;
        int sumB = 0;
        int numB = 0;
        if (xukai) {
            String temp2 = MEMBER_NUM_AND_RANK.get(2).substring(0, MEMBER_NUM_AND_RANK.get(2).length() - 2);
            int rank2 = Integer.valueOf(MEMBER_NUM_AND_RANK.get(2).split("@")[1]);
            String temp3 = MEMBER_NUM_AND_RANK.get(3).substring(0, MEMBER_NUM_AND_RANK.get(3).length() - 2);
            int rank3 = Integer.valueOf(MEMBER_NUM_AND_RANK.get(3).split("@")[1]);
            int i = (int) (Math.random() * 1);
            if (i == 0) {
                sumA += rank2;
                sumA += rank3;
                sbA.append(temp2).append("  ");
                sbA.append(temp3).append("  ");
                numA++;
                numA++;
            } else {
                sumB += rank2;
                sumB += rank3;
                sbB.append(temp2).append("  ");
                sbB.append(temp3).append("  ");
                numB++;
                numB++;
            }
            List list1 = new ArrayList() {{
                add(2);
                add(3);
            }};
            list.removeAll(list1);
        }
        while (list.size() != 0) {
//            System.out.println("list.size() " + list.size());
            int i = (int) (Math.random() * list.size());
            if (i != 0) {
                i = i - 1;
            }
//            System.out.println("i " + i);
            String temp = MEMBER_NUM_AND_RANK.get(list.get(i)).substring(0, MEMBER_NUM_AND_RANK.get(list.get(i)).length() - 2);
            int rank = Integer.valueOf(MEMBER_NUM_AND_RANK.get(list.get(i)).split("@")[1]);
            if (numA == 5) {
                sbB.append(temp).append("  ");
                list.remove(i);
                continue;
            }
            if (numB == 5) {
                sbA.append(temp).append("  ");
                list.remove(i);
                continue;
            }
            if (sumA >= sumB) {
                sumB += rank;
                sbB.append(temp).append("  ");
                numB++;
                list.remove(i);
            } else {
                sumA += rank;
                sbA.append(temp).append("  ");
                numA++;
                list.remove(i);
            }
        }
        System.out.println("战力均衡中...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("左边配置：" + sbA.toString());
        System.out.println("右边配置：" + sbB.toString());
        System.out.println("============================================================================================");
    }

}