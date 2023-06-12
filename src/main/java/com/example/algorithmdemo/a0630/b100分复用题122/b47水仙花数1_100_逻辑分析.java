package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b47水仙花数1_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127974326

 * @date: 2023/6/4 9:06
 * @version: V-1.0
 */
public class b47水仙花数1_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getResult(n, m));
    }

    private static int getResult(int n, int m) {
        if (n < 3 || n > 7) {
            return -1;
        }

        HashMap<Integer, Integer> powN = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            powN.put(i, (int) Math.pow(i, n));
        }

        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n);

        int ans = -1;
        int count = -1;

        for (int i = min; i < max; i++) {
            Integer sum =
                    Arrays.stream((i + "").split(""))
                            .map(e -> powN.get(Integer.parseInt(e)))
                            .reduce(Integer::sum)
                            .orElse(0);

            if (sum == i) {
                ans = i;
                count++;
                if (count == m) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
