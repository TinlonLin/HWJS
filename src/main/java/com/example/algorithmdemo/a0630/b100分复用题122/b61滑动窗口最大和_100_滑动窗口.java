package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b61滑动窗口最大和_100_滑动窗口
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128006147

 * @date: 2023/6/4 9:22
 * @version: V-1.0
 */
public class b61滑动窗口最大和_100_滑动窗口 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        System.out.println(getResult(n, arr, m));
    }

    private static int getResult(int n, int[] arr, int m) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            // 初始滑窗内部和
            sum += arr[i];
        }

        int ans = sum;

        for (int i = 1; i <= n - m; i++) {
            // 基于初始滑窗进行差异求和，避免O(n)求和
            sum += arr[i + m - 1] - arr[i - 1];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
