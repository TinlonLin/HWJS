package com.example.algorithmdemo.a0630.a200分新加题26;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/12 0:16
 * @ClassName: a22计算五码率_200_逻辑分析
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130774905?spm=1001.2014.3001.5502
题目描述
误码率是最常用的数据通信传输质量指标。它可以理解为“在多少位数据中出现一位差错”。
移动通信网络中的误码率主要是指比特误码率，其计算公式如下: 比特误码率=错误比特数/传输总比特数，
为了简单，我们使用字符串来标识通信的信息，一个字符错误了，就认为出现了一个误码
输入一个标准的字符串，和一个传输后的字符串，
字符串会被压缩， 例:“2A3B4D5X1Z”表示"AABBBDDDDXXXXXZ"
用例会保证两个输入字符串解压后长度一致，解压前的长度不一定一致
每个生成后的字符串长度<100000000。
输入描述
两行，分别为两种字符串的压缩形式。
每行字符串 (压缩后的) 长度<100000
输出描述
一行，错误的字等数量/展开后的总长度
备注
注意：展开后的字符串不含数字

用例
输入
3A3B
2A4B
输出
1/6
说明
无

输入
5Y5Z
5Y5Z
输出
0/10
说明
无

输入
4Y5Z
9Y
输出
5/9
说明
无
 * @Version: V-1.0
 */
public class a22计算五码率_200_逻辑分析 {
    static class ZipStr {
        int num;
        char c;

        public ZipStr(int num, char c) {
            this.num = num;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(getResult(s1, s2));
    }

    public static String getResult(String s1, String s2) {
        LinkedList<ZipStr> link1 = getZipStrLink(s1);
        LinkedList<ZipStr> link2 = getZipStrLink(s2);

        int diff = 0;
        int same = 0;

        while (link1.size() > 0) {
            ZipStr zipStr1 = link1.removeFirst();
            ZipStr zipStr2 = link2.removeFirst();

            int compareCount = Math.min(zipStr1.num, zipStr2.num);

            if (zipStr1.c != zipStr2.c) {
                diff += compareCount;
            } else {
                same += compareCount;
            }

            if (zipStr1.num > compareCount) {
                zipStr1.num -= compareCount;
                link1.addFirst(zipStr1);
                continue;
            }

            if (zipStr2.num > compareCount) {
                zipStr2.num -= compareCount;
                link2.addFirst(zipStr2);
            }
        }

        return diff + "/" + (diff + same);
    }

    public static LinkedList<ZipStr> getZipStrLink(String s) {
        LinkedList<ZipStr> link = new LinkedList<>();

        StringBuilder num = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num.append(c);
            } else {
                link.add(new ZipStr(Integer.parseInt(num.toString()), c));
                num = new StringBuilder();
            }
        }

        return link;
    }
}
