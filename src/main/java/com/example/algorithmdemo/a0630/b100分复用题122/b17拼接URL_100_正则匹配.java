package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b17拼接URL_100_正则匹配
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/126005113

 * @date: 2023/6/4 8:52
 * @version: V-1.0
 */
public class b17拼接URL_100_正则匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(",");

        String prefix = arr.length > 0 ? arr[0] : "";
        String suffix = arr.length > 1 ? arr[1] : "";

        System.out.println(getResult(prefix, suffix));
    }

    private static String getResult(String prefix, String suffix) {
        String res = "/" + prefix + "/" + suffix;
        return res.replaceAll("/+", "\\/");
    }
}
