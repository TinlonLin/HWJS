package com.example.algorithmdemo.a0630.a200分新加题16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2023/6/11 16:11
 * @ClassName: a15跳格子1_200_动态规划
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130774740?spm=1001.2014.3001.5502
题目描述：
小明和朋友玩跳格子游戏，有 n 个连续格子，每个格子有不同的分数，
小朋友可以选择以任意格子起跳，但是不能跳连续的格子，也不能回头跳；
给定一个代表每个格了得分的非负整数数组，计算能够得到的最高分数。
输入描述：
给定一个数列，如：1 2 3 1
输出描述：
输出能够得到的最高分，如：4
备注
1 ≤ nums.length ≤ 100
0 ≤ nums[i] ≤ 1000

用例：
输入
1 2 3 1
输出
4
说明
选择跳第一个格子和第三个格子

输入
2 7 9 3 1
输出
12
说明
2+9+1=12


 * @Version: V-1.0
 */
public class a15跳格子1_200_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(nums));
    }

    public static int getResult(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        if (n >= 1) dp[0] = nums[0];
        if (n >= 2) dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}
