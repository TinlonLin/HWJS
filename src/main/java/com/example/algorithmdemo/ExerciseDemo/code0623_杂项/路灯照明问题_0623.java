package com.example.algorithmdemo.ExerciseDemo.code0623_杂项;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 路灯照明问题_0623
 * @desc: 路灯照明问题
 * https://blog.csdn.net/qq_38969990/article/details/123871880?spm=1001.2014.3001.5506
 * 路灯照明覆盖
 * 笔直路上，路灯间距100，每个灯有不同的发光范围 ri<10000*100。求灯光未覆盖区域值。
 * 输入：4 （路灯个数）
 * 输入：50 70 20 70 （每个灯的发光范围）
 * 输出：20（路灯未覆盖区域长度）
 * @date: 2022/6/21 11:14 下午
 * @version: V-1.0
 */
public class 路灯照明问题_0623 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] lightArea = new int[n];
        for (int i = 0; i < n; i++) {
            lightArea[i] = sc.nextInt();
        }
        getDarkArea(n, lightArea);
    }

    private static void getDarkArea(int n, int[] lightArea) {
        //相邻路灯之间不足100的部分累加和即为总的未覆盖区域值
        int darkArea = 0;
        for (int i = 0; i < n - 1; i++) {
            if (lightArea[i + 1] + lightArea[i] >= 100) {
                continue;
            } else {
                darkArea += 100 - (lightArea[i + 1] + lightArea[i]);
            }
        }
        System.out.println(darkArea);
    }
}
