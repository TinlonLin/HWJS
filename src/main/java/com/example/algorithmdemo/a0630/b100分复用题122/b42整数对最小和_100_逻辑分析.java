package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b42整数对最小和_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127969628

 * @date: 2023/6/4 9:04
 * @version: V-1.0
 */
public class b42整数对最小和_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();

        int k = sc.nextInt();

        System.out.println(getResult(arr1, arr2, k));
    }

    private static int getResult(int[] arr1, int[] arr2, int k) {
        ArrayList<Integer> pairs = new ArrayList<>();

        for (int v1 : arr1) {
            for (int v2 : arr2) {
                pairs.add(v1 + v2);
            }
        }

        pairs.sort((a, b) -> a - b);

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += pairs.get(i);
        }

        return sum;
    }
}
