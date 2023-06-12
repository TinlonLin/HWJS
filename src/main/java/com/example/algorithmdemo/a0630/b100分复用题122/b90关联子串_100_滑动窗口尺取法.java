package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b90关联子串_100_滑动窗口尺取法
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418046

 * @date: 2023/6/4 9:38
 * @version: V-1.0
 */
public class b90关联子串_100_滑动窗口尺取法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(getResult(str1, str2));
    }

    private static int getResult(String str1, String str2) {
        // count用于统计str1中各字符的数量
        int[] count = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            count[c]++;
        }

        // total统计str1总共字符个数
        int total = str1.length();

        // 初始滑窗，滑窗范围内容，就是一个子串
        for (int i = 0; i < str1.length(); i++) {
            // 滑窗子串新增的字符
            char add = str2.charAt(i);

            // 如果新增字符是str1的字符，即count[add] > 0时，则说明滑窗子串已找到一个目标字符，此时剩余add字符数量count[add]--,剩余目标字符总数total--
            if (count[add]-- > 0) {
                total--;
            }
        }

        // 如果total == 0，则说明滑窗内所有字符都是str1内的字符，由于限定了滑窗的长度就是str1的长度，因此滑窗内字符和str1完全匹配
        if (total == 0) {
            return 0;
        }

        // 下一个滑窗范围是 i ~ i + str1.length() - 1
        for (int i = 1; i + str1.length() - 1 < str2.length(); i++) {
            // 相较于上一个滑窗失去的字符remove
            char remove = str2.charAt(i - 1);
            // 相较于上一个滑窗新增的字符add
            char add = str2.charAt(i + str1.length() - 1);

            // 本轮滑窗remove字符，在上一轮是被add的字符，我们假设此字符为c，此时可以分两种情况讨论：
            // 1、c是str1的字符，则初始统计时count[c]>0，上一轮滑窗加入c字符，则count[c]--，此轮count[c]是有可能>=0或者<0的，
            //    1.1、如果本轮count[c]>=0，则说明上轮滑窗并没有找到所有的c字符，因此本轮移除的c字符可以还原total数量
            //
            // 1.2、如果本轮count[c]<0，这说明上轮滑窗内的c字符超标了，即c字符是目标字符，但是滑窗内包含的c字符数量超过了str1中c字符的数量，因此本轮移除c字符是超标部分，不会还原total
            // 2、c不是str1的字符，则初始统计时count[c]==0，上一轮滑窗加入c字符，则count[c]--，此轮必然count[c]<0，因此c字符的移除，并不会还原total
            if (count[remove]++ >= 0) {
                total++;
            }

            if (count[add]-- > 0) {
                total--;
            }

            if (total == 0) {
                return i;
            }
        }

        return -1;
    }
}
