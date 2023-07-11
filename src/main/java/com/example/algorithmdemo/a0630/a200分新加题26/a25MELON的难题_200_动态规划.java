package com.example.algorithmdemo.a0630.a200分新加题26;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/12 0:26
 * @ClassName: a25MELON的难题_200_动态规划
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/131476575

 * @Version: V-1.0
 */
public class a25MELON的难题_200_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(n, nums));
    }

    public static int getResult(int n, int[] nums) {
        // 所有雨花石重量之和
        int sum = Arrays.stream(nums).sum();

        // 如果重量之和不能整除2，则必然无法平分
        if (sum % 2 != 0) return -1;

        // 背包承重
        int bag = sum / 2;

        // 二维数组
        int[][] dp = new int[n + 1][bag + 1];

        // 初始化第一行，n是一个不可能的装满背包的物品数量
        for (int i = 0; i <= bag; i++) {
            dp[0][i] = n;
        }

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 1; j <= bag; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - num] + 1);
                }
            }
        }

        // 如果装满背包的最少物品数为n, 则说明没有平分方案，因为n个雨花石的重量之和为sumV，而背包的承重是bag = sumV // 2
        if (dp[n][bag] == n) {
            return -1;
        } else {
            return dp[n][bag];
        }
    }
}
