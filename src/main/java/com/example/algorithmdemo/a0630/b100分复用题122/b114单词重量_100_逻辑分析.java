package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b114单词重量_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128052256

 * @date: 2023/6/4 9:48
 * @version: V-1.0
 */
public class b114单词重量_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        double sum = 0;
        for (String s : arr) {
            sum += s.length();
        }

        System.out.println(String.format("%.2f", sum / arr.length).toString());
    }
}
