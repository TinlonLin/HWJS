package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b117求解连续数列_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128057475

 * @date: 2023/6/4 9:49
 * @version: V-1.0
 */
public class b117求解连续数列_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(getResult(sum, n));
    }

    public static String getResult(int sum, int n) {
        int left, right;

        if (n % 2 == 0) {
            int halfLen = n / 2 - 1;
            left = sum / n - halfLen;
            right = sum / n + 1 + halfLen;
        } else {
            int mid = sum / n;
            int halfLen = n / 2;
            left = mid - halfLen;
            right = mid + halfLen;
        }

        if (left < 0) {
            return "-1";
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = left; i <= right; i++) {
            sj.add(i + "");
        }
        return sj.toString();
    }
}
