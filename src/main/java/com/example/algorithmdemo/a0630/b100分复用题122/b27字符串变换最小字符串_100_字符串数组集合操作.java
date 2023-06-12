package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b27字符串变换最小字符串_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418499

 * @date: 2023/6/4 8:56
 * @version: V-1.0
 */
public class b27字符串变换最小字符串_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    private static String getResult(String s) {
        char[] minSArr = s.toCharArray();
        Arrays.sort(minSArr);

        String minS = new String(minSArr);
        if (minS.equals(s)) return s;

        char[] sArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (sArr[i] != minSArr[i]) {
                char tmp = sArr[i];
                sArr[i] = minSArr[i];

                int swapIndex = s.lastIndexOf(minSArr[i]);
                sArr[swapIndex] = tmp;
                break;
            }
        }

        return new String(sArr);
    }
}
