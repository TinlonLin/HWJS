package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b19学生方阵_200_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127710440

 * @date: 2023/6/4 9:58
 * @version: V-1.0
 */
public class b19学生方阵_200_逻辑分析 {
    static int n;
    static int m;
    static String[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.next();
            }
        }

        System.out.println(getResult());
    }

    public static int getResult() {
        int ans = 0;

        int[][] offsets = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("M".equals(matrix[i][j])) {
                    for (int[] offset : offsets) {
                        int oldI = i - offset[0];
                        int oldJ = j - offset[1];

                        if (oldI >= 0 && oldI < n && oldJ >= 0 && oldJ < m && "M".equals(matrix[oldI][oldJ])) {
                            continue;
                        }

                        int len = 1;
                        int newI = i + offset[0];
                        int newJ = j + offset[1];

                        while (newI >= 0
                                && newI < n
                                && newJ >= 0
                                && newJ < m
                                && "M".equals(matrix[newI][newJ])) {
                            len++;
                            newI += offset[0];
                            newJ += offset[1];
                        }

                        ans = Math.max(ans, len);
                    }
                }
            }
        }

        return ans;
    }
}
