package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b86玩牌高手_100_动态规划
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417904

 * @date: 2023/6/4 9:37
 * @version: V-1.0
 */
public class b86玩牌高手_100_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    private static int getResult(Integer[] arr) {
        int n = arr.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0] = Math.max(0, arr[0]);
            } else if (i < 3) {
                dp[i] = Math.max(0, dp[i - 1] + arr[i]);
            } else {
                dp[i] = Math.max(dp[i - 3], dp[i - 1] + arr[i]);
            }
        }

        return dp[n - 1];
    }
}
