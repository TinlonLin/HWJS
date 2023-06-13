package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b60演唱会计算最多能看几场演唱会_200_区间问题最多不相交区间个数
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128192404

 * @date: 2023/6/4 10:16
 * @version: V-1.0
 */
public class b60演唱会计算最多能看几场演唱会_200_区间问题最多不相交区间个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            // 开始时间
            ranges[i][0] = sc.nextInt();
            // 结束时间 = 开始时间 + 持续时间
            ranges[i][1] = ranges[i][0] + sc.nextInt();
        }

        System.out.println(getResult(ranges));
    }

    public static int getResult(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[1] - b[1]);

        int t = ranges[0][1];
        int ans = 1;

        for (int i = 1; i < ranges.length; i++) {
            int l = ranges[i][0];
            int r = ranges[i][1];

            if (l - t >= 15) {
                ans++;
                t = r;
            }
        }

        return ans;
    }
}
