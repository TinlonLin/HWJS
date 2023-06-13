package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b35机器人走迷宫_200_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711610

 * @date: 2023/6/4 10:04
 * @version: V-1.0
 */
public class b35机器人走迷宫_200_深度优先搜索DFS {
    static int x;
    static int y;
    static int n;
    static int[][] poses;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 行数
        x = sc.nextInt();
        // 列数
        y = sc.nextInt();
        // 墙数
        n = sc.nextInt();

        // 墙位置
        poses = new int[n][2];
        for (int i = 0; i < n; i++) {
            poses[i][0] = sc.nextInt();
            poses[i][1] = sc.nextInt();
        }

        getResult();
    }

    public static void getResult() {
        matrix = new int[x][y];

        for (int[] pos : poses) {
            int i = pos[0];
            int j = pos[1];
            // 墙点值为1，非墙点值为0
            matrix[i][j] = 1;
        }

        // 可达点值为2
        matrix[x - 1][y - 1] = 2;

        dfs(0, 0);

        // 陷阱数量
        int trap = 0;
        // 不可达点数量
        int unreach = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    unreach++;
                } else if (matrix[i][j] == -1) {
                    trap++;
                }
            }
        }

        System.out.println(trap + " " + unreach);
    }

    public static boolean dfs(int cx, int cy) {
        if (cx >= x || cy >= y) {
            return false;
        }
        if (matrix[cx][cy] == 1) {
            return false;
        }
        if (matrix[cx][cy] == -1) {
            return false;
        }
        if (matrix[cx][cy] == 2) {
            return true;
        }

        if (matrix[cx][cy] == 0) {
            boolean east = dfs(cx + 1, cy);
            boolean north = dfs(cx, cy + 1);

            if (east || north) {
                // 如果向东可达或者向北可达，则当前点可达，将值设为2
                matrix[cx][cy] = 2;
            } else {
                // 如果向东，向北都不可达，则当前前也是不可达点，将值设为-1
                matrix[cx][cy] = -1;
            }
        }

        return matrix[cx][cy] == 2;
    }
}
