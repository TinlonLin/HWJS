package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b32查找接口成功率最优时间段_100_动态规划加前缀和应用
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127957656

 * @date: 2023/6/4 8:58
 * @version: V-1.0
 */
public class b32查找接口成功率最优时间段_100_动态规划加前缀和应用 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minAverageLost = Integer.parseInt(sc.nextLine());

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr, minAverageLost));
    }

    private static String getResult(Integer[] arr, int minAverageLost) {
        int n = arr.length;

        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        ArrayList<Integer[]> ans = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = i == 0 ? dp[j] : dp[j] - dp[i - 1];
                int len = j - i + 1;
                int lost = len * minAverageLost;

                if (sum <= lost) {
                    if (len > maxLen) {
                        ans = new ArrayList<>();
                        ans.add(new Integer[] {i, j});
                        maxLen = len;
                    } else if (len == maxLen) {
                        ans.add(new Integer[] {i, j});
                    }
                }
            }
        }

        ans.sort((a, b) -> a[0] - b[0]);

        StringJoiner sj = new StringJoiner(" ");
        for (Integer[] an : ans) {
            sj.add(an[0] + "-" + an[1]);
        }
        return sj.toString();
    }
}
