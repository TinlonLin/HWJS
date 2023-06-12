package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b53勾股元数组_100_数学问题
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128028904

 * @date: 2023/6/4 9:08
 * @version: V-1.0
 */
public class b53勾股元数组_100_数学问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        getResult(n, m);
    }

    private static void getResult(int n, int m) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = n; i <= m; i++) {
            arr.add(i * i);
        }

        HashSet<Integer> set = new HashSet<>(arr);
        ArrayList<Integer[]> res = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                // 判断勾股数 a^2 + b^2 = c^2
                int sum = arr.get(i) + arr.get(j);
                if (set.contains(sum)) {
                    res.add(
                            new Integer[] {
                                    (int) Math.sqrt(arr.get(i)), (int) Math.sqrt(arr.get(j)), (int) Math.sqrt(sum)
                            });
                }
            }
        }

        List<Integer[]> collect =
                res.stream()
                        .filter(
                                g ->
                                        isRelativePrime(g[0], g[1])
                                                || isRelativePrime(g[0], g[2])
                                                || isRelativePrime(g[1], g[2]))
                        .collect(Collectors.toList());

        if (collect.size() == 0) {
            System.out.println("NA");
        } else {
            for (Integer[] g : collect) {
                System.out.println(g[0] + " " + g[1] + " " + g[2]);
            }
        }
    }

    // 判断两个数是否互质，辗转相除
    private static boolean isRelativePrime(int x, int y) {
        while (y > 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }

        return x == 1;
    }
}
