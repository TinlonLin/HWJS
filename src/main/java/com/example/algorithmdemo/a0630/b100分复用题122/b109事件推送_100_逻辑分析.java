package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b109事件推送_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417825

 * @date: 2023/6/4 9:46
 * @version: V-1.0
 */
public class b109事件推送_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] tmp =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int m = tmp[0];
        int n = tmp[1];
        int r = tmp[2];

        Integer[] a =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Integer[] b =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        getResult(r, a, b);
    }

    private static void getResult(int r, Integer[] a, Integer[] b) {
        for (int ai : a) {
            int j = Arrays.binarySearch(b, ai);

            // 如果在b数组中可以找到ai，则此时j就是ai在b数组中的位置，此时ai和bj是满足要求，且最接近的
            if (j >= 0) {
                System.out.println(ai + " " + b[j]);
            } else {
                // 如果在b数组中找不到ai，则此时j就是ai在b数组中有序插入位置-insertIdx-1，
                // 因此insertIdx = -j-1，此时b[insertIdx]满足大于ai，我们只需要检查b[insertIdx] - ai<=r即可
                int insertIdx = -j - 1;
                if (b[insertIdx] - ai <= r) {
                    System.out.println(ai + " " + b[insertIdx]);
                }
            }
        }
    }
}
