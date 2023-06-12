package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b113最大股票收益_100_贪心思维
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128049942

 * @date: 2023/6/4 9:47
 * @version: V-1.0
 */
public class b113最大股票收益_100_贪心思维 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" "))
                        .map(
                                p -> {
                                    int num = Integer.parseInt(p.substring(0, p.length() - 1));
                                    String unit = p.substring(p.length() - 1);
                                    return "Y".equals(unit) ? num : num * 7;
                                })
                        .toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    private static int getResult(Integer[] arr) {
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            ans += Math.max(0, arr[i] - arr[i - 1]);
        }
        return ans;
    }
}
