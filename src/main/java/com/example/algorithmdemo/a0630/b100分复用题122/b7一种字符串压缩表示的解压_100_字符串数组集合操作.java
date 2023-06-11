package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b7一种字符串压缩表示的解压_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418256
题目描述:
有一种简易压缩算法：针对全部由小写英文字母组成的字符串，将其中连续超过两个相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。
例如：字符串“aaabbccccd”经过压缩成为字符串“3abb4cd”。
请您编写解压函数，根据输入的字符串，判断其是否为合法压缩过的字符串，
若输入合法则输出解压缩后的字符串，否则输出字符串“!error”来报告错误。
输入描述:
输入一行，为一个ASCII字符串，长度不会超过100字符，用例保证输出的字符串长度也不会超过100字符。
输出描述:
若判断输入为合法的经过压缩后的字符串，则输出压缩前的字符串；
若输入不合法，则输出字符串“!error”。

用例
输入
4dff
输出
ddddff
说明
4d扩展为dddd，故解压后的字符串为ddddff。

输入
2dff
输出
!error
说明
两个d不需要压缩，故输入不合法。

输入
4d@A
输出
!error
说明
全部由小写英文字母组成的字符串压缩后不会出现特殊字符@和大写字母A，故输入不合法。

 * @date: 2023/6/4 8:48
 * @version: V-1.0
 */
public class b7一种字符串压缩表示的解压_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.next()));
    }

    public static String getResult(String str) {
        String back_str = str;

        // 压缩字符串str只能包含小写字母和数字 ，如果包含其他字符则非法
        if (!str.matches("[a-z0-9]+")) {
            return "!error";
        }

        // 该正则用于匹配 “4a”，“12b” 这种 “数字+小写字母” 的子串
        Pattern p = Pattern.compile("(\\d+)([a-z])?");

        while (true) {
            Matcher m = p.matcher(str);

            if (!m.find()) {
                break;
            }

            // 要被替换的压缩子串
            String src = m.group();

            int repeat_times = Integer.parseInt(m.group(1));
            // 连续超过两个相同字母的部分压缩为连续个数加该字母，因此不可能出现0，1，2的情况
            if (repeat_times < 3) {
                return "!error";
            }

            String repeat_content = m.group(2);
            // a4这种情况视为异常
            if (repeat_content == null) {
                return "!error";
            }

            // 替换后的解压子串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < repeat_times; i++) {
                sb.append(repeat_content);
            }

            str = str.replace(src, sb.toString());
        }

        // 如果解压字符串重新压缩后，和输入的压缩子串不一样，则说明输入的压缩字符串不合法，比如输入为3bb，bbb, 3b4b都是不合法
        if (!zip(str).equals(back_str)) {
            return "!error";
        }

        return str;
    }

    public static String zip(String str) {
        str += "-";

        StringBuilder ans = new StringBuilder();

        LinkedList<Character> stack = new LinkedList<>();
        int repeat = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.size() == 0) {
                stack.add(c);
                repeat++;
                continue;
            }

            // stack.size() > 0
            char top = stack.getLast();

            if (top == c) {
                repeat++;
                continue;
            }

            // top != c
            if (repeat > 2) {
                ans.append(repeat).append(top);
            } else {
                char[] tmp = new char[repeat];
                Arrays.fill(tmp, top);
                ans.append(new String(tmp));
            }
            stack.clear();
            stack.add(c);
            repeat = 1;
        }

        return ans.toString();
    }
}
