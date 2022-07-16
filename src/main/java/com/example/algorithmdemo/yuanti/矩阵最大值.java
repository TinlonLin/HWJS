package com.example.algorithmdemo.yuanti;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 矩阵最大值
 * @desc: 100%
 * @date: 2022/7/16 11:25 上午
 * @version: V-1.0
 */
public class 矩阵最大值 {
    /*
        给定一个仅包含0和1的n*n二维矩阵
        请计算二维矩阵的最大值
        计算规则如下
        1、每行元素按下标顺序组成一个二进制数(下标越大约排在低位)，
        二进制数的值就是该行的值，矩阵各行之和为矩阵的值
        2、允许通过向左或向右整体循环移动每个元素来改变元素在行中的位置
        比如
        [1,0,1,1,1]   向右整体循环移动两位  [1,1,1,0,1]
        二进制数为11101 值为29
        [1,0,1,1,1]   向左整体循环移动两位  [1,1,1,1,0]
        二进制数为11110 值为30

        输入描述
        1.数据的第一行为正整数，记录了N的大小
        0<N<=20
        2.输入的第2到n+1行为二维矩阵信息
        行内元素边角逗号分割

        输出描述
        矩阵的最大值

        示例1

        输入
        5
        1,0,0,0,1
        0,0,0,1,1
        0,1,0,1,0
        1,0,0,1,1
        1,0,1,0,1

        输出
        122

        说明第一行向右整体循环移动一位，得到最大值  11000  24

        因此最大122
         */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> ints = new LinkedList<>();
            Arrays.stream(in.nextLine().split(","))
                    .forEach(x -> ints.add(Integer.parseInt(x)));
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                ints.addLast(ints.remove(0));

                String binInt = ints.toString()
                        .replaceAll("\\W+", "");

                int sum = Integer.parseInt(binInt, 2);
                if (sum > max) max = sum;
            }
            res += max;
        }
        System.out.println(res);
        in.close();
    }
}
