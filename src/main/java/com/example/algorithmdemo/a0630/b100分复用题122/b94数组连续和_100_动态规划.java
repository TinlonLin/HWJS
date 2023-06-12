package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b94数组连续和_100_动态规划
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127170844

 * @date: 2023/6/4 9:40
 * @version: V-1.0
 */
public class b94数组连续和_100_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(getResult(n, x, arr));
    }

    private static int getResult(int n, int x, int[] arr) {
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        int l = 0;
        int r = 1;
        int ans = 0;

        while (r <= n) {
            if (preSum[r] - preSum[l] >= x) {
                ans += n - r + 1;
                l++;
                r = l + 1;
            } else {
                r++;
            }
        }

        return ans;
    }
}
