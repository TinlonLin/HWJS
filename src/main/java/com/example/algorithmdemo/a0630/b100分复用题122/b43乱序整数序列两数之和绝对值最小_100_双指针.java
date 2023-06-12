package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b43乱序整数序列两数之和绝对值最小_100_双指针
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127418103

 * @date: 2023/6/4 9:04
 * @version: V-1.0
 */
public class b43乱序整数序列两数之和绝对值最小_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(nums));
    }

    private static String getResult(int[] nums) {
        int min = Integer.MAX_VALUE;
        String ans = "";

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = Math.abs(nums[i] + nums[j]);
                if (min > sum) {
                    min = sum;
                    ans = (nums[i] < nums[j] ? nums[i] + " " + nums[j] : nums[j] + " " + nums[i]) + " " + sum;
                }
            }
        }

        return ans;
    }
}
