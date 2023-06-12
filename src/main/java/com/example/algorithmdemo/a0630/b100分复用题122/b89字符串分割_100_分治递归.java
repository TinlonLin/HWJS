package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b89字符串分割_100_分治递归
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127581070

 * @date: 2023/6/4 9:38
 * @version: V-1.0
 */
public class b89字符串分割_100_分治递归 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    private static int getResult(String s) {
        // 将字符串转化为ASCII数组
        char[] cArr = s.toCharArray();

        int n = cArr.length;

        // 前缀和，实现O(1)时间求解某区间内元素之和
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + cArr[i - 1];

        // res记录成功分割的情况
        ArrayList<Integer> res = new ArrayList<>();
        // 递归
        recursive(preSum, n, 0, 0, res);

        if (res.size() == 0) {
            return 0;
        } else if (res.size() == 1) {
            return res.get(0);
        } else {
            return -1;
        }
    }

    private static void recursive(int[] preSum, int n, int start, int count, ArrayList<Integer> res) {
        if (start == n) {
            res.add(count);
            return;
        }

        for (int end = start + 1; end <= n; end++) {
            // 基于前缀和快速求解任意区间内的元素和
            if (isSxh(preSum[end] - preSum[start])) {
                recursive(preSum, n, end, count + 1, res);
            }
        }
    }

    // 判断num是否为水仙花数
    private static boolean isSxh(int num) {
        if (num <= 99 || num >= 1000) {
            return false;
        }

        String[] tmp = (num + "").split("");

        int x = Integer.parseInt(tmp[0]);
        int y = Integer.parseInt(tmp[1]);
        int z = Integer.parseInt(tmp[2]);

        return num == x * x * x + y * y * y + z * z * z;
    }
}
