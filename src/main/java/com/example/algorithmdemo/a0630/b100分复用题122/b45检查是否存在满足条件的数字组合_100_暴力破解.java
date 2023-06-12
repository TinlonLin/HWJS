package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b45检查是否存在满足条件的数字组合_100_暴力破解
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417998

 * @date: 2023/6/4 9:05
 * @version: V-1.0
 */
public class b45检查是否存在满足条件的数字组合_100_暴力破解 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(n, arr));
    }

    private static String getResult(int n, Integer[] arr) {
        Arrays.sort(arr, (a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] == arr[j] + 2 * arr[k]) {
                        return arr[i] + " " + arr[j] + " " + arr[k];
                    }
                    if (arr[i] == arr[k] + 2 * arr[j]) {
                        return arr[i] + " " + arr[k] + " " + arr[k];
                    }
                }
            }
        }

        return "0";
    }
}
