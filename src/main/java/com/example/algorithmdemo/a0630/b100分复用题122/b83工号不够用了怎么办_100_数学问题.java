package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b83工号不够用了怎么办_100_数学问题
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128022017

 * @date: 2023/6/4 9:35
 * @version: V-1.0
 */
public class b83工号不够用了怎么办_100_数学问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println((int) Math.max(1, Math.ceil(Math.log10(x / Math.pow(26, y)))));
    }
}
