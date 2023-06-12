package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b36用户调度问题_100_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127342159

 * @date: 2023/6/4 9:01
 * @version: V-1.0
 */
public class b36用户调度问题_100_深度优先搜索DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int[][] res = new int[m][3];
        for (int i = 0; i < m; i++) {
            res[i][0] = sc.nextInt();
            res[i][1] = sc.nextInt();
            res[i][2] = sc.nextInt();
        }

        int[] ans = {Integer.MAX_VALUE};
        dfs(res, m, 0, -1, 0, ans);
        System.out.println(ans[0]);
    }

    private static void dfs(int[][] res, int m, int level, int index, int total, int[] ans) {
        if (level == m) {
            ans[0] = Math.min(ans[0], total);
            return;
        }

        int[] r = res[level];
        for (int i = 0; i < r.length; i++) {
            if (i != index) {
                dfs(res, m, level + 1, i, total + r[i], ans);
            }
        }
    }
}
