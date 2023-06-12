package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b44快递运输_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418467

 * @date: 2023/6/4 9:04
 * @version: V-1.0
 */
public class b44快递运输_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] weights = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int total = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(weights, total));
    }

    private static int getResult(int[] arr, int bag) {
        int n = arr.length;

        int[] dp = new int[bag + 1];

        for (int i = 0; i < n; i++) {
            int weight = arr[i];
            int worth = 1;
            for (int j = bag; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + worth);
            }
        }

        return dp[bag];
    }
}
