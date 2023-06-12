package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b40数组去重和排序_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127204355

 * @date: 2023/6/4 9:03
 * @version: V-1.0
 */
public class b40数组去重和排序_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        System.out.println(getResult(arr));
    }

    private static String getResult(String[] arr) {
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, Integer> first = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            count.put(s, count.getOrDefault(s, 0) + 1);
            first.putIfAbsent(s, i);
        }

        StringJoiner sj = new StringJoiner(",");

        first.keySet().stream()
                .sorted(
                        (a, b) -> {
                            int countA = count.get(a);
                            int countB = count.get(b);

                            if (countA != countB) {
                                return countB - countA;
                            } else {
                                int firstA = first.get(a);
                                int firstB = first.get(b);
                                return firstA - firstB;
                            }
                        })
                .forEach(s -> sj.add(s));

        return sj.toString();
    }
}
