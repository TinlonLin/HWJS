package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b100太阳能板最大面积_100_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127191651

 * @date: 2023/6/4 9:42
 * @version: V-1.0
 */
public class b100太阳能板最大面积_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] heights = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(heights));
    }

    private static long getResult(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        long maxArea = 0;

        while (l < r) {
            long x = r - l;
            long y = heights[l] < heights[r] ? heights[l++] : heights[r--];
            maxArea = Math.max(maxArea, x * y);
        }

        return maxArea;
    }
}
