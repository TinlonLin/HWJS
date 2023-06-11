package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b13按索引范围翻转文章片段_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127944343
 *
 * @date: 2023/6/4 8:50
 * @version: V-1.0
 */
public class b13按索引范围翻转文章片段_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int startIndex = Integer.parseInt(sc.nextLine());
        int endIndex = Integer.parseInt(sc.nextLine());
        System.out.println(getResult(s, startIndex, endIndex));
    }

    public static String getResult(String s, int startIndex, int endIndex) {
        String[] sArr = s.split(" ");

        startIndex = Math.min(Math.max(0, startIndex), sArr.length - 1);
        endIndex = Math.min(Math.max(0, endIndex), sArr.length - 1);

        if (startIndex >= endIndex) return s;

        int l = startIndex;
        int r = endIndex;
        while (l < r) {
            String tmp = sArr[l];
            sArr[l] = sArr[r];
            sArr[r] = tmp;
            l++;
            r--;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (String t : sArr) {
            sj.add(t);
        }
        return sj.toString();
    }
}
