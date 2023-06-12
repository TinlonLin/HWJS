package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b93矩形相交的面积_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418219

 * @date: 2023/6/4 9:40
 * @version: V-1.0
 */
public class b93矩形相交的面积_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int w1 = sc.nextInt();
        int h1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int w2 = sc.nextInt();
        int h2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int w3 = sc.nextInt();
        int h3 = sc.nextInt();

        int wid = getMin(x1 + w1, x2 + w2, x3 + w3) - getMax(x1, x2, x3);
        if (wid <= 0) {
            System.out.println(0);
            return;
        }

        int hei = getMin(y1, y2, y3) - getMax(y1 - h1, y2 - h2, y3 - h3);
        if (hei <= 0) {
            System.out.println(0);
            return;
        }

        System.out.println(wid * hei);
    }

    private static int getMax(int n1, int n2, int n3) {
        int max = Math.max(n1, n2);
        max = Math.max(max, n3);
        return max;
    }

    private static int getMin(int n1, int n2, int n3) {
        int min = Math.min(n1, n2);
        min = Math.min(min, n3);
        return min;
    }
}
