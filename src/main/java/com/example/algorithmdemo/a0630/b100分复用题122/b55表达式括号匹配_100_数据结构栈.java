package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b55表达式括号匹配_100_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128000143

 * @date: 2023/6/4 9:09
 * @version: V-1.0
 */
public class b55表达式括号匹配_100_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getResult(s));
    }

    private static int getResult(String s) {
        s = s.replaceAll("[^\\(\\)]", "");

        int count = 0;
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.size() > 0 && c == ')') {
                if (stack.getLast() == '(') {
                    stack.removeLast();
                    count++;
                    continue;
                }
                return -1;
            }

            stack.add(c);
        }

        if (stack.size() > 0) {
            return -1;
        }
        return count;
    }
}
