package com.example.algorithmdemo.a0630.a100分新加题34;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/11 23:47
 * @ClassName: a33计算最接近的数_100_滑动窗口
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/131174846
题目描述
给定一个数组X和正整数K，请找出使表达式：
X[i] - X[i + 1] -  ... - X[i + K - 1]
结果最接近于数组中位数的下标 i ，如果有多个 i 满足条件，请返回最大的 i.
其中，数组中位数：长度为N的数组，按照元素的值大小升序排列后，下标为 N/2 元素的值
输入描述
无
输出描述
无
备注
数组X的元素均为正整数
X的长度n取值范围：2 ≤ n ≤ 1000
K大于0目小于数组的大小
i 的取值范围: 0 ≤ i < 1000
题目的排序数组X[N]的中位数是X[N/2]

用例
输入
[50,50,2,3],2
输出
1
说明
中位数为50：[50,50,2,3]升序排序后变成[2,3,50,50]，中位数为下标4/2=2的元素50
计算结果为1：X [50,50,2,3]
根据题目计算X[i] - ... - X[i + k - 1]
得出三个数0 (X[0] - X[1] = 50 - 50) 、48 (X[1] - X[2] = 50 - 2) 和 -1 (X[2]-X[3] = 2 - 3) ，
其中48最接近50，因此返回下标1。
 * @Version: V-1.0
 */
public class a33计算最接近的数_100_滑动窗口 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        int i = line.lastIndexOf(",");

        int[] x =
                Arrays.stream(line.substring(1, i - 1).split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(line.substring(i + 1));

        System.out.println(getResult(x, k));
    }

    public static int getResult(int[] x, int k) {
        int n = x.length;

        // x数组的中位数
        int mid = Arrays.stream(x).sorted().toArray()[n / 2];

        // 初始化滑窗0~k-1, window为滑窗内部元素的表达式计算结果
        int window = x[0];
        for (int i = 1; i < k; i++) {
            window -= x[i];
        }

        // window和中位数的差距
        int minDiff = Math.abs(mid - window);
        // window滑窗起始索引
        int idx = 0;

        // 滑窗右移
        for (int i = 1; i <= n - k; i++) {
            // 右移一格后，新滑窗的表达式计算结果
            window += -x[i - 1] + 2 * x[i] - x[i + k - 1];

            // 新滑窗window值和中位数的差距
            int diff = Math.abs(mid - window);

            // 结果最接近于数组中位数的下标 i ，如果有多个 i 满足条件，请返回最大的 i
            if (diff <= minDiff) {
                minDiff = diff;
                idx = i;
            }
        }

        return idx;
    }
}
