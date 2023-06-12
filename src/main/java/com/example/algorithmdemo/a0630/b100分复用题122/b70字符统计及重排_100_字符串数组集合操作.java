package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b70字符统计及重排_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418440

 * @date: 2023/6/4 9:28
 * @version: V-1.0
 */
public class b70字符统计及重排_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getResult(s));
    }

    private static String getResult(String s) {
        HashMap<Character, Integer> letter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letter.put(c, letter.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        letter.entrySet().stream()
                .sorted(
                        (a, b) -> {
                            if (a.getValue() - b.getValue() != 0) {
                                return b.getValue() - a.getValue();
                            } else {
                                if ((isLower(a.getKey()) && isLower(b.getKey()))
                                        || (isUpper(a.getKey()) && isUpper(b.getKey()))) {
                                    return a.getKey() - b.getKey();
                                } else {
                                    if (isUpper(a.getKey())) return 1;
                                    else return -1;
                                }
                            }
                        })
                .forEach(entry -> sb.append(entry.getKey() + ":" + entry.getValue() + ";"));

        return sb.toString();
    }

    private static boolean isLower(char letter) {
        return letter >= 'a' && letter <= 'z';
    }

    private static boolean isUpper(char letter) {
        return letter >= 'A' && letter <= 'Z';
    }
}
