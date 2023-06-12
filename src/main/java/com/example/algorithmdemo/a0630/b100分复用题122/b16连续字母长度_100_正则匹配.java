package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b16连续字母长度_100_正则匹配
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127238467

 * @date: 2023/6/4 8:51
 * @version: V-1.0
 */
public class b16连续字母长度_100_正则匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(getResult(s, k));
    }

    private static int getResult(String s, int k) {
        s += "0";

        HashMap<Character, Integer> count = new HashMap<>();

        char b = s.charAt(0);
        int len = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (b == c) {
                len++;
            } else {
                if (!count.containsKey(b) || count.get(b) < len) {
                    count.put(b, len);
                }
                len = 1;
                b = c;
            }
        }

        Integer[] arr = count.values().toArray(new Integer[0]);

        if (k > arr.length) {
            return -1;
        } else {
            Arrays.sort(arr, (x, y) -> y - x);
            return arr[k - 1];
        }
    }
}
