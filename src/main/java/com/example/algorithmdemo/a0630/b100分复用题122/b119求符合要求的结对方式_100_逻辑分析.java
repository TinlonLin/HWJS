package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b119求符合要求的结对方式_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128058611

 * @date: 2023/6/4 9:50
 * @version: V-1.0
 */
public class b119求符合要求的结对方式_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();

        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        System.out.println(getResult(arr, n));
    }

    private static int getResult(int[] arr, int n) {
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                int sum = arr[i] + arr[j];
                if (sum == n) ans++;
                else if (sum < n) break;
            }
        }

        return ans;
    }
}
