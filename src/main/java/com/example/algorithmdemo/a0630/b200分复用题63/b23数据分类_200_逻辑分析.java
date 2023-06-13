package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b23数据分类_200_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128177849

 * @date: 2023/6/4 10:00
 * @version: V-1.0
 */
public class b23数据分类_200_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = sc.nextInt();

        System.out.println(getResult(c, b, arr));
    }

    // 算法入口
    private static int getResult(int c, int b, int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();

        Arrays.stream(arr)
                .map(
                        a -> {
                            String str = Integer.toHexString(a);

                            if (str.length() % 2 != 0) {
                                str = "0" + str;
                            }

                            int sum = 0;
                            for (int i = 0; i < str.length() - 1; i += 2) {
                                sum += Integer.parseInt(str.substring(i, i + 2), 16);
                            }

                            int t = sum % b;
                            if (t < c) {
                                return t;
                            } else {
                                return -1;
                            }
                        })
                .forEach(
                        t -> {
                            if (t != -1) {
                                count.put(t, count.getOrDefault(t, 0) + 1);
                            }
                        });

        return count.values().stream().max((x, y) -> x - y).orElse(0);
    }
}
