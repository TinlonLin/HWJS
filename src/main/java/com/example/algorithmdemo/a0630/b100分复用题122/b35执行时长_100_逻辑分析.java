package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b35执行时长_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417767

 * @date: 2023/6/4 9:00
 * @version: V-1.0
 */
public class b35执行时长_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxCount = sc.nextInt();

        int n = sc.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) tasks[i] = sc.nextInt();

        System.out.println(getResult(maxCount, tasks));
    }

    private static int getResult(int maxCount, int[] tasks) {
        int time = 0;
        int remain = 0;

        for (int task : tasks) {
            if (task + remain > maxCount) {
                remain = task + remain - maxCount;
            } else {
                remain = 0;
            }
            time++;
        }

        while (remain > 0) {
            remain -= maxCount;
            time++;
        }

        return time;
    }
}
