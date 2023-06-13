package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b27分积木_200_位运算
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711241

 * @date: 2023/6/4 10:01
 * @version: V-1.0
 */
public class b27分积木_200_位运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println(getResult(n, weights));
    }

    public static String getResult(int n, int[] weights) {
        // 升序
        Arrays.sort(weights);

        int min = weights[0];

        // correctSum记录Solo计算的正确的总重量
        int correctSum = min;
        // faultSum记录Koko计算的错误的总重量
        int faultSum = min;

        for (int i = 1; i < weights.length; i++) {
            correctSum += weights[i];
            // Koko的计算方法其实就是二进制按位异或运算，即如果两个相应的二进制位值不同则为1，否则为0。
            faultSum ^= weights[i];
        }

        // 如果按照Koko计算方法，若想按重量平分，必然会生成两份相同的二进制数，而两个相同二进制数，按位异或的结果必然是0
        if (faultSum == 0) {
            // faultSum=0表示可以平分，因此任意减去一个重量，都可以得到两个相同的二进制数，因此就减去最小的，这样Solo就可以分得最重的
            return correctSum - min + "";
        } else {
            // faultSum != 0 表示无法按照Koko的逻辑平分
            return "NO";
        }
    }
}
