package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b15字符串筛选排序_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127944487
 *
 * @date: 2023/6/4 8:51
 * @version: V-1.0
 */
public class b15字符串筛选排序_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int k = sc.nextInt();

        System.out.println(getResult(str, k));
    }

    public static int getResult(String str, int k) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        if (k > str.length()) {
            k = str.length();
        }

        char tar = chars[k - 1];
        return str.indexOf(tar);
    }
}
