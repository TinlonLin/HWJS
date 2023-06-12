package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b106判断字符串子序列_100_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418484

 * @date: 2023/6/4 9:45
 * @version: V-1.0
 */
public class b106判断字符串子序列_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(getResult(sc.nextLine(), sc.nextLine()));
    }

    private static int getResult(String target, String source) {
        int cursor = target.length() - 1;
        for (int i = source.length() - 1; i >= 0; i--) {
            if (source.charAt(i) == target.charAt(cursor)) {
                cursor--;
                if (cursor < 0) return i;
            }
        }

        return -1;
    }
}
