package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b116输出指定字母在字符串中的索引_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128057331

 * @date: 2023/6/4 9:49
 * @version: V-1.0
 */
public class b116输出指定字母在字符串中的索引_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int idx = sc.nextInt();

        System.out.println(getResult(str, idx));
    }

    private static int getResult(String str, int idx) {
        char[] sArr = str.toCharArray();
        Arrays.sort(sArr);
        char target = sArr[idx - 1];
        return str.indexOf(target);
    }
}
