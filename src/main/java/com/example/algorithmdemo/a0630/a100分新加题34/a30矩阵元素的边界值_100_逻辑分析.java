package com.example.algorithmdemo.a0630.a100分新加题34;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/10 22:25
 * @ClassName: a30矩阵元素的边界值_100_逻辑分析
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/131366366?spm=1001.2014.3001.5502
题目描述
给定一个N*M矩阵，请先找出M个该矩阵中每列元素的最大值，然后输出这M个值中的最小值
输入描述
无
输出描述
无
备注
N和M的取值范围均为：[0, 100]

用例
输入
[[1,2],[3,4]]
输出
3
说明
第一列元素为：1和3，最大值为3；
第二列元素为：2和4，最大值为4
各列最大值3和4的最小值为3


 *
 * @Version: V-1.0
 */
public class a30矩阵元素的边界值_100_逻辑分析 {
    // 输入输出处理
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int[][] matrix =
                Arrays.stream(line.substring(2, line.length() - 2).split("],\\["))
                        .map(s -> Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray())
                        .toArray(int[][]::new);

        System.out.println(getResult(matrix));
    }

    // 核心代码
    public static int getResult(int[][] matrix) {
        // 本题N和M取值是[0,100]，如果N或M取0的话，则本题没有结果，理论上应该不会出现这种情况，因为题目也没说
        if (matrix.length == 0 || matrix[0].length == 0) return -1;

        int[] cols_max_value = matrix[0]; // 取矩阵第一行作为每列的基准值

        // 从矩阵第二行开始遍历
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 保留每列的最大值
                cols_max_value[j] = Math.max(cols_max_value[j], matrix[i][j]);
            }
        }

        // 取每列最大值中的最小值
        return Arrays.stream(cols_max_value).min().orElse(0);
    }
}
