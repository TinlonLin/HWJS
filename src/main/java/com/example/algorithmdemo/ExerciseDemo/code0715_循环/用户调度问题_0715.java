package com.example.algorithmdemo.ExerciseDemo.code0715_循环;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 用户调度问题_0715
 * @desc: 用户调度问题
 * https://blog.csdn.net/qq_38584967/article/details/124867407
 *
【用户调度问题】在通信系统中，一个常见的问题是对用户进行不同策略的调度，
会得到不同的系统消耗和性能。
假设当前有n个待串行调度用户，每个用户可以使用A/B/C三种不同的调度策略，
不同的策略会消耗不同的系统资源。请你根据如下规则进行用户调度，并返回总的
消耗资源数。
规则：
1. 相邻的用户不能使用相同的调度策略，例如，第1个用户使用了A策略，
则第2个用户只能使用B或者C策略。
2. 对单个用户而言，不同的调度策略对系统资源的消耗可以归一化后抽象为数值。
例如，某用户分别使用A/B/C策略的系统消耗分别为15/8/17。
3. 每个用户依次选择当前所能选择的对系统资源消耗最少的策略（局部最优），
如果有多个满足要求的策略，选最后一个。
输入描述：
第一行表示用户个数n 接下来每一行表示一个用户分别使用三个策略的系统消耗 resA resB resC
输出描述：
最优策略组合下的总的系统资源消耗数
所有策略对系统的资源消耗均为正整数，n < 1000
实例：
输入：
3
15 8 17
12 20 9
11 7 5
输出：
24
 *
 * @date: 2022/6/21 11:32 下午
 * @version: V-1.0
 */
public class 用户调度问题_0715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        //存入二维数组中
        int[][] allResArr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] strArr = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                allResArr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        dispatch(allResArr);
    }

    private static int totalCount = Integer.MAX_VALUE;

    private static void dispatch(int[][] allResArr) {
        //路径
        LinkedList<Integer> track = new LinkedList<>();
        dfs(track, 0, allResArr, -1);
        System.out.println(totalCount);
    }

    private static void dfs(LinkedList<Integer> track, int n, int[][] allResArr, int preChoice) {
        //判断结束
        if (n == allResArr.length) {
            totalCount = Math.min(totalCount, track.stream().mapToInt(value -> (int) value).sum());
            return;
        }
        //做选择
        for (int i = 0; i < allResArr[0].length; i++) {
            //跳过上一个策略
            if (i == preChoice) {
                continue;
            }
            //选择
            track.addLast(allResArr[n][i]);
            //递归
            dfs(track, n + 1, allResArr, i);
            //回溯
            track.removeLast();
        }
    }
}
