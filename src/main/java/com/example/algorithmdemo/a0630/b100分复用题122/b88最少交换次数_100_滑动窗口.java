package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b88最少交换次数_100_滑动窗口
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418208

 * @date: 2023/6/4 9:38
 * @version: V-1.0
 */
public class b88最少交换次数_100_滑动窗口 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(arr, k));
    }

    private static int getResult(int[] arr, int k) {
        // 统计小于k的数组元素个数
        int count = 0;
        for (int v : arr) if (v < k) count++;

        // 如果只有1个小于k的元素，则不需要交换就能使小于k的元素组合在一起
        if (count == 1) return 0;

        // 先统计起点在0位置（即left=0）的滑动窗口的交换次数，得到一个minSwapCount初始值
        int minSwapCount = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] >= k) minSwapCount++;
        }

        // 然后统计起点（left）在1~arr.length-count位置的滑动窗口的交换次数
        // 可以转化为求解终点（right）在count~arr.length位置的滑动窗口的交换次数
        int tmpSwapCount = minSwapCount;
        for (int j = count; j < arr.length; j++) {
            // 上一轮的left，即滑窗失去的元素的索引
            int preLeft = j - count;
            // j为滑窗新增的元素的索引
            if (arr[preLeft] >= k && arr[j] < k) {
                tmpSwapCount--;
            } else if (arr[preLeft] < k && arr[j] >= k) {
                tmpSwapCount++;
            }
            minSwapCount = Math.min(minSwapCount, tmpSwapCount);
        }

        return minSwapCount;
    }
}
