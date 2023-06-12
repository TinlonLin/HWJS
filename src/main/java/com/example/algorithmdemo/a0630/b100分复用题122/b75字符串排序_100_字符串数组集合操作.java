package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b75字符串排序_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128008582

 * @date: 2023/6/4 9:30
 * @version: V-1.0
 */
public class b75字符串排序_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        System.out.println(getResult(arr));
    }

    private static String getResult(String[] arr) {
        Arrays.sort(arr, (a, b) -> a.toLowerCase().compareTo(b.toLowerCase()));

        LinkedList<String> stack = new LinkedList<>();
        stack.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            String s = arr[i];
            String top = stack.getLast().toLowerCase();
            String add = s.toLowerCase();
            if (top.equals(add)) {
                continue;
            }
            stack.add(s);
        }

        StringJoiner sj = new StringJoiner(" ");
        for (String s : stack) {
            sj.add(s);
        }
        return sj.toString();
    }
}
