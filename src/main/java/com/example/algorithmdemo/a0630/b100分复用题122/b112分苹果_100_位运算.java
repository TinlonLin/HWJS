package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b112分苹果_100_位运算
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128049760

 * @date: 2023/6/4 9:47
 * @version: V-1.0
 */
public class b112分苹果_100_位运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getResult(n, arr));
    }

    private static int getResult(int n, int[] arr) {
        Arrays.sort(arr);

        int min = arr[0];
        int fault = min, correct = min;

        for (int i = 1; i < arr.length; i++) {
            int w = arr[i];
            fault ^= w;
            correct += w;
        }

        if (fault == 0) {
            return correct - min;
        } else {
            return -1;
        }
    }
}
