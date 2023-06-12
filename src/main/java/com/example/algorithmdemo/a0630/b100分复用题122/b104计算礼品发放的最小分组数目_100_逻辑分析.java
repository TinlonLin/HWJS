package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b104计算礼品发放的最小分组数目_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128028841

 * @date: 2023/6/4 9:44
 * @version: V-1.0
 */
public class b104计算礼品发放的最小分组数目_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.parseInt(sc.nextLine());
        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(max, arr));
    }

    private static int getResult(int max, Integer[] arr) {
        // 将商品按价格从小到大排序
        Arrays.sort(arr);

        int count = 0;
        // l指针指向最小价格的商品
        int l = 0;
        // r指针指向最大价格的商品
        int r = arr.length - 1;

        // 如果商品价格不超过上限，则优先最小价格和最大价格组合
        while (l < r) {
            int sum = arr[l] + arr[r];

            // 如果最小价格+最大价格 不超过上限，则组合，否则最大价格独立一组
            if (sum <= max) l++;
            r--;
            count++;
        }

        if (l == r) {
            count++;
        }

        return count;
    }
}
