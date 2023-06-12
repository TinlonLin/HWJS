package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b39最长连续子序列_100_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127968710

 * @date: 2023/6/4 9:02
 * @version: V-1.0
 */
public class b39最长连续子序列_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int sum = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(arr, sum));
    }

    private static int getResult(Integer[] arr, int sum) {
        int ans = -1;
        if (sum <= 0) {
            return ans;
        }

        int l = 0;
        int r = 0;
        int n = arr.length;

        int total = arr[l];
        while (true) {
            if (total > sum) {
                l++;
                total -= arr[l - 1];
                if (l < n && r < l) {
                    r = l;
                    total += arr[r];
                }
            } else if (total < sum) {
                r++;
                if (r < n) {
                    total += arr[r];
                } else {
                    break;
                }
            } else {
                ans = Math.max(ans, r - l + 1);
                l++;
                r++;
                if (r < n) {
                    total += arr[r] - arr[l - 1];
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}
