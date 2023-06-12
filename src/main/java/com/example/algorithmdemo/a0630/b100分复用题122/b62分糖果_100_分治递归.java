package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b62分糖果_100_分治递归
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/126009910

 * @date: 2023/6/4 9:22
 * @version: V-1.0
 */
public class b62分糖果_100_分治递归 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLong()));
    }

    private static long getResult(long num) {
        int[] ans = {Integer.MAX_VALUE};
        recursive(num, 0, ans);
        return ans[0];
    }

    private static void recursive(long num, int count, int[] ans) {
        if (num == 1) {
            ans[0] = Math.min(ans[0], count);
            return;
        }

        if (num % 2 == 0) {
            recursive(num / 2, count + 1, ans);
        } else {
            recursive(num + 1, count + 1, ans);
            recursive(num - 1, count + 1, ans);
        }
    }
}
