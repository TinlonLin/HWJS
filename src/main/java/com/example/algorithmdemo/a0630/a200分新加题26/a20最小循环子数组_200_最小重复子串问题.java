package com.example.algorithmdemo.a0630.a200分新加题26;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/12 0:08
 * @ClassName: a20最小循环子数组_200_最小重复子串问题
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130773781
题目描述
给定一个由若干整数组成的数组nums，请检查数组是否是由某个子数组重复循环拼接而成，请输出这个最小的子数组。
输入描述
第一行输入数组中元素个数n，1 ≤ n ≤ 100000
第二行输入数组的数字序列nums，以空格分割，0 ≤ nums[i] < 10
输出描述
输出最小的子数组的数字序列，以空格分割；
备注
数组本身是其最大的子数组，循环1次可生成的自身；

用例
输入
9
1 2 1 1 2 1 1 2 1
输出
1 2 1
说明
数组[1,2,1,1,2,1,1,2,1] 可由子数组[1,2,1]重复循环3次拼接而成

 * @Version: V-1.0
 */
public class a20最小循环子数组_200_最小重复子串问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(n, nums));
    }

    public static String getResult(int n, int[] nums) {
        // KMP算法 前缀表求解
        int[] next = getNext(n, nums);

        // 最长相同前后缀长度
        int m = next[n - 1];

        // 最小重复子串的长度
        int len = n % (n - m) == 0 ? n - m : n;

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < len; i++) {
            sj.add(nums[i] + "");
        }
        return sj.toString();
    }

    public static int[] getNext(int n, int[] nums) {
        int[] next = new int[n];

        int j = 1;
        int k = 0;

        while (j < n) {
            if (nums[j] == nums[k]) {
                next[j] = k + 1;
                j++;
                k++;
            } else {
                if (k > 0) {
                    k = next[k - 1];
                } else {
                    j++;
                }
            }
        }

        return next;
    }
}
