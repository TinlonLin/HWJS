package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b56括号匹配_100_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128000554

 * @date: 2023/6/4 9:09
 * @version: V-1.0
 */
public class b56括号匹配_100_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(getResult(s));
    }

    // 算法入口
    private static boolean getResult(String s) {
        // 去除非括号字符
        s = s.replaceAll("[^\\(\\)\\[\\]\\{\\}]", "");

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.size() > 0 && map.containsKey(c)) {
                if (stack.getLast() == map.get(c)) {
                    stack.removeLast();
                    continue;
                } else {
                    return false;
                }
            }

            stack.add(c);
        }

        return stack.size() == 0;
    }
}
