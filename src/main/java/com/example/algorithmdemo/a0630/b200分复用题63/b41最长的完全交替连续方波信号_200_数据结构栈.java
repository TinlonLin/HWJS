package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b41最长的完全交替连续方波信号_200_数据结构栈
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127710488

 * @date: 2023/6/4 10:08
 * @version: V-1.0
 */
public class b41最长的完全交替连续方波信号_200_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(getResult(s));
    }

    public static String getResult(String s) {
        Pattern reg = Pattern.compile("^(01)+0$");

        int maxLen = 0;
        String ans = "-1";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0') {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
                    if (reg.matcher(sb.toString()).find() && sb.length() > maxLen) {
                        maxLen = sb.length();
                        ans = sb.toString();
                    }
                    sb = new StringBuilder();
                }
            }

            sb.append(c);
        }

        if (sb.length() > 0) {
            if (reg.matcher(sb.toString()).find() && sb.length() > maxLen) {
                return sb.toString();
            }
        }

        return ans;
    }
}
