package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b58可以组成网络的服务器_200_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711451

 * @date: 2023/6/4 10:16
 * @version: V-1.0
 */
public class b58可以组成网络的服务器_200_深度优先搜索DFS {
    static int n;
    static int m;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult());
    }

    private static int getResult() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j, 0));
            }
        }

        return ans;
    }

    private static int dfs(int i, int j, int count) {
        if (i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] == 0) {
            return count;
        }

        count++;
        matrix[i][j] = 0;

        count = dfs(i - 1, j, count);
        count = dfs(i + 1, j, count);
        count = dfs(i, j - 1, count);
        count = dfs(i, j + 1, count);

        return count;
    }
}
