package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b6字符串分割2_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417881
题目描述：
给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；
反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
输入描述：
输入为两行，第一行为参数K，第二行为字符串S。
输出描述：
输出转换后的字符串。

用例
输入
3
12abc-abCABc-4aB@
输出
12abc-abc-ABC-4aB-@
说明
子串为12abc、abCABc、4aB@，第一个子串保留，
后面的子串每3个字符一组为abC、ABc、4aB、@，
abC中小写字母较多，转换为abc，
ABc中大写字母较多，转换为ABC，
4aB中大小写字母都为1个，不做转换，
@ 中没有字母，连起来即12abc-abc-ABC-4aB-@

输入
12
12abc-abCABc-4aB@
输出
12abc-abCABc4aB@
说明
子串为12abc、abCABc、4aB@，第一个子串保留，
后面的子串每12个字符一组为abCABc4aB@，
这个子串中大小写字母都为4个，不做转换，
连起来即12abc-abCABc4aB@

 * @date: 2023/6/4 8:47
 * @version: V-1.0
 */
public class b6字符串分割2_100_字符串数组集合操作 {
    static int[] fact;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        System.out.println(getResult(k, s));
    }

    private static String getResult(int k, String s) {
        String[] arr = s.split("-");

        // 第一个子串不做处理
        StringJoiner sj = new StringJoiner("-");
        // sj.add(convert(arr[0])); // 看用例说明，对应第一个子串是不需要做大小写转换的，但是也拿不准，考试时可以都试下
        sj.add(arr[0]);

        // 剩余子串重新合并为一个新字符串，每k个字符一组
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String newStr = sb.toString();

        for (int i = 0; i < newStr.length(); i += k) {
            String subStr = newStr.substring(i, Math.min(i + k, newStr.length()));
            // 子串中小写字母居多，则整体转为小写字母，大写字母居多，则整体转为大写字母
            sj.add(convert(subStr));
        }

        return sj.toString();
    }

    private static String convert(String str) {
        int lowerCount = 0;
        int upperCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lowerCount++;
            } else if (c >= 'A' && c <= 'Z') {
                upperCount++;
            }
        }

        if (lowerCount > upperCount) {
            return str.toLowerCase();
        } else if (lowerCount < upperCount) {
            return str.toUpperCase();
        } else {
            return str;
        }
    }
}
