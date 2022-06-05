package com.example.algorithmdemo.ExerciseDemo;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/6/2 1:58
 * @ClassName: MaxOfMartrix_0602
 * @Desc: 矩阵最大值
 * https://blog.csdn.net/weixin_44219664/article/details/123883868?spm=1001.2014.3001.5506
 * 给定一个仅包含0和1的n*n二维矩阵
 * 请计算二维矩阵的最大值
 * 计算规则如下:
 * 1.每行元素按下标顺序组成一个二进制数（下标越大越排在低位）、二进制数的值就是该行的值，矩阵各行之和为矩阵的值
 * 2.允许通过向左或向右整体循环移动每个元素来改变元素在行中的位置
 * 比如
 * [1,0,1,1,1]向右整体循环移动两位[1,1,1,0,1]
 * 二进制数为 11101 值为 29
 * [1,0,1,1,1]向左整体循环移动两位 [1,1,1,1,0]
 * 二进制数为 11110 值为 30
 * 输入描述
 * 1.数据的第一行为正整数，记录了N的大小 0<= N <= 20
 * 2.输入的第2到n+1行为二维矩阵信息 行内元素边角逗号分割
 * 输出描述
 * 矩阵的最大值
输入：
5
1,0,0,0,1
0,0,0,1,1
0,1,0,1,0
1,0,0,1,1
1,0,1,0,1
输出：
122
 * @Version: V-1.0
 */
public class MaxOfMartrix_0602 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //行数、列数
        int n = Integer.parseInt(sc.nextLine());
        //每行最大值
        int rowMax = 0;
        //矩阵最大值
        int matrixMax = 0;
        //循环n行,调用getRowMax获取每一行最大值，并累加
        for (int i = 0; i < n; i++) {
            //先求每一行元素的最大值，再累加获取矩阵的最大值
            String[] matrixArr = sc.nextLine().split(",");
            matrixMax += getRowMax(matrixArr);
        }
        System.out.println(matrixMax);

    }

    private static int getRowMax(String[] matrixArr) {
        //拼接整体移动0~n-1位的字符串，找出其中的最大值
        int rowMax = 0;
        //移动的位数
        for (int i = 0; i < matrixArr.length; i++) {
            StringBuilder builder = new StringBuilder();
            //设定移动方向为向右，先拼接右部分
            for (int j = i; j < matrixArr.length; j++) {
                builder.append(matrixArr[j]);
            }
            //再拼接左边
            for (int k = 0; k < i; k++) {
                builder.append(matrixArr[k]);
            }
            //调用jdk方法计算二进制串的十进制值，并比较每种组合的值，获取每一行的最大值
            rowMax = Math.max(rowMax, Integer.parseInt(builder.toString(), 2));
        }
        return rowMax;
    }


}
