package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b21字符串比较_200_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418393

 * @date: 2023/6/4 9:59
 * @version: V-1.0
 */
public class b21字符串比较_200_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();
        int v = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(a, b, v));
    }

    private static int getResult(String a, String b, int v) {
        int n = a.length();

        // a,b字符串的各位字符的ascii绝对值差距数组
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + Math.abs(a.charAt(i - 1) - b.charAt(i - 1));
        }

        // 记录题解
        int ans = 0;

        for (int l = 0; l <= n - 1; l++) {
            for (int r = l + 1; r <= n; r++) {
                // 区间 [l+1, r]的和 = preSum[r] - preSum[l]
                if (preSum[r] - preSum[l] <= v) {
                    ans = Math.max(ans, r - l);
                }
            }
        }

        return ans;
    }
}
