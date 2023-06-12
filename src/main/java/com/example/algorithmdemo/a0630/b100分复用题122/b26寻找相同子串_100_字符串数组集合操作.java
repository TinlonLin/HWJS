package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b26寻找相同子串_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/125994564

 * @date: 2023/6/4 8:55
 * @version: V-1.0
 */
public class b26寻找相同子串_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine(), sc.nextLine()));
    }

    private static String getResult(String str, String subStr) {
        if (str.length() < subStr.length()) {
            return "No";
        }

        int idx = str.indexOf(subStr);
        if (idx == -1) {
            return "No";
        } else {
            return idx + 1 + "";
        }
    }
}
