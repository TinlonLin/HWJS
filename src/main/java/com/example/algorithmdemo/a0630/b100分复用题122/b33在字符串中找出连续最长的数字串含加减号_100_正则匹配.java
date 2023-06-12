package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b33在字符串中找出连续最长的数字串含加减号_100_正则匹配
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127968197

 * @date: 2023/6/4 8:59
 * @version: V-1.0
 */
public class b33在字符串中找出连续最长的数字串含加减号_100_正则匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(getResult(s));
    }

    private static String getResult(String s) {
        Matcher matcher = Pattern.compile("([+-]?\\d+\\.?\\d+)").matcher(s);

        String ans = "";
        int maxLen = 0;

        while (matcher.find()) {
            String tmp = matcher.group();
            if (tmp.length() >= maxLen) {
                maxLen = tmp.length();
                ans = tmp;
            }
        }

        return ans;
    }
}
