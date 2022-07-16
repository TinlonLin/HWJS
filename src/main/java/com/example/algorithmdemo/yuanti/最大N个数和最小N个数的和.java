package com.example.algorithmdemo.yuanti;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 最大N个数和最小N个数的和
 * @desc: 100%
 * @date: 2022/7/16 11:28 上午
 * @version: V-1.0
 */
public class 最大N个数和最小N个数的和 {
    /*
            给定一个数组
            编写一个函数
            来计算他的最大N个数和最小N个数的和
            需要对数组进行去重

            说明
            第一行输入M
            M表示数组大小
            第二行输入M个数
            表示数组内容
            第三行输入N表示需要计算的最大最小N的个数

            输出描述
            输出最大N个数和最小N个数的和

            例一：
                输入
                5
                95 88 83 64 100
                2

                输出
                342

                说明
                最大2个数[100 95] 最小2个数[83 64]
                输出342

             例二
                输入
                5
                3 2 3 4 2
                2

                输出
                 -1
                 说明
                 最大两个数是[4 3]最小2个数是[3 2]
                 有重叠输出为-1

         */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());
        String[] numsStr = in.nextLine().split(" ");
        int n = Integer.parseInt(in.nextLine());
        in.close();

        TreeSet<Integer> ints = new TreeSet<>();
        for (String s : numsStr) {
            ints.add(Integer.parseInt(s));
        }

        int res = -1;

        if (ints.size() >= 2 * n) {
            res = 0;
            ArrayList<Integer> list = new ArrayList<>(ints);
            for (int i = 0; i < list.size(); i++) {
                if (i < n || i > list.size()-1 - n) {
                    res += list.get(i);
                }
            }
        }
        System.out.println(res);
    }
}
