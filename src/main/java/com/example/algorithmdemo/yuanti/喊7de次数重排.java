package com.example.algorithmdemo.yuanti;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 喊7de次数重排
 * @desc: 100%
 * @date: 2022/7/16 11:50 上午
 * @version: V-1.0
 */
public class 喊7de次数重排 {
    /*
        喊7 是一个传统的聚会游戏
        N个人围成一圈
        按顺时针从1-7编号
        编号为1的人从1开始喊数
        下一个人喊得数字是上一个人喊得数字+1
        但是当将要喊出数字7的倍数或者含有7的话
        不能喊出 而是要喊过

        假定N个人都没有失误。
        当喊道数字k时
        可以统计每个人喊 “过"的次数

        现给定一个长度n的数组
        存储打乱的每个人喊”过"的次数
        请把它还原成正确顺序

        即数组的第i个元素存储编号i的人喊“过“的次数

           输入为1行
           空格分割的喊过的次数
           注意k并不提供

           k不超过200
           数字个数为n
           输出描述

           输出为1行
           顺序正确的喊过的次数  空格分割

           例子
           输入
             0 1 0
           输出
             1 0 0

           只有一次过
           发生在7
           按顺序编号1的人遇到7  所以100
           结束时的k不一定是7 也可以是 8 9
             喊过都是100

             例子
           输入
             0 0 0 2 1
           输出
             0 2 0 1 0
           一共三次喊过
           发生在7 14 17
           编号为2 的遇到7 17
           编号为4 的遇到14
         */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        int[] res = new int[split.length];

        int j = 0;
        for (int i = 1; i < 300; i++, j++) {
            if (j == split.length) j = 0;
            if (i % 7 == 0 || (i + "").contains("7")) {
                res[j] += 1;
            }
            int sum1 = 0;
            for (int re : res) sum1 += re;
            if (sum == sum1) break;
        }

        StringBuilder builder = new StringBuilder();
        for (int re : res) {
            builder.append(re).append(" ");
        }

        String s = builder.toString();
        System.out.println(s.substring(0, s.length() - 1));

        in.close();

    }
}
