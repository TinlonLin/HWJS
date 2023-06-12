package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b52数字涂色_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418364

 * @date: 2023/6/4 9:08
 * @version: V-1.0
 */
public class b52数字涂色_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(n, arr));
    }

    private static int getResult(int n, int[] arr) {
        Arrays.sort(arr);

        if (arr[0] == 1) {
            return 1;
        }

        boolean[] color = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (color[i]) continue;

            color[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (!color[j] && arr[j] % arr[i] == 0) {
                    color[j] = true;
                }
            }

            count++;
        }

        return count;
    }
}
