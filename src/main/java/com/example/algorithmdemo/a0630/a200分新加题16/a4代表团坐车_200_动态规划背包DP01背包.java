package com.example.algorithmdemo.a0630.a200分新加题16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a4代表团坐车_200_动态规划背包DP01背包
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130792462
题目描述:
某组织举行会议，来了多个代表团同时到达，接待处只有一辆汽车，可以同时接待多个代表团，
为了提高车辆利用率，请帮接待员计算可以坐满车的接待方案，输出方案数量。
约束:
1.一个团只能上一辆车，并且代表团人数 (代表团数量小于30，每个代表团人数小于30)小于汽车容量(汽车容量小于100)
2.需要将车辆坐满
输入描述:
第一行 代表团人数，英文逗号隔开，代表团数量小于30，每个代表团人数小于30
第二行 汽车载客量，汽车容量小于100
输出描述:
坐满汽车的方案数量
如果无解输出0

用例:
输入
5,4,2,3,2,4,9
10
输出
4
说明
解释 以下几种方式都可以坐满车，所以，优先接待输出为4
[2,3,5]
[2,4,4]
[2,3,5]
[2,4,4]
题目解析:
本题可以转化为01背包的装满背包的方案数问题。
解析可以参考：解析可以参考：
https://blog.csdn.net/qfc_128220/article/details/130318724?spm=1001.2014.3001.5501


 * @date: 2023/6/4 8:42
 * @version: V-1.0
 */
public class a4代表团坐车_200_动态规划背包DP01背包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] nums =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        int bag = Integer.parseInt(sc.nextLine());
        System.out.println(getResult(nums, bag));
    }

    private static int getResult(Integer[] nums, int bag) {
        int n = nums.length;
        int[] dp = new int[bag + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = bag; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[bag];
    }
}
