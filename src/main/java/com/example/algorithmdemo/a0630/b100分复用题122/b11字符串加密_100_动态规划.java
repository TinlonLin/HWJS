package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b11字符串加密_100_动态规划
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127235411
题目描述:
给你一串未加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，
加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。
当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]。
输入描述:
第一行为一个整数n（1<=n<=1000），表示有n组测试数据，每组数据包含一行，原文str（只含有小写字母，0<长度<=50）。
输出描述:
每组测试数据输出一行，表示字符串的密文。

用例
输入
1
xy
输出
ya
说明
第一个字符x偏移量是1，即为y，第二个字符y偏移量是2，即为a。

 * @date: 2023/6/4 8:49
 * @version: V-1.0
 */
public class b11字符串加密_100_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(getResult(lines[i]));
        }
    }

    public static String getResult(String str) {
        int n = str.length();

        // 初始化a数组
        long[] a = new long[n];
        if (n > 0) {
            a[0] = 1;
        }
        if (n > 1) {
            a[1] = 2;
        }
        if (n > 2) {
            a[2] = 4;
        }
        if (n > 3) {
            for (int i = 3; i < n; i++) {
                a[i] = a[i - 1] + a[i - 2] + a[i - 3];
            }
        }

// 为字符串的每一位字符添加a[i]偏移量
        char[] cArr = str.toCharArray();
        for (int i = 0; i < n; i++) {
            cArr[i] = (char) ((a[i] + cArr[i] - 97) % 26 + 97);
        }
        return new String(cArr);
    }
}
