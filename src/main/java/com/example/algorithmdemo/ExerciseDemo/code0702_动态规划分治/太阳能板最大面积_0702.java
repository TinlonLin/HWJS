package com.example.algorithmdemo.ExerciseDemo.code0702_动态规划分治;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 太阳能板最大面积_0702
 * @desc: 太阳能板最大面积
 * https://blog.csdn.net/AOBO516/article/details/125115971
给航天器一侧加装长方形和正方形的太阳能板(图中的斜线区域)
需要先安装两个支柱(图中的黑色竖条)
再在支柱的中间部分固定太阳能板
但航天器不同位置的支柱长度不同
太阳能板的安装面积受限于最短一侧的那支支柱的长度

现提供一组整型数组的支柱高度数据
假设每个支柱间的距离相等为一个单位长度
计算如何选择两根支柱可以使太阳能板的面积最大

输入描述
10,9,8,7,6,5,4,3,2,1
注释，支柱至少有两根，最多10000根，能支持的高度范围1~10^9的整数

柱子的高度是无序的
例子中的递减是巧合

输出描述
可以支持的最大太阳板面积:(10m高支柱和5m高支柱之间)
25

示例1
输入
10,9,8,7,6,5,4,3,2,1

输出
25

备注 10米高支柱和5米高支柱之间宽度为5，高度取小的支柱高度也是5
面积为25
任取其他两根支柱所能获得的面积都小于25 所以最大面积为25。

思路分析
10米高支柱和5米高支柱之间宽度为5，柱子的高度是无序的，所以宽等于高支柱的高减去低支柱的高。
高度取小的支柱高度。
任取其他两根支柱所能获得的面积，取其中最大的。

 * @date: 2022/6/21 11:21 下午
 * @version: V-1.0
 */
public class 太阳能板最大面积_0702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] heightStrArr = sc.nextLine().split(",");
        long[] heightArr = new long[heightStrArr.length];
        for (int i = 0; i < heightArr.length; i++) {
            heightArr[i] = Long.parseLong(heightStrArr[i]);
        }
        getMaxArea(heightArr);
    }

    private static void getMaxArea(long[] heightArr) {
        long maxArea = 0;
        for (int i = 0; i < heightArr.length; i++) {
            for (int j = 0; j < heightArr.length; j++) {
                //高取短柱子的长度
                long height = Math.min(heightArr[i],heightArr[j]);
                //宽度取长短柱子之差
                long width = Math.abs(heightArr[i] - heightArr[j]);
                maxArea = Math.max(maxArea,height * width);
            }
        }
        System.out.println(maxArea);
    }
}
