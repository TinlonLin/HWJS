package com.example.algorithmdemo.ExerciseDemo.code0616_贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: ArrayContinuousSum_0616
 * @desc: 数组连续和
 * https://blog.csdn.net/qq_34465338/article/details/125035196
 * 给定一个含有N个正整数的数组，求出有多少个连续区间（包含单个正整数），它们的和大于等于x
 *
 * 输入描述：
 * 第一行两个整数 N x (0<N<=100000 0<= x <=10000000)
 * 第二行有N个正整数（每个正整数小于等于100）
 *
 * 输出描述：
 * 输出一个整数，表示所求的个数
 * 示例1：
 * 输入：
 * 3 7
 * 3 4 7
 * 输出：
 * 4
 * 说明：3+4 4+7 3+4+7 7 这四组数据大于等于7
 * 示例2：
 * 输入：
 * 10 10000000
 * 1 2 3 4 5 6 7 8 9 10
 * 输出：0
 * @date: 2022/6/15 9:43 下午
 * @version: V-1.0
 */
public class 连续数组和_0616 {
    public static void main(String[] args) {
        String N_x = "3 7";
        String numStr = "3 4 7";
        System.out.println("输入：\n"+N_x+"\n"+numStr);
        System.out.println("输出：");
        //4
        getCountsBiggerThanX(N_x, numStr);

        String N_x1 = "10 10000000";
        String numStr1 = "1 2 3 4 5 6 7 8 9 10";
        System.out.println("输入：\n"+N_x1+"\n"+numStr1);
        System.out.println("输出：");
        //0
        getCountsBiggerThanX(N_x1, numStr1);
    }

    private static void getCountsBiggerThanX(String N_x, String numStr) {
        //根据空格拆分为字符串数组
        String[] N_xArr = N_x.split(" ");
        //获取N和x
        int N = Integer.parseInt(N_xArr[0]);
        int x = Integer.parseInt(N_xArr[1]);
        //将N个数拆分出来并存入List中
        List<Integer> numList = new ArrayList<>();
        String[] numArr = numStr.split(" ");
        for (String s : numArr) {
            numList.add(Integer.parseInt(s));
        }

        //大于等于x的连续数组的数量
        int count = 0;
        for (int i = 0; i < N; i++) {
            //连续数组和
            int sum = numList.get(i);
            //如果当前值满足大于等于x，且本数组都是正整数，则从此值后的所有连续数组和都满足条件，
            //总共有N-i个（N-1-i+1=N-i），并终止循环
            if (sum >= x) {
                count += N - i;
                break;
            }
            //下标从i+1开始，计算连续和，只要出现大于等于x的值，则此值及后面的连续数组都满足条件
            for (int j = i+1; j < N; j++) {
                sum += numList.get(j);
                if (sum >= x) {
                    count += N-j;
                    break;
                }
            }
        }
        System.out.println(count);
     }
}
