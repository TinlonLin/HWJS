package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b36信道分配_200_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127607871

 * @date: 2023/6/4 10:04
 * @version: V-1.0
 */
public class b36信道分配_200_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();

        int[] N = new int[r + 1];
        for (int i = 0; i <= r; i++) {
            N[i] = sc.nextInt();
        }

        int d = sc.nextInt();

        System.out.println(getResult(r, N, d));
    }

    public static int getResult(int r, int[] N, int d) {
        Integer[] D =
                Arrays.stream(new StringBuilder(Integer.toString(d, 2)).reverse().toString().split(""))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);

        int count = 0;

        int Nlen = N.length;
        int Dlen = D.length;

        if (Nlen > Dlen) {
            for (int i = Dlen; i < Nlen; i++) {
                count += N[i];
            }
        }

        while (true) {
            int[] D2 = new int[Dlen];
            for (int i = 0; i < Dlen; i++) {
                D2[i] = D[i];
            }

            for (int i = Dlen - 1; i >= 1; i--) {
                if (N[i] > 0) {
                    int diff = N[i] - D2[i];
                    if (diff >= 0) {
                        N[i] = diff;
                        D2[i] = 0;
                    } else {
                        D2[i] = 0;
                        D2[i - 1] += Math.abs(diff) * 2;
                        N[i] = 0;
                    }
                } else {
                    D2[i - 1] += D2[i] * 2;
                    D2[i] = 0;
                }
            }

            boolean flag = false;
            if (N[0] >= D2[0]) {
                N[0] -= D2[0];
                count++;
            } else {
                N[0] -= D2[0];
                D2[0] = 0;
                for (int i = 0; i < Dlen; i++) {
                    if (N[i] < 0) {
                        if (i != Dlen - 1) {
                            N[i + 1] += N[i] >> 1;
                            N[i] = 0;
                        } else {
                            flag = true;
                        }
                    } else {
                        count++;
                        break;
                    }
                }
            }

            if (flag) {
                break;
            }
        }

        return count;
    }
}
