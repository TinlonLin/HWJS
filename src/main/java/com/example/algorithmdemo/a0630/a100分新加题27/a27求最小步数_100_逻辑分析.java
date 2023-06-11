package com.example.algorithmdemo.a0630.a100分新加题27;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2023/6/11 16:02
 * @ClassName: a27求最小步数_100_逻辑分析
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130767673
题目描述：
求从坐标零点到坐标点n的最小步数，一次只能沿横坐标轴向左或向右移动 2 或 3。
注意：途径的坐标点可以为负数
输入描述：
坐标点n
输出描述：
输出从坐标零点移动到坐标点n的最小步数
备注
1 <= n <= 10^9

用例
输入
c
4
输出
2
说明
从坐标零点移动到4，最小需要两步，即右移2，再右移2


public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

System.out.println(getResult(n));
}

public static int getResult(int n) {
if (n == 1) return 2; // -2 + 3
if (n == 2) return 1; // 2
if (n == 3) return 1; // 3

int base = 2;
return (n - 4) / 3 + base;
}

 * @Version: V-1.0
 */
public class a27求最小步数_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(getResult(n));
    }

    public static int getResult(int n) {
        if (n == 1) {
            // -2 + 3
            return 2;
        } else if (n == 2) {
            // 2
            return 1;
        } else if (n == 3) {
            // 3
            return 1;
        }
        int base = 2;
        return (n - 4) / 3 + base;
    }
}
