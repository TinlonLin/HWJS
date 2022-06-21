package com.example.algorithmdemo.ExerciseDemo.code0610_排序;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: ArrayDelAndSor_0610
 * @desc: 数组去重和排序
 * https://blog.csdn.net/weixin_44052055/article/details/124053155
给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序。
输入描述：
一个数组
输出描述：
去重排序后的数组
输入：1,3,3,3,2,4,4,4,5
输出：3,4,1,2,5
 * @date: 2022/6/12 10:16 上午
 * @version: V-1.0
 */
public class 数组去重和排序_0610 {
    public static void main(String[] args) {
        String str = "1,3,3,3,2,4,4,4,5";
        System.out.println("输入：\n"+str);
        System.out.println("输出：");
        getDelAndSort(str);

        String str1 = "1,4,4,4,2,3,3,3,5";
        System.out.println("输入：\n"+str1);
        System.out.println("输出：");
        getDelAndSort(str1);
    }

    private static void getDelAndSort(String str) {
        //将输入字符串转为String数组
        String[] strArr = str.split(",");
        //选取LinkedHashMap存储元素和出现的次数，可以实现去重和保证元素原顺序
        Map<String,Integer> scMap = new LinkedHashMap<>();
        for (String s : strArr) {
            if (!scMap.containsKey(s)) {
                scMap.put(s,1);
            } else {
                scMap.replace(s,scMap.get(s) + 1);
            }
        }
        //将map的entrySet存到List中并根据出现的次数排序
        List<Map.Entry<String,Integer>> list = new ArrayList<>(scMap.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //次数大的在前面，次数相同按原来顺序
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                return 1;
            }
        });
        //排序后拼接输出
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
            builder.append(stringIntegerEntry.getKey()).append(",");
        }
        System.out.println(builder.substring(0, builder.length() - 1).toString());
    }
}
