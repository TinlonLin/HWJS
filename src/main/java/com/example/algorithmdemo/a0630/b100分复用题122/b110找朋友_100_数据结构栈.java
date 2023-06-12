package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b110找朋友_100_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127342018

 * @date: 2023/6/4 9:46
 * @version: V-1.0
 */
public class b110找朋友_100_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(getResult(arr));
    }

    private static String getResult(int[] arr) {
        LinkedList<int[]> stack = new LinkedList<>();

        int len = arr.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int ele = arr[i];

            while (true) {
                if (stack.size() == 0) {
                    stack.add(new int[] {ele, i});
                    break;
                }

                int[] peek = stack.getLast();
                int peekEle = peek[0];
                int peekIndex = peek[1];

                if (ele > peekEle) {
                    res[peekIndex] = i;
                    stack.removeLast();
                } else {
                    stack.add(new int[] {ele, i});
                    break;
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int v : res) {
            sj.add(v + "");
        }

        return sj.toString();
    }
}
