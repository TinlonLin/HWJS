package com.example.algorithmdemo.a0630.a200分新加题26;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a1最佳植树距离_200_二分法最小值最大化问题
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130633638
题目描述：
按照环保公司要求，小明需要在沙化严重的地区进行植树防沙工作，初步目标是种植一条直线的树带。
由于有些区域目前不适合种植树木，所以只能在一些可以种植的点来种植树木。
在树苗有限的情况下，要达到最佳效果，就要尽量散开种植，不同树苗之间的最小间距要尽量大。
你一个适合种情树木的点坐标和一个树苗的数量，请帮小明选择一个最佳的最小种植间距。
例如，适合种植树木的位置分别为1,3,5,6,7,10,13 树苗数量是3，种植位置在1,7,13，
树苗之间的间距都是6，均匀分开，就达到了散开种植的目的，最佳的最小种植间距是6
输入描述：
第1行表示适合种树的坐标数量
第2行是适合种树的坐标位置
第3行是树苗的数量
例如：
7
1 5 3 6 10 7 13
3
输出描述：
最佳的最小种植间距
备注
位置范围为1~10000000
种植树苗的数量范围2~10000000
用例确保种桔的树苗数量不会超过有效种桔坐标数量

用例
输入
7
1 5 3 6 10 7 13
3
输出
6

题目解析
本题是LeetCode - 1552 两球之间的磁力_伏城之外的博客-CSDN博客 的换皮题。题解请参考链接博客。
https://fcqian.blog.csdn.net/article/details/130633897

 * @date: 2023/6/4 8:41
 * @version: V-1.0
 */
public class a1最佳植树距离_200_二分法最小值最大化问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(getResult(n, positions, m));
    }

    public static int getResult(int n, int[] positions, int m) {
        Arrays.sort(positions);
        int min = 1, max = positions[n - 1] - positions[0];
        int ans = 0;
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (check(positions, m, mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }

    public static boolean check(int[] positions, int m, int minDis) {
        int count = 1;
        int curPos = positions[0];
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - curPos >= minDis) {
                count++;
                curPos = positions[i];
            }
        }
        return count >= m;
    }
}
