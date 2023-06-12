package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b63火星文计算_100_正则匹配
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711533

 * @date: 2023/6/4 9:25
 * @version: V-1.0
 */
public class b63火星文计算_100_正则匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(getResult(str));
    }

    private static Pattern p = Pattern.compile("(\\d+)\\$(\\d+)");
    private static int getResult(String str) {
        while (true) {
            Matcher m = p.matcher(str);
            if (!m.find()) {
                break;
            }

            String subStr = m.group(0);
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            str = str.replace(subStr, 3 * x + y + 2 + "");
        }

        return Arrays.stream(str.split("#"))
                .map(Integer::parseInt)
                .reduce((x, y) -> 2 * x + 3 * y + 4)
                .orElse(0);
    }
}
