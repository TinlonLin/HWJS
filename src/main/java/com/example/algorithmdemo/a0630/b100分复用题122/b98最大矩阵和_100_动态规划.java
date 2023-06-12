package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b98最大矩阵和_100_动态规划
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/126015916

 * @date: 2023/6/4 9:42
 * @version: V-1.0
 */
public class b98最大矩阵和_100_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(n, m, matrix));
    }

    private static int getResult(int n, int m, int[][] matrix) {
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // 一行子矩阵最大和
            dp.add(maxSubArraySum(matrix[i]));
            for (int j = i + 1; j < n; j++) {
                // 多行子矩阵最大和
                dp.add(maxSubArraySum(matrixZip(Arrays.copyOfRange(matrix, i, j + 1))));
            }
        }
        // 求出最大和
        return dp.stream().max((a, b) -> a - b).orElse(0);
    }

    // 最大子数组和求解
    private static int maxSubArraySum(int[] nums) {
        int[] dp = new int[nums.length];

        int res = dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 多行子矩阵，压缩为一行子数组
    private static int[] matrixZip(int[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        int[] zip = new int[cols];

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                zip[c] += matrix[r][c];
            }
        }

        return zip;
    }
}
