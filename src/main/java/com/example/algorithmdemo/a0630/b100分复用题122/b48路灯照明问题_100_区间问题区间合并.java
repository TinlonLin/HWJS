package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b48路灯照明问题_100_区间问题区间合并
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127341822

 * @date: 2023/6/4 9:06
 * @version: V-1.0
 */
public class b48路灯照明问题_100_区间问题区间合并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            int center = i * 100;
            int r = sc.nextInt();
            ranges[i][0] = center - r;
            ranges[i][1] = center + r;
        }

        System.out.println(getResult(n, ranges));
    }

    private static int getResult(int n, int[][] ranges) {
        int ans = 0;

        // 按起始位置升序，起始位置相同，则继续按结束位置降序
        Arrays.sort(ranges, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        // 上一个区间的结束位置
        int t = ranges[0][1];

        for (int i = 1; i < n; i++) {
            // 当前区间的【开始位置，结束位置】
            int s = ranges[i][0];
            int e = ranges[i][1];

            // 有交集
            if (t >= s) {
                // 合并后的新区间将变为下一轮的上一个区间，t为新区间的结束位置
                t = Math.max(e, t);
            } else {
                // 没有交集，则统计区间间隙 s - t
                ans += s - t;
                // 当前区间变为下一轮的上一个区间，更新t
                t = e;
            }
        }

        return ans;
    }
}
