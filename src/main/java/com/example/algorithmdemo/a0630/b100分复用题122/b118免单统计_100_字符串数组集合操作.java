package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b118免单统计_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128058121

 * @date: 2023/6/4 9:49
 * @version: V-1.0
 */
public class b118免单统计_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println(getResult(arr));
    }

    private static int getResult(String[] arr) {
        Arrays.sort(arr);

        LinkedList<String> stack = new LinkedList<>();
        stack.add(arr[0]);

        int i = 1;
        while (i < arr.length) {
            String time = arr[i++];
            String top = stack.getLast();

            if (top.equals(time) || !top.substring(0, 19).equals(time.substring(0, 19))) {
                stack.add(time);
            }
        }

        return stack.size();
    }
}
