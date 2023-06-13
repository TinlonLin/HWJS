package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b56二叉树中序遍历_200_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128192379

 * @date: 2023/6/4 10:14
 * @version: V-1.0
 */
public class b56二叉树中序遍历_200_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(getResult(sc.next()));
    }

    public static String getResult(String str) {
        LinkedList<Integer> idxs = new LinkedList<>();
        LinkedList<String> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '}') {
                // 如果遇到}，则需要将它和最近的一个{匹配，而最近的{的索引就是idxs的栈顶值
                // 左括号在栈中的索引位置idx
                int idx = idxs.removeLast();

                // 将{、}之间的子树内容提取出来，即从{索引+1开始提取，一直到stack栈顶
                String subTree = removeStackEles(stack, idx + 1);

                // 此时stack栈顶元素是{，我们需要去除它
                stack.removeLast();

                // 此时stack栈顶元素是子树根
                String root = stack.removeLast();

                // 将子树内容按照逗号切割，左边的是左子树，右边的是右子树
                String[] split = subTree.split(",");
                String left = split[0];
                // 如果没有逗号，则没有右子树
                String right = split.length > 1 ? split[1] : "";

                // 按照中序遍历顺序，合成:左根右
                stack.addLast(left + root + right);
                continue;
            }

            if (c == '{') {
                idxs.addLast(stack.size());
            }

            stack.addLast(c + "");
        }

        return stack.get(0);
    }

    // 将栈stack，从start索引开始删除，一直删到栈顶，被删除元素组合为一个字符串返回
    private static String removeStackEles(LinkedList<String> stack, int start) {
        StringBuilder sb = new StringBuilder();
        while (start < stack.size()) {
            sb.append(stack.remove(start));
        }
        return sb.toString();
    }
}
