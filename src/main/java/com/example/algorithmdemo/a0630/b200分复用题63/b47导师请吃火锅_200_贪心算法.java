package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b47导师请吃火锅_200_贪心算法
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127694369

 * @date: 2023/6/4 10:11
 * @version: V-1.0
 */
public class b47导师请吃火锅_200_贪心算法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] suit = new int[n];
        for (int i = 0; i < n; i++) {
            suit[i] = sc.nextInt() + sc.nextInt();
        }

        System.out.println(getResult(n, m, suit));
    }

    private static int getResult(int n, int m, int[] suit) {
        Arrays.sort(suit);
        // 第1个合适的菜必吃
        int count = 1;
        int pre = 0;
        for (int i = 1; i < suit.length; i++) {
            if (suit[i] >= suit[pre] + m) {
                // 如果想要捞本次合适的菜，则必须要与上次捞菜的时间差大于等于m，注意这里是suit[pre] + m ，而不是suit[i-1] + m
                count++;
                // 如果本次捞了菜，则更新缓存本次捞菜的时间点
                pre = i;
            }
        }
        return count;
    }
}
