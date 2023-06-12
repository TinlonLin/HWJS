package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b25数列描述_100_动态规划
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127232067

 * @date: 2023/6/4 8:55
 * @version: V-1.0
 */
public class b25数列描述_100_动态规划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getSeq(n));
    }

    private static String getSeq(int n) {
        String base = "1";
        for (int i = 1; i <= n; i++) {
            base = describe(base);
        }
        return base;
    }

    private static String describe(String seq) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char val = seq.charAt(0);

        for (int i = 1; i < seq.length(); i++) {
            if (seq.charAt(i) == seq.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(val);
                count = 1;
                val = seq.charAt(i);
            }
        }
        sb.append(count).append(val);
        return sb.toString();
    }
}
