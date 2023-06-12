package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b105找车位_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127341984

 * @date: 2023/6/4 9:44
 * @version: V-1.0
 */
public class b105找车位_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine().split(",")));
    }

    private static int getResult(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        String[] sArr = sb.toString().split("1");
        int maxLen = 0;

        for (int i = 0; i < sArr.length; i++) {
            String ele = sArr[i];

            if (i == 0 || i == sArr.length - 1) {
                maxLen = Math.max(maxLen, ele.length());
            } else {
                if (ele.length() == 1) {
                    maxLen = Math.max(maxLen, 1);
                } else {
                    maxLen = Math.max(maxLen, ele.length() / 2);
                }
            }
        }

        return maxLen;
    }
}
