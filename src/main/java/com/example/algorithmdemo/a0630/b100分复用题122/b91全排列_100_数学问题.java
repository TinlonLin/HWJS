package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b91全排列_100_数学问题
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128024622

 * @date: 2023/6/4 9:39
 * @version: V-1.0
 */
public class b91全排列_100_数学问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getResult(s));
    }

    private static int getResult(String s) {
        int total = getFact(s.length());

        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }

        for (Character k : count.keySet()) {
            int n = count.get(k);
            if (n > 1) {
                total /= getFact(n);
            }
        }

        return total;
    }

    private static int getFact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
