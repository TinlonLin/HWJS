package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b87补种未成活胡杨_100_滑动窗口
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127333487

 * @date: 2023/6/4 9:37
 * @version: V-1.0
 */
public class b87补种未成活胡杨_100_滑动窗口 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 0; i < m; i++) {
            int deadIdx = sc.nextInt() - 1;
            arr[deadIdx] = 0;
        }

        int k = sc.nextInt();

        System.out.println(getResult(arr, k));
    }

    private static int getResult(int[] arr, int k) {
        int left = 0;
        LinkedList<Integer> occur = new LinkedList<>();
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                occur.addLast(right);

                if (occur.size() > k) {
                    maxLen = Math.max(maxLen, right - left);
                    left = occur.removeFirst() + 1;
                    continue;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
