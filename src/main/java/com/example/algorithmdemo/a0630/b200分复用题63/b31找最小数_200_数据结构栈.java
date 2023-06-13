package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b31找最小数_200_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127342038

 * @date: 2023/6/4 10:02
 * @version: V-1.0
 */
public class b31找最小数_200_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        int count = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(num1, count));
    }

    private static String getResult(String num1, int removeCount) {
        if (num1.length() == removeCount) return "0";

        int remainCount = num1.length() - removeCount;

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < num1.length(); i++) {
            while (stack.size() > 0 && removeCount > 0 && stack.getLast() > num1.charAt(i)) {
                stack.removeLast();
                removeCount--;
            }
            stack.add(num1.charAt(i));
        }

        while (stack.size() > remainCount) {
            stack.removeLast();
        }

        while (stack.getFirst() == '0' && stack.size() != 1) {
            stack.removeFirst();
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
