package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b67数组组成的最小数字_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418118

 * @date: 2023/6/4 9:27
 * @version: V-1.0
 */
public class b67数组组成的最小数字_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().split(",");
        System.out.println(getResult(strs));
    }

    private static String getResult(String[] strs) {
        Arrays.sort(strs, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));

        String[] tmp = Arrays.copyOfRange(strs, 0, Math.min(3, strs.length));
        Arrays.sort(tmp, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(s);
        }

        return sb.toString();
    }
}
