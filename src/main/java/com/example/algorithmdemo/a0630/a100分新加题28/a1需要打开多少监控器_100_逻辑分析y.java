package com.example.algorithmdemo.a0630.a100分新加题28;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 需要打开多少监控器_100_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130632804
题目描述：
某长方形停车场，每个车位上方都有对应监控器，当且仅当在当前车位或者前后左右四个方向任意一个车位范围停车时，监控器才需要打开；
给出某一时刻停车场的停车分布，请统计最少需要打开多少个监控器；
输入描述：
第一行输入m，n表示长宽，满足1 < m,n <= 20；
后面输入m行，每行有n个0或1的整数，整数间使用一个空格隔开，表示该行已停车情况，其中0表示空位，1表示已停；
输出描述：
最少需要打开监控器的数量；
用例：
输入：
3 3
0 0 0
0 1 0
0 0 0
输出：
5

思路：
1的车位必须计算，1的上下左右车位旁边如果是1也需要计算一个车位，最终获得总的车位
 * @date: 2023/6/4 8:19
 * @version: V-1.0
 */
public class a1需要打开多少监控器_100_逻辑分析y {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mnStr = sc.nextLine().split(" ");
        int m = Integer.parseInt(mnStr[0]);
        int n = Integer.parseInt(mnStr[1]);

        int[][] park = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] tempPark = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                park[i][j] = Integer.parseInt(tempPark[j]);
            }
        }
        getMinMonitorCount(m, n, park);
    }

    public static void getMinMonitorCount(int m, int n, int[][] matrix) {
        int count = 0;
        int[][] offsets = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //先统计1的车位数
                if (1 == matrix[i][j]) {
                    count++;
                    continue;
                }
                //再统计四周的车位数
                for (int[] offset : offsets) {
                    int newX = i + offset[0];
                    int newY = j + offset[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && 1 == matrix[newX][newY]) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
