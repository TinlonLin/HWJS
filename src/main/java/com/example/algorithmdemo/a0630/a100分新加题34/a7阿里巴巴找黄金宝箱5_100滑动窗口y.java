package com.example.algorithmdemo.a0630.a100分新加题34;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a7阿里巴巴找黄金宝箱5_100滑动窗口
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130764526
题目描述
一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，
藏宝地有编号从0~N的箱子，每个箱子上面贴有一个数字。
阿里巴巴念出一个咒语数字k(k<N)，找出连续k个宝箱数字和的最大值，并输出该最大值。
输入描述
第一行输入一个数字字串，数字之间使用逗号分隔，例如：2,10,-3,-8,40,5
1 ≤ 字串中数字的个数 ≤ 100000
-10000 ≤ 每个数字 ≤ 10000
第二行输入咒语数字，例如：4，咒语数字大小小于宝箱的个数
输出描述
连续k个宝箱数字和的最大值，例如：39

用例
输入
2,10,-3,-8,40,5
4
输出
39

输入
8
1
输出
8

思路：
我们只需要花费O(k)的时间求解出初始滑动窗口的数字和，
之后每右移一个后的新状态滑窗的数字和都可以依赖于前一个滑窗的数字和求得
 * @date: 2023/6/4 8:28
 * @version: V-1.0
 */
public class a7阿里巴巴找黄金宝箱5_100滑动窗口y {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(",");
        int[] boxNum = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            boxNum[i] = Integer.parseInt(tmp[i]);
        }
        int k = Integer.parseInt(sc.nextLine());
        getKMaxSum(boxNum, k);
    }

    public static void getKMaxSum(int[] boxNum, int k) {
        int window_sum = 0;
        for (int i = 0; i < k; i++) {
            window_sum += boxNum[i];
        }

        int kMaxSum = window_sum;
        for (int i = 1; i <= boxNum.length - k; i++) {
            window_sum -= boxNum[i - 1];
            window_sum += boxNum[i + k - 1];
            kMaxSum = Math.max(kMaxSum, window_sum);
        }
        System.out.println(kMaxSum);
    }
}
