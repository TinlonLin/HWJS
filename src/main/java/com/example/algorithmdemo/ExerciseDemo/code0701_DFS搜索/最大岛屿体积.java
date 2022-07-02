package com.example.algorithmdemo.ExerciseDemo.code0701_DFS搜索;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 最大岛屿体积
 * @desc: 最大岛屿体积
 * https://blog.csdn.net/weixin_44052055/article/details/124249565
 *
题目描述
给你一个由 大于0的数（陆地）和 0（水）组成的的二维网格，请你计算网格中最大岛屿的体积。陆地的数表示所在岛屿的体积。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

输入描述
第一行是二维网格的宽和高。
后面几行是二维网格。

输出描述
输出岛屿的最大体积。

样例
输入
5 5
0 1 1 0 0
0 1 1 0 0
0 0 0 0 0
0 0 1 2 3
0 0 1 3 9
输出
19
思路分析
这道题完完全全就是leetcode上的200.岛屿的数量，那道题是统计岛屿的个数，这个题是统计最大岛屿的体积。在dfs里面累加各个小岛屿的体积，然后在外面判断是否最大。

 *
 * @date: 2022/7/2 22:21
 * @version: V-1.0
 */
public class 最大岛屿体积 {
    public static int area;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] map = new int[row][col];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] > 0) {
                    area = 0;
                    dfs(map, i, j);
                    max = Math.max(area, max);
                }
            }
        }
        System.out.println(max);
    }

    public static void dfs(int[][] map, int i, int j) {
        int row = map.length, col = map[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || map[i][j] == 0) {
            return;
        }
        area += map[i][j];
        map[i][j] = 0;
        dfs(map, i-1, j);
        dfs(map, i+1, j);
        dfs(map, i, j-1);
        dfs(map, i, j+1);
    }
}
