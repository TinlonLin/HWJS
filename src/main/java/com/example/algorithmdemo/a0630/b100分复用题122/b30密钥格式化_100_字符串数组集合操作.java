package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b30密钥格式化_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127953338

 * @date: 2023/6/4 8:57
 * @version: V-1.0
 */
public class b30密钥格式化_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String str = sc.next();

        System.out.println(getResult(k, str));
    }

    private static String getResult(int k, String str) {
        String[] sArr = str.split("-");

        String first = sArr[0];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < sArr.length; i++) {
            sb.append(sArr[i]);
        }
        String[] tmp = sb.toString().split("");

        StringBuilder upper = new StringBuilder();
        upper.append(first);
        for (int i = 0; i < tmp.length; i++) {
            String v = tmp[i].toUpperCase();
            if (i % k == 0) v = "-" + v;
            upper.append(v);
        }

        return upper.toString();
    }
}
