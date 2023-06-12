package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b108流水线_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417967

 * @date: 2023/6/4 9:45
 * @version: V-1.0
 */
public class b108流水线_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] times = new int[n];
        for (int i = 0; i < n; i++) times[i] = sc.nextInt();

        System.out.println(getResult(m, n, times));
    }

    private static int getResult(int m, int n, int[] times) {
        Arrays.sort(times);

        int[] mArr = new int[m];
        for (int i = 0; i < n; i++) {
            mArr[i % m] += times[i];
        }

        return Arrays.stream(mArr).max().orElse(0);
    }
}
