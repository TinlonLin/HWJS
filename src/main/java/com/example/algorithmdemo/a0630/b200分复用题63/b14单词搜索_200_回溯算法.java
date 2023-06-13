package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b14单词搜索_200_回溯算法
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711035

 * @date: 2023/6/4 9:56
 * @version: V-1.0
 */
public class b14单词搜索_200_回溯算法 {
    static String[] matrix;
    static String word;
    static int n;
    static int m;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        word = sc.next();

        matrix = new String[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.next();
        }

        System.out.println(getResult());
    }

    public static String getResult() {
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backTracking(i, j, 0)) {
                    return (i + 1) + " " + (j + 1);
                }
            }
        }

        return "NO";
    }

    public static boolean backTracking(int i, int j, int k) {
        if (k == word.length()) return true;

        if (i < 0
                || i >= n
                || j < 0
                || j >= m
                || visited[i][j]
                || matrix[i].charAt(j) != word.charAt(k)) {
            return false;
        }

        visited[i][j] = true;

        int newK = k + 1;
        boolean res =
                backTracking(i - 1, j, newK)
                        || backTracking(i + 1, j, newK)
                        || backTracking(i, j - 1, newK)
                        || backTracking(i, j + 1, newK);

        visited[i][j] = false;
        return res;
    }
}
