package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b33最少面试官数_200_贪心思维
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128180152

 * @date: 2023/6/4 10:03
 * @version: V-1.0
 */
public class b33最少面试官数_200_贪心思维 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }

        System.out.println(getResult(m, n, ranges));
    }

    // 算法入口
    public static long getResult(int m, int n, int[][] ranges) {
        // 求解最大不相交区间时，需要将所有区间按照右边界升序
        Arrays.sort(ranges, (a, b) -> a[1] - b[1]);

        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buckets.add(new LinkedList<>());
        }

        for (int[] range : ranges) {
            int s = range[0];
            int e = range[1];

            for (LinkedList<Integer> bucket : buckets) {
                // 每个面试官最多面试m次
                if (bucket.size() < m && (bucket.size() == 0 || bucket.getLast() <= s)) {
                    bucket.add(e);
                    break;
                }
            }
        }

        return buckets.stream().filter(bucket -> bucket.size() > 0).count();
    }
}
