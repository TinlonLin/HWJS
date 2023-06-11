package com.example.algorithmdemo.a0630.b100分复用题122;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b4求字符串中所有整数的最小和_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418073
题目描述：
输入字符串s，输出s中包含所有整数的最小和。
说明：
字符串s，只包含 a-z A-Z ± ；
合法的整数包括
1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
2）负整数 负号 – 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
输入描述：
包含数字的字符串
输出描述：
所有整数的最小和

用例
输入
bb1234aa
输出
10

输入
bb12-34aa
输出
-31
说明
1+2+（-34） = -31

 * @date: 2023/6/4 8:46
 * @version: V-1.0
 */
public class b4求字符串中所有整数的最小和_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static String getResult(String s) {
        boolean isNegative = false;
        StringBuilder negative = new StringBuilder();

        //    int ans = 0;
        BigInteger ans = new BigInteger("0");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                if (isNegative) {
                    negative.append(c);
                } else {
                    //ans += Integer.parseInt(c + "");
                    ans = ans.add(new BigInteger(c + ""));
                }
            } else {
                if (isNegative) {
                    //ans -= Integer.parseInt(negative.toString());
                    ans = ans.subtract(new BigInteger(negative.toString()));
                    negative = new StringBuilder();
                }

                isNegative = c == '-';
            }
        }

        if (negative.length() > 0) {
            //ans -= Integer.parseInt(negative.toString());
            ans = ans.subtract(new BigInteger(negative.toString()));
        }

        return ans.toString();
    }
}
