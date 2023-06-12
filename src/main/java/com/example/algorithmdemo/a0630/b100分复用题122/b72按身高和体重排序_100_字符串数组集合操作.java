package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b72按身高和体重排序_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417927

 * @date: 2023/6/4 9:29
 * @version: V-1.0
 */
public class b72按身高和体重排序_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println(getResult(n, heights, weights));
    }

    private static String getResult(int n, int[] heights, int[] weights) {
        int[][] students = new int[n][3];

        for (int i = 0; i < n; i++) {
            students[i] = new int[] {heights[i], weights[i], i + 1};
        }

        Arrays.sort(
                students, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

        StringJoiner sj = new StringJoiner(" ");
        for (int[] student : students) {
            sj.add(student[2] + "");
        }
        return sj.toString();
    }
}
