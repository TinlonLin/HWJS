package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b51靠谱的车_100_位运算
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418150

 * @date: 2023/6/4 9:07
 * @version: V-1.0
 */
public class b51靠谱的车_100_位运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(arr));
    }

    private static int getResult(int[] arr) {
        int correct = 0;

        for (int i = 0; i < arr.length; i++) {
            int fault = arr[i];
            if (fault > 4) {
                fault--;
            }

            for (int j = arr.length - i - 1; j > 0; j--) {
                fault *= 9;
            }

            correct += fault;
        }

        return correct;
    }
}
