package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b58消消乐游戏_100_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127341918

 * @date: 2023/6/4 9:10
 * @version: V-1.0
 */
public class b58消消乐游戏_100_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    private static int getResult(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c < 'A' || c > 'z' || (c > 'Z' && c < 'a')) {
                return 0;
            }

            if (stack.size() > 0 && c == stack.getLast()) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        return stack.size();
    }
}
