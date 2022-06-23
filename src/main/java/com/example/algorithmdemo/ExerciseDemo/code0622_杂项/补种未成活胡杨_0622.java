package com.example.algorithmdemo.ExerciseDemo.code0622_杂项;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 补种未成活胡杨_0622
 * @desc: 补种未成活胡杨
 * https://www.peiluming.com/article/90
标题：补种未成活胡杨 | 时间限制：1秒 | 内存限制：262144K
近些年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨（编号1-N），排成一排。一个月后，有M棵胡杨未能成活。
现可补种胡杨K棵，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？
输入描述:
N 总种植数量 1<=N<=100000 M 未成活胡杨数量 1<=M<=N M 个空格分隔的数，按编号从小到大排列 K 最多可以补种的数量 0<=K<=M
输出描述:
最多的连续胡杨棵树
示例1
输入
5
2
2 4
1
输出
3
说明
补种到2或4结果一样，最多的连续胡杨棵树都是3
示例2
输入
10
3
2 4 7
1
输出
6
说明
补种第7棵树，最多的连续胡杨棵树为6(5,6,7,8,9,10)
 * @date: 2022/6/21 11:13 下午
 * @version: V-1.0
 */
public class 补种未成活胡杨_0622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer> deadHuYangList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            deadHuYangList.add(sc.nextInt());
        }
        int K = sc.nextInt();
        getMostContinuousHuYang(N, M, deadHuYangList, K);
    }

    private static void getMostContinuousHuYang(int N, int M, List<Integer> deadHuYangList, int K) {
        //只有补种的K棵树连续才能获取最长的连续树，滑动窗口，大小为K的窗口在M的区间内滑动
        int maxCount = 0;
        for (int i = 0; i + K - 1 <= M - 1 ; i++) {
            //当i=0，左边界下标取0
            int left = 0;
            //当i+K-1 = M-1，右边界下标取N-1
            int right = N - 1;
            //当i>0,左边界取
            if (i > 0) {
                left = deadHuYangList.get(i - 1);
            }
            //i+K-1小于M-1，右边界下标取补种的最后一个胡杨后面一个空胡杨的前面一个树编号减一
            if (i + K - 1 < M -1) {
                right = deadHuYangList.get(i + K - 1 + 1) - 1 - 1;
            }
            int count = right - left + 1;
            maxCount = Math.max(count,maxCount);
        }
        System.out.println(maxCount);
    }
}
