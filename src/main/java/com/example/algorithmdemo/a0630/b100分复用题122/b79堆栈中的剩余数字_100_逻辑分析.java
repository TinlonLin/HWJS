package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b79堆栈中的剩余数字_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711549

 * @date: 2023/6/4 9:32
 * @version: V-1.0
 */
public class b79堆栈中的剩余数字_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    private static String getResult(Integer[] arr) {
        int n = arr.length;

        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        for (int i = 1; i < n; i++) {
            if (dp[i - 1] == arr[i]) {
                arr[i] *= 2;
                Arrays.fill(arr, 0, i, 0);
                Arrays.fill(dp, 0, i, 0);
                continue;
            }

            if (dp[i - 1] > arr[i]) {
                int preSum = dp[i - 1] - arr[i];
                for (int j = 0; j < i - 1; j++) {
                    if (dp[j] == preSum) {
                        arr[i] *= 2;
                        Arrays.fill(arr, j + 1, i, 0);
                        Arrays.fill(dp, j + 1, i, dp[j]);
                        break;
                    }

                    if (dp[j] > preSum) {
                        break;
                    }
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                sj.add(arr[i] + "");
            }
        }
        return sj.toString();
    }
}
