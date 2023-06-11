package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b5求满足条件的最长子串的长度_100_滑动窗口
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127341878
题目描述：
给定一个字符串，只包含字母和数字，按要求找出字符串中的最长（连续）子串的长度，字符串本身是其最长的子串，子串要求：
1、 只包含1个字母(a~z, A~Z)，其余必须是数字；
2、 字母可以在子串中的任意位置；
如果找不到满足要求的子串，如全是字母或全是数字，则返回-1。
输入描述：
字符串(只包含字母和数字)
输出描述：
子串的长度

用例
输入
abC124ACb
输出
4
说明
满足条件的最长子串是C124或者124A，长度都是4

输入
a5
输出
2
说明
字符串自身就是满足条件的子串，长度为2

输入
aBB9
输出
2
说明
满足条件的子串为B9，长度为2

输入
abcdef
输出
-1
说明
没有满足要求的子串，返回-1

 * @date: 2023/6/4 8:47
 * @version: V-1.0
 */
public class b5求满足条件的最长子串的长度_100_滑动窗口 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.next()));
    }

    private static int getResult(String str) {
        int maxLen = -1;
        boolean hasLetter = false;

        int l = 0, r = 0;
        LinkedList<Integer> letterIdx = new LinkedList<>();

        while (r < str.length()) {
            char c = str.charAt(r);

            if (isLetter(c)) {
                hasLetter = true;
                letterIdx.add(r);

                if (letterIdx.size() > 1) {
                    l = letterIdx.removeFirst() + 1;
                }

                if (r == l) {
                    r++;
                    continue;
                }
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        if (!hasLetter) {
            return -1;
        }
        return maxLen;
    }

    public static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
