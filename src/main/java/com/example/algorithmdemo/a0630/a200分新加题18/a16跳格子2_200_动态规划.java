package com.example.algorithmdemo.a0630.a200分新加题18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2023/6/11 16:16
 * @ClassName: a16跳格子2_200_动态规划
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130774791
题目描述：
小明和朋友玩跳格子游戏，有 n 个连续格子组成的圆圈，每个格子有不同的分数，
小朋友可以选择以任意格子起跳，但是不能跳连续的格子，不能回头跳，也不能超过一圈;
给定一个代表每个格子得分的非负整数数组，计算能够得到的最高分数。
输入描述：
给定一个数例，第一个格子和最后一个格子首尾相连，如: 2 3 2
输出描述：
输出能够得到的最高分，如: 3
备注
1 ≤ nums.length ≤ 100
1 ≤ nums[i] ≤ 1000

用例
输入
2 3 2
输出
3
说明
只能跳3这个格子，因为第一个格子和第三个格子首尾相连

输入
1 2 3 1
输出
4
说明
1 + 3 = 4

 * @Version: V-1.0
 */
public class a16跳格子2_200_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(nums));
    }

    public static int getResult(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(
                stealMaxMoney(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                stealMaxMoney(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public static int stealMaxMoney(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        if (n >= 1) {
            dp[0] = nums[0];
        }
        if (n >= 2) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}
