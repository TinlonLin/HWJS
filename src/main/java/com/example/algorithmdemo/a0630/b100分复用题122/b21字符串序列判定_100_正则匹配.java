package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b21字符串序列判定_100_正则匹配
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127228559
 *
 * @date: 2023/6/4 8:53
 * @version: V-1.0
 */
public class b21字符串序列判定_100_正则匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String l = sc.nextLine();

        System.out.println(getResult(s, l));
    }

    public static int getResult(String s, String l) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < l.length()) {
            if (s.charAt(i) == l.charAt(j)) {
                i++;
            }
            j++;
        }

        if (i == s.length()) {
            return j - 1;
        } else return -1;
    }
}
