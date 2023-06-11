package com.example.algorithmdemo.a0630.a100分新加题27;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a10座位调整_100_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130764903?spm=1001.2014.3001.5501
题目描述：
疫情期间课堂的座位进行了特殊的调整，不能出现两个同学紧挨着，必须隔至少一个空位。
给你一个整数数组 desk 表示当前座位的占座情况，由若干 0 和 1 组成，其中 0 表示没有占位，1 表示占位。
在不改变原有座位秩序情况下，还能安排坐几个人？
输入描述：
第一行是个子数组表示作为占座情况，由若干 0 和 1 组成，其中 0 表示没有占位，1 表示占位
输出描述：
输出数值表示还能坐几个人
备注
1 ≤ desk.length ≤ 2 * 10^4

用例
输入
1,0,0,0,1
输出
1
说明
只有desk[2]的位置可以坐一个人

思路：
将输入解析为一个整型数组desk，然后遍历每一个元素desk[i]：
如果 desk[i] == 0，则说明desk[i]是一个空位，此时只需要检查desk[i]的左右两边也是空位，
则说明desk[i]可以坐人，此时将desk[i]更新为1，表示坐人了，而判断左右是否为空位的逻辑如下：
如果 i == 0 || desk[i-1] == 0，则说明desk[i]左边是空位，i == 0 说明其左边没有其他座位了，也相当于空位。
如果 i == desk.length - 1 || desk[i+1] == 0，则说明desk[i]右边也是空位，i == desk.length - 1
说明其右边没有其他座位了，也就相当于空位
如果 desk[i] != 0，则说明desk[i]不是一个空位，坐不了人，且说明了下一个i+1座位也不能坐人
 * @date: 2023/6/4 8:29
 * @version: V-1.0
 */
public class a10座位调整_100_逻辑分析y {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deskStr = sc.nextLine().split(",");
        int[] desk = new int[deskStr.length];
        for (int i = 0; i < deskStr.length; i++) {
            desk[i] = Integer.parseInt(deskStr[i]);
        }
        getRemainCount(desk);
    }

    public static void getRemainCount(int[] desk) {
        int remainCount = 0;
        for (int i = 0; i < desk.length; i++) {
            if (desk[i] == 0) {
                boolean isLeftEmpty = i == 0 || desk[i - 1] == 0;
                boolean isRightEmpty = i == desk.length - 1 || desk[i + 1] == 0;
                if (isLeftEmpty && isRightEmpty) {
                    remainCount++;
                    desk[i] = 1;
                    i++;
                }
            }
        }
        System.out.println(remainCount);
    }
}
