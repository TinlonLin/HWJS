package com.example.algorithmdemo.ExerciseDemo.code0630_递归;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 第k个排列_0630
 * @desc: 第k个排列
 * https://blog.csdn.net/weixin_44219664/article/details/124089294
 *
 * 给定参数n，从1到n会有n个整数 1,2,3...n
 * 这n个数字共有n!种排序 按大小顺序升序列出所有排序情况，并一一标记
 * 当n=3时，所有排列如下
 * 123 132 213 231 312 321
 *
 * 给定n和k 返回第k个排列
 *
 * 输入描述：
 * 第一行为 n 1~9
 * 第二行为 k 1~n!
 *
 * 输出描述：
 * 输出排列第k位置的数字
 *
示例一：
输入
3
3
输出
213

示例二:
输入
2
2
输出
21

 *
 * @date: 2022/6/21 11:19 下午
 * @version: V-1.0
 */
public class 第k个排列_0630 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        getNokNum(n, k);
    }

    private static void getNokNum(int n, int k) {

    }
}
