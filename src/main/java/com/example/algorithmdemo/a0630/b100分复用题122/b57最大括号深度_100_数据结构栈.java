package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b57最大括号深度_100_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128019710

 * @date: 2023/6/4 9:10
 * @version: V-1.0
 */
public class b57最大括号深度_100_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getResult(s));
    }

    private static int getResult(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        LinkedList<Character> stack = new LinkedList<>();

        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.size() > 0 && map.get(c) == stack.getLast()) {
                stack.removeLast();
            } else {
                stack.add(c);
                maxDepth = Math.max(maxDepth, stack.size());
            }
        }

        if (stack.size() > 0) {
            return 0;
        }
        return maxDepth;
    }
}
