package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b64猴子爬山_100_动态规划
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418090

 * @date: 2023/6/4 9:26
 * @version: V-1.0
 */
public class b64猴子爬山_100_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getResult(n));
    }

    //动态规划
    private static int getResult(int n) {
        int[] dp = new int[n + 1];

        if (n >= 1) {
            dp[1] = 1;
        }
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 2;
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }

        return dp[n];
    }

//    //分治递归
//    static int[] cache = new int[51];
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        Arrays.fill(cache, -1);
//        cache[0] = 0;
//        cache[1] = 1;
//        cache[2] = 1;
//        cache[3] = 2;
//
//        System.out.println(recursive(n));
//    }
//
//    private static int recursive(int n) {
//        if (cache[n] != -1) return cache[n];
//        cache[n] = recursive(n - 1) + recursive(n - 3);
//        return cache[n];
//    }
}
