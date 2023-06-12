package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b34找终点_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127210960

 * @date: 2023/6/4 9:00
 * @version: V-1.0
 */
public class b34找终点_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    private static int getResult(Integer[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1; i <= arr.length / 2; i++) {
            res.add(loop(arr, i, 2));
        }

        return res.stream().filter(ele -> ele > 0).min((a, b) -> a - b).orElse(-1);
    }

    private static int loop(Integer[] arr, int i, int count) {
        int j = i + arr[i];

        if (j == arr.length - 1) {
            return count;
        } else if (j < arr.length - 1) {
            count++;
            return loop(arr, j, count);
        } else {
            return -1;
        }
    }
}
