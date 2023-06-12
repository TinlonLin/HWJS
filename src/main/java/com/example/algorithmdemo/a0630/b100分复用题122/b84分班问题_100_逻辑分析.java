package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b84分班问题_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127248985

 * @date: 2023/6/4 9:36
 * @version: V-1.0
 */
public class b84分班问题_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        getResult(arr);
    }

    private static void getResult(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split("/");

            int idx = Integer.parseInt(tmp[0]);
            String isSame = tmp[1];

            if (idx <= 0 || idx >= 999) {
                System.out.println("ERROR");
                return;
            }

            arr[i] = isSame;
        }

        boolean[] res = new boolean[arr.length];
        res[0] = true;

        for (int i = 1; i < arr.length; i++) {
            if ("N".equals(arr[i])) {
                res[i] = !res[i - 1];
            } else {
                res[i] = res[i - 1];
            }
        }

        StringJoiner one = new StringJoiner(" ");
        StringJoiner two = new StringJoiner(" ");

        for (int i = 0; i < res.length; i++) {
            if (res[i]) {
                one.add(i + 1 + "");
            } else {
                two.add(i + 1 + "");
            }
        }

        System.out.println(one);
        System.out.println(two);
    }
}
