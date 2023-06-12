package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b66寻找身高相近的小朋友_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418185

 * @date: 2023/6/4 9:26
 * @version: V-1.0
 */
public class b66寻找身高相近的小朋友_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int n = sc.nextInt();

        Integer[] heights = new Integer[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println(getResult(h, heights));
    }

    private static String getResult(int h, Integer[] heights) {
        Arrays.sort(
                heights,
                (a, b) -> {
                    int absA = Math.abs(a - h);
                    int abaB = Math.abs(b - h);

                    if (absA != abaB) {
                        return absA - abaB;
                    } else {
                        return a - b;
                    }
                });

        StringJoiner sj = new StringJoiner(" ");
        for (Integer height : heights) {
            sj.add(height + "");
        }
        return sj.toString();
    }
}
