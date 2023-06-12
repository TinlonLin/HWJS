package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b68整型数组按个位值排序_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128006528

 * @date: 2023/6/4 9:27
 * @version: V-1.0
 */
public class b68整型数组按个位值排序_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        System.out.println(getResult(arr));
    }

    private static String getResult(String[] arr) {
        Arrays.sort(arr, (a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));

        StringJoiner sj = new StringJoiner(",");
        for (String s : arr) {
            sj.add(s);
        }
        return sj.toString();
    }
}
