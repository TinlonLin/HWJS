package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b99停车场车辆统计_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127205555

 * @date: 2023/6/4 9:42
 * @version: V-1.0
 */
public class b99停车场车辆统计_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str =
                sc.nextLine()
                        .replaceAll(",", "")
                        .replaceAll("111", "x")
                        .replaceAll("11", "x")
                        .replaceAll("1", "x");

        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
