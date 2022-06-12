package com.example.algorithmdemo.ExerciseDemo.code0610_排序;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: TallAndShortSort_0610
 * @desc: 高矮个子排队
 * https://blog.csdn.net/weixin_44219664/article/details/124513461
 * 输入描述：排序前的小朋友，以英文空格分割的正整数
 * 输出描述：排序后的小朋友，以英文空格分割，按高矮高矮高矮，每个高比相邻矮的高，每个矮比相邻高的矮
 * 输入：5 3 1 2 3
 * 输出：5 1 3 2 3
 * 输入：4 3 5 7 8
 * 输出：4 3 7 5 8
 * @date: 2022/6/12 10:54 上午
 * @version: V-1.0
 */
public class TallAndShortSort_0610 {
    public static void main(String[] args) {
        String str = "5 3 1 2 3";
        System.out.println("输入：\n" + str);
        System.out.println("输出：");
        getSortStr(str);

        String str1 = "4 3 5 7 8";
        System.out.println("输入：\n" + str1);
        System.out.println("输出：");
        getSortStr(str1);

        String str2 = "xxx";
        System.out.println("输入：\n" + str2);
        System.out.println("输出：");
        getSortStr(str2);

        String str3 = "";
        System.out.println("输入：\n" + str3);
        System.out.println("输出：");
        getSortStr(str3);
    }

    private static void getSortStr(String str) {
        //先根据空格分割出数字字符串再转为整型存入List中
        String[] strArr = str.split(" ");
        //如果输入非法输出空数组，并终止程序
        if (strArr.length <= 1) {
            System.out.println("[]");
            return;
        }
        List<Integer> numList = new ArrayList<>();
        for (String s : strArr) {
            numList.add(Integer.parseInt(s));
        }
        //遍历list，高位下标满足i%2==0,低位下标满足i%2==1
        for (int i = 0; i < numList.size() - 1; i++) {
            //高位比相邻低位小，交换位置
            if (i % 2 == 0 && numList.get(i) < numList.get(i + 1)) {
                swapByIndex(numList, i, i + 1);
            }
            //低位比相邻高位大，交换位置
            if (i % 2 == 1 && numList.get(i) > numList.get(i + 1)) {
                swapByIndex(numList, i, i + 1);
            }
        }
        //交换完按题意拼接输出
        StringBuilder builder = new StringBuilder();
        for (Integer integer : numList) {
            builder.append(integer).append(" ");
        }
        System.out.println(builder.substring(0, builder.length() - 1).toString());

    }

    private static void swapByIndex(List<Integer> list, int i, int j) {
        //根据下标交换list中两个值的位置
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
