package com.example.algorithmdemo.a0630.a200分新加题26;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/6/14 21:49
 * @ClassName: a18战场索敌_200_dfs栈实现
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130774007
题目描述:
有一个大小是N*M的战场地图，被墙壁 '#' 分隔成大小不同的区域，
上下左右四个方向相邻的空地 '.' 属于同一个区域，只有空地上可能存在敌人'E”，
请求出地图上总共有多少区域里的敌人数小于K。
输入描述:
第一行输入为N,M,K；
N表示地图的行数，M表示地图的列数， K表示目标敌人数量
N，M<=100
之后为一个NxM大小的字符数组。
输出描述:
敌人数小于K的区域数量

用例
输入
3 5 2
..#EE
E.#E.
###..
输出
1
说明
地图被墙壁分为两个区域，左边区域有1个敌人，右边区域有3个敌人，符合条件的区域数量是1

 * @Version: V-1.0
 */
public class a19战场索敌_200_dfs栈实现 {
    static int n; // 地图行数
    static int m; // 地图列数
    static int k; // 区域敌军人数上限值
    static char[][] matrix; // 地图矩阵
    static boolean[][] visited; // 访问矩阵

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tmp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        m = tmp[1];
        k = tmp[2];

        visited = new boolean[n][m];

        matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

        System.out.println(getResult());
    }

    public static int getResult() {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || matrix[i][j] == '#') {
                    continue;
                }
                // 如果(i,j)位置未访问过，且不是墙，则进入深搜，深搜结果是深搜区域内的敌军数量，如果数量小于k，则该区域符合要求
                if(dfs(i, j) < k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // 上、下、左、右偏移量
    static int[][] offsets = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static int dfs(int i, int j) {
        // 该区域敌军数量
        int count = 0;

        // 标记该位置访问过
        visited[i][j] = true;

        // 如果对应位置是E，则敌军数量+1
        if (matrix[i][j] == 'E') count += 1;

        // 深搜依赖于栈结构，后进先出
        LinkedList<int[]> stack = new LinkedList<>();
        stack.add(new int[] {i, j});

        while (stack.size() > 0) {
            int[] pos = stack.removeLast();
            int x = pos[0], y = pos[1];

            // 遍历该位置的上下左右
            for (int[] offset : offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];

                // 如果新位置不越界，且未访问过，且不是墙，则继续深搜
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && matrix[newX][newY] != '#') {
                    // 标记该位置访问过
                    visited[newX][newY] = true;

                    // 如果对应位置是E，则敌军数量+1
                    if (matrix[newX][newY] == 'E') {
                        count++;
                    }

                    stack.add(new int[] {newX, newY});
                }
            }
        }

        return count;
    }
}
