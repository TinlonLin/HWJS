package com.example.algorithmdemo.yuanti;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 滑动窗口最大值
 * @desc: 100%
 * @date: 2022/7/16 11:22 上午
 * @version: V-1.0
 */
public class 滑动窗口最大值 {
    /*
        有一个N个整数的数组
        和一个长度为M的窗口
        窗口从数组内的第一个数开始滑动
        直到窗口不能滑动为止
        每次滑动产生一个窗口  和窗口内所有数的和
        求窗口滑动产生的所有窗口和的最大值

        输入描述
        第一行输入一个正整数N
        表示整数个数  0<N<100000
        第二行输入N个整数
        整数取值范围   [-100,100]
        第三行输入正整数M
        M代表窗口的大小
        M<=100000 并<=N

        输出描述
        窗口滑动产生所有窗口和的最大值

        示例一
        输入
        6
        12 10 20 30 15 23
        3

        输出
        68
         */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] strs = in.nextLine().split(" ");
        int m = Integer.parseInt(in.nextLine());
        in.close();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n - m + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += ints[j];
            }
            if (sum > res) res = sum;
        }
        System.out.println(res);
    }
}
