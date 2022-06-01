package com.example.algorithmdemo.ExerciseDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/5/22 22:49
 * @ClassName: SimilarHeight
 * @Desc: https://www.csdn.net/tags/MtTaAg3sOTE1NDIwLWJsb2cO0O0O.html
 * 寻找身高相近的小朋友
 * 输入描述：
 * 第一行为正整数 h和n 0<h<200 为小明的身高 0<n<50 为新班级其他小朋友个数
 * 第二行为n各正整数 h1 ~ hn分别是其他小朋友的身高 取值范围0<hi<200 且n个正整数各不相同
 * 输出描述：
 * 输出排序结果，各正整数以空格分割
 * 和小明身高差绝对值最小的小朋友排在前面
 * 和小明身高差绝对值最大的小朋友排在后面
 * 如果两个小朋友和小明身高差一样
 * 则个子较小的小朋友排在前面
 * 输入：
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105
 * 输出：
 * 99 101 98 102 97 103 96 104 95 105
 * @Version: V-1.0
 */
public class SimilarHeight_0523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();
        /** 小明身高 和 其他人数字符串*/
        String[] h_n = sc.nextLine().split(" ");
        int h = Integer.valueOf(h_n[0]);
        /** 其他同学人数 */
        int n = Integer.valueOf(h_n[1]);
        /** 其他同学身高字符串 */
        String[] hStr = sc.nextLine().split(" ");
        /** 将其他身高转为int型 */
        int[] H = new int[n];
        for (int i = 0; i < hStr.length; i++) {
            H[i] = Integer.valueOf(hStr[i]);
        }
        /** 计算差值的绝对值 */
        int[] absDiffer = new int[n];
        for (int i = 0; i < n; i++) {
            absDiffer[i] = Math.abs(H[i] - h);
        }
        /** 对差值绝对值排序 */
        Arrays.sort(absDiffer);
        /** 排序后的其他同学身高数组 */
        int[] newH = new int[n];
        /** 先将其他同学身高存入list中 */
        List<Integer> Hlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Hlist.add(H[i]);
        }
        /** 遍历差值绝对值数组 */
        for (int i = 0; i < n; i++) {
            if (Hlist.contains(h-absDiffer[i]) && Hlist.contains(h-absDiffer[i])) {
                newH[i] = h - absDiffer[i];
                newH[i + 1] = h +absDiffer[i];
                i++;
            } else if (Hlist.contains(h-absDiffer[i]) && !Hlist.contains(h-absDiffer[i])) {
                newH[i] = h - absDiffer[i];
            } else if (!Hlist.contains(h-absDiffer[i]) && Hlist.contains(h-absDiffer[i])) {
                newH[i] = h - absDiffer[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(newH[i] + " ");
        }

    }
}
