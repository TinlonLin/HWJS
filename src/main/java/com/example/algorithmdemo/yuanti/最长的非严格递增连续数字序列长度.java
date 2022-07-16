package com.example.algorithmdemo.yuanti;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 最长的非严格递增连续数字序列长度
 * @desc: 100%
 * @date: 2022/7/16 10:53 上午
 * @version: V-1.0
 */
public class 最长的非严格递增连续数字序列长度 {
    /*
            输入一个字符串仅包含大小写字母和数字
            求字符串中包含的最长的非严格递增连续数字序列长度
            比如：
                12234属于非严格递增数字序列
            示例：
            输入
                abc2234019A334bc
            输出
                4
            说明：
                2234为最长的非严格递增连续数字序列，所以长度为4

                aaaaaa44ko543j123j7345677781
                aaaaa34567778a44ko543j123j71
                345678a44ko543j123j7134567778aa
         */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        char[] chars = line.toCharArray();

        int curLen = 0, maxLen = 0;

        char last = 'a';
        for (char cur : chars) {
            if (Character.isDigit(cur)) {
                if (curLen == 0) {
                    curLen++;
                } else if (cur >= last) {
                    curLen++;
                } else {
                    if (curLen > maxLen) {
                        maxLen = curLen;
                    }
                    curLen = 1;
                }
                last = cur;
            } else {
                if (curLen > maxLen) maxLen = curLen;
                curLen = 0;
                last = 'a';
            }
        }

        if (curLen > maxLen) {
            maxLen = curLen;
        }

        System.out.println(maxLen);
    }
}
