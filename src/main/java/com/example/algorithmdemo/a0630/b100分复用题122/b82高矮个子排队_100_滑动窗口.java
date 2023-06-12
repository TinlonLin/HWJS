package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b82高矮个子排队_100_滑动窗口
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128010007

 * @date: 2023/6/4 9:35
 * @version: V-1.0
 */
public class b82高矮个子排队_100_滑动窗口 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Integer[] arr =
                    Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            System.out.println(getResult(arr));
        } catch (Exception e) {
            System.out.println("[]");
        }
    }

    private static String getResult(Integer[] arr) {
        // i高->i+1矮 为true，i矮->i+1高 为false
        boolean flag = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1] && (arr[i] > arr[i + 1]) != flag) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }

            flag = !flag;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (Integer h : arr) {
            sj.add(h + "");
        }
        return sj.toString();
    }
}
