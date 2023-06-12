package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b60最大花费金额_100_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128000793

 * @date: 2023/6/4 9:11
 * @version: V-1.0
 */
public class b60最大花费金额_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arrM =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int r = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(arrM, r));
    }

    private static int getResult(Integer[] arr, int target) {
        // 题目说小明要购买三件，如果商品不足三件直接返回-1
        if (arr.length < 3) return -1;

        // 数组升序
        Arrays.sort(arr);

        int ans = -1;

        for (int i = 0; i < arr.length; i++) {
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    ans = Math.max(ans, sum);
                    l++;
                } else {
                    r--;
                }
            }
        }

        return ans;
    }
}
