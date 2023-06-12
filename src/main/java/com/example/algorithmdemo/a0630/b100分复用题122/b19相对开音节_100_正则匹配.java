package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b19相对开音节_100_正则匹配
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127202697

 * @date: 2023/6/4 8:53
 * @version: V-1.0
 */
public class b19相对开音节_100_正则匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        System.out.println(getResult(words));
    }

    private static int getResult(String[] words) {
        int count = 0;

        Pattern nonLetter = Pattern.compile("[^a-z]");
        Pattern reg1 = Pattern.compile("[^aeiou][aeiou][^aeiour]e");
        Pattern reg2 = Pattern.compile("e[^aeiour][aeiou][^aeiou]");

        for (String word : words) {
            Pattern reg = nonLetter.matcher(word).find() ? reg1 : reg2;

            for (int i = 0; i <= word.length() - 4; i++) {
                if (reg.matcher(word.substring(i, i + 4)).find()) count++;
            }
        }

        return count;
    }
}
