package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b18仿LISP运算_200_数据结构栈
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127710596

 * @date: 2023/6/4 9:58
 * @version: V-1.0
 */
public class b18仿LISP运算_200_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static String getResult(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Integer> leftIdx = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                List<Character> fragment = stack.subList(leftIdx.removeLast(), stack.size());

                StringBuilder sb = new StringBuilder();
                for (int j = 1; j < fragment.size(); j++) {
                    sb.append(fragment.get(j));
                }

                fragment.clear();

                String[] tmp = sb.toString().split(" ");

                String op = tmp[0];
                int p1 = Integer.parseInt(tmp[1]);
                int p2 = Integer.parseInt(tmp[2]);

                String res = operate(op, p1, p2);
                if ("error".equals(res)) {
                    return "error";
                } else {
                    for (int k = 0; k < res.length(); k++) {
                        stack.add(res.charAt(k));
                    }
                }
            } else if (c == '(') {
                leftIdx.add(stack.size());
                stack.add(c);
            } else {
                stack.add(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Character c : stack) ans.append(c);
        return ans.toString();
    }

    public static String operate(String op, int p1, int p2) {
        switch (op) {
            case "add":
                return p1 + p2 + "";
            case "sub":
                return p1 - p2 + "";
            case "mul":
                return p1 * p2 + "";
            case "div":
                return p2 == 0 ? "error" : (int) Math.floor(p1 / (p2 + 0.0)) + "";
            default:
                return "error";
        }
    }
}
