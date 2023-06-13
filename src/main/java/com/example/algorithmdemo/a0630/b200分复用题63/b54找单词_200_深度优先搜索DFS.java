package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b54找单词_200_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711515

 * @date: 2023/6/4 10:14
 * @version: V-1.0
 */
public class b54找单词_200_深度优先搜索DFS {
    static int n;
    static String[][] matrix;
    static String tar;

    public static void main(String[] args) {
        // 将输入分隔符改为“,”和换行
        Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");

        n = sc.nextInt();

        matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.next();
            }
        }

        tar = sc.next();

        System.out.println(getResult());
    }

    private static String getResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                LinkedList<Integer[]> path = new LinkedList<>();
                if (dfs(i, j, 0, path)) {
                    StringJoiner sj = new StringJoiner(",");
                    for (Integer[] pos : path) {
                        sj.add(pos[0] + "," + pos[1]);
                    }
                    return sj.toString();
                }
            }
        }
        return "N";
    }

    private static boolean dfs(int i, int j, int k, LinkedList<Integer[]> path) {
        if (i < 0 || i >= n || j < 0 || j >= n || !tar.substring(k, k + 1).equals(matrix[i][j])) {
            return false;
        }

        path.add(new Integer[] {i, j});
        if (path.size() == tar.length()) return true;

        String tmp = matrix[i][j];
        matrix[i][j] = null;

        boolean res =
                dfs(i - 1, j, k + 1, path)
                        || dfs(i + 1, j, k + 1, path)
                        || dfs(i, j - 1, k + 1, path)
                        || dfs(i, j + 1, k + 1, path);

        if (!res) {
            matrix[i][j] = tmp;
            path.removeLast();
        }

        return res;
    }
}
