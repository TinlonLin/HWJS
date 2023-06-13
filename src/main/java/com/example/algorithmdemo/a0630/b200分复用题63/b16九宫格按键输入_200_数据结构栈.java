package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b16九宫格按键输入_200_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127710966

 * @date: 2023/6/4 9:57
 * @version: V-1.0
 */
public class b16九宫格按键输入_200_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    static String[] dict = {" ", ",.", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static LinkedList<Character> stack = new LinkedList<>();
    static int topRepeat = 0;
    static boolean isEng = false;

    public static String getResult(String s) {
        s += " ";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '#':
                    // 如果输入”/”或者其他字符，则循环中断
                    interrupt();
                    // #用于切换模式
                    isEng = !isEng;
                    break;
                case '/':
                    // 如果输入”/”或者其他字符，则循环中断
                    interrupt();
                    break;
                default:
                    // 数字模式直接输出数字
                    if (!isEng) {
                        stack.add(c);
                        break;
                    }

                    // 英文模式下，如果栈为空，则缓存对应字符c，并记录重复次数
                    if (stack.size() == 0) {
                        stack.add(c);
                        topRepeat++;
                        break;
                    }

                    // 英文模式下，如果栈不为空
                    if (c != stack.getLast()) {
                        // 如果输入”/”或者其他字符，则循环中断
                        interrupt();
                        stack.add(c);
                    }
                    topRepeat++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size() - 1; i++) sb.append(stack.get(i));
        return sb.toString();
    }

    // 英文模式连续按同一个按键会依次出现这个按键上的字母，如果输入”/”或者其他字符，则循环中断
    // interrupt用于处理循环中断后的逻辑
    public static void interrupt() {
        if (!isEng || stack.size() == 0 || topRepeat == 0) return;
        stack.add(map(stack.removeLast(), topRepeat));
        topRepeat = 0;
    }

    // 基于dict，获取一个数字c被重复repeat次后，对应的字符
    public static char map(char c, int repeat) {
        int num = Integer.parseInt(c + "");
        String s = dict[num];
        int i = (repeat - 1) % s.length();
        return s.charAt(i);
    }
}
