package com.example.algorithmdemo.a0630.a100分新加题27;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a6阿里巴巴找黄金宝箱1_100_单指针
 * @desc:  Todo
 * https://fcqian.blog.csdn.net/article/details/130764272
题目描述：
一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，
藏宝地有编号从0~N的箱子，每个箱子上面贴有一个数字，箱子中可能有一个黄金宝箱。
黄金宝箱满足排在它之前的所有箱子数字和等于排在它之后的所有箱子数字之和；
第一个箱子左边部分的数字和定义为0；最后一个箱子右边部分的数字和定义为0.
请帮阿里巴巴找到黄金宝箱，输出第一个满足条件的黄金宝箱编号，如果不存在黄金宝箱，请返回-1。
输入描述：
箱子上贴的数字列表，使用逗号分隔，例如1，-1，0
宝箱的数量不小于1个，不超过10000
宝箱上贴的数值范围不低于-1000，不超过1000
输出描述：
第一个黄金宝箱的编号

用例：
输入
2,5,-1,8,6
输出
3
说明
下标3之前的数字和为：2 + 5 + -1 = 6
下标3之后的数字和为：6 = 6

输入
8,9
输出
-1
说明
不存在符合要求的位置

输入
11
输出
0
说明
下标0之前的数字和为：0
下标0之后的数字和为：0

 * @date: 2023/6/4 8:27
 * @version: V-1.0
 */
public class a6阿里巴巴找黄金宝箱1_100_单指针y {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] boxNoStr = sc.nextLine().split(",");
        int[] boxNo = new int[boxNoStr.length];
        for (int i = 0; i < boxNoStr.length; i++) {
            boxNo[i] = Integer.parseInt(boxNoStr[i]);
        }
        getFirstNo(boxNo);
    }

    private static void getFirstNo(int[] boxNo) {
        //满足条件的索引
        int index= 0;
        int leftSum = 0;
        int rightSum = 0;
        while (index < boxNo.length) {
            //计算index左侧的和
            for (int i = 0; i < index; i++) {
                leftSum += boxNo[i];
            }
            //计算index右侧的和
            for (int i = index + 1; i < boxNo.length; i++) {
                rightSum += boxNo[i];
            }

            if (leftSum == rightSum) {
                //当前的索引满足条件则直接输出索引
                System.out.println(index);
                return;
            } else {
                //当前索引不满足条件，将左右和置为0，并将索引右移一位
                leftSum = 0;
                rightSum = 0;
                index++;
            }
        }
        //不存在则输出-1
        System.out.println(-1);
    }
}
