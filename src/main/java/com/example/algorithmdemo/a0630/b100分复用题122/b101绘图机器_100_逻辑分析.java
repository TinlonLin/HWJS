package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b101绘图机器_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127240714

 * @date: 2023/6/4 9:43
 * @version: V-1.0
 */
public class b101绘图机器_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        // 求出每个横轴单位上的offsetY偏移值，如果输入未给定offsetY，则相当于offsetY=0
        int[] offsets = new int[e];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int offsetY = sc.nextInt();
            offsets[x] = offsetY;
        }

        System.out.println(getResult(n, e, offsets));
    }

    private static int getResult(int n, int e, int[] offsets) {
        if (e == 0) {
            return 0;
        }

        int[] dp = new int[e];

        int ans = dp[0] = offsets[0];
        for (int i = 1; i < offsets.length; i++) {
            dp[i] = dp[i - 1] + offsets[i];
            ans += Math.abs(dp[i]);
        }

        return ans;
    }
}
