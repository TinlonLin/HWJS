package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b46竖直四子棋_200_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127710561

 * @date: 2023/6/4 10:11
 * @version: V-1.0
 */
public class b46竖直四子棋_200_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tmp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = tmp[0];
        int m = tmp[1];

        int[] cols = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(n, m, cols));
    }

    /**
     * @param n 宽 ，矩阵列数
     * @param m 高，矩阵行数
     * @param cols 落子的列的编号
     */
    private static String getResult(int n, int m, int[] cols) {
        int r = m;
        int c = n;

        // 构造棋盘，注意棋盘长宽都+1了，方便后面棋子获取
        int[][] matrix = new int[r + 1][c + 1];

        // 这里i对应第几步，由于题目是从第1步开始算，而这里 i 从0开始算，因此最终返回要i+1
        for (int i = 0; i < cols.length; i++) {
            // cols[i]代表第 i 步下在第几列
            if (cols[i] < 1 || cols[i] > c) return i + 1 + ",error";

            // player落子颜色：1代表红色，2代表蓝色
            int player = i % 2 == 0 ? 1 : 2;

            // 落子逻辑
            int x = m;
            int y = cols[i];
            while (matrix[x][y] > 0) {
                x--; // 如果当前列底部有棋子，则需要往上查找
                if (x < 1) return i + 1 + ",error"; // 如果当前列已经放满棋子，则报错
            }
            matrix[x][y] = player; // 如果当前列底部没有棋子，则可以放入

            // i >= 6，即第七步及之后落子时，才可能产生四连击
            if (i >= 6 && isFour(x, y, player, matrix, r, c)) {
                return i + 1 + "," + (player == 1 ? "red" : "blue");
            }
        }

        // 双方都没有获胜
        return "0,draw";
    }

    // 上，左，左上，左下
    static int[][] offsets = {{-1, 0}, {0, -1}, {-1, -1}, {-1, 1}};

    public static boolean isFour(int x, int y, int player, int[][] matrix, int r, int c) {
        for (int[] offset : offsets) {
            int len = 1;

            // 向着某个方向延申判断是否存在相同子
            int x1 = x, y1 = y;
            while (true) {
                x1 += offset[0];
                y1 += offset[1];

                if (x1 >= 1 && x1 <= r && y1 >= 1 && y1 <= c && matrix[x1][y1] == player) {
                    len++;
                } else {
                    break;
                }
            }

            // 向着上面方向的反方向延申判断是否存在相同子（两个相反方向其实处于一条线上）
            int x2 = x, y2 = y;
            while (true) {
                x2 -= offset[0];
                y2 -= offset[1];

                if (x2 >= 1 && x2 <= r && y2 >= 1 && y2 <= c && matrix[x2][y2] == player) {
                    len++;
                } else {
                    break;
                }
            }

            // 如果此线可以形成四子连击，则直接返回true
            if (len == 4) {
                return true;
            }
        }

        return false;
    }
}
