package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b38最大N个数与最小N个数的和_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417952

 * @date: 2023/6/4 9:01
 * @version: V-1.0
 */
public class b38最大N个数与最小N个数的和_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        System.out.println(getResult(m, arr, n));
    }

    private static int getResult(int m, int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();

        for (int val : arr) {
            if (val < 0 || val > 1000) {
                return -1;
            }
            set.add(val);
        }

        if (set.size() < n * 2) {
            return -1;
        }

        Integer[] distinct_arr = set.toArray(new Integer[0]);

        Arrays.sort(distinct_arr, (a, b) -> a - b);

        int l = 0;
        int r = distinct_arr.length - 1;
        int ans = 0;

        while (n > 0) {
            ans += distinct_arr[l] + distinct_arr[r];
            l++;
            r--;
            n--;
        }

        return ans;
    }
}
