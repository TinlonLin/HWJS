package com.example.algorithmdemo.ExerciseDemo.code0615_基础前缀和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: MaxSumOfSlideWindow_0615
 * @desc: 滑动窗口最大值
 * https://blog.csdn.net/weixin_44219664/article/details/123884116
 * 示例一
 * 输入
 * 6
 * 12 10 20 30 15 23
 * 3
 * <p>
 * 输出
 * 68
 * @date: 2022/6/15 7:32 上午
 * @version: V-1.0
 */
public class 滑动窗口最大和_0615 {
    public static void main(String[] args) {
        int N = 6;
        String str = "12 10 20 30 15 23";
        int M = 3;
        System.out.println("输入：\n" + N + "\n" + str + "\n" + M);
        System.out.println("输出：");
        getMaxSum(N, str, M);

        int N1 = 3;
        String str1 = "12 10 20";
        int M1 = 3;
        System.out.println("输入：\n" + N1 + "\n" + str1 + "\n" + M1);
        System.out.println("输出：");
        getMaxSum(N1, str1, M1);
    }

    private static void getMaxSum(int N, String str, int M) {
        //将str转为int存入list
        String[] strArr = str.split(" ");
        List<Integer> numList = new ArrayList<>();
        for (String s : strArr) {
            numList.add(Integer.parseInt(s));
        }
        //最大和
        int maxSum = 0;
        //如果<=M,最大和为窗口内的所有值的和
        if (N <= M) {
            for (Integer integer : numList) {
                maxSum += integer;
            }
            System.out.println(maxSum);
            return;
        } else {
            for (int i = 0; i < N - M + 1; i++) {
                int sum = 0;
                //每个窗口内的和
                for (int j = i; j < i + M; j++) {
                    sum += numList.get(j);
                }
                maxSum = Math.max(sum, maxSum);
            }
            System.out.println(maxSum);
        }
    }
}
