package com.example.algorithmdemo.ExerciseDemo.code0630_递归;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 素数之积_0630
 * @desc: 素数之积
 * https://blog.csdn.net/qq_34465338/article/details/125028089
 * 给定一个 32 位正整数，对其进行因数分解，分解成两个素数的乘积，如果不能分解输出 -1,-1 。
 * 输入
 * 15
 * 输出
 * 3,5
 * 输入：
 * 27
 * 输出：
 * -1,-1
 * @date: 2022/6/21 11:20 下午
 * @version: V-1.0
 */
public class 素数之积_0630 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        getTwoPrime(num);
    }

    private static void getTwoPrime(int num) {
        //满足条件的两个数，都初始为-1
        int a = -1;
        int b = -1;
        if (num > 3) {
            for (int i = 2; i < num; i++) {
                for (int j = i+1; j < num; j++) {
                    if (isPrime(i) && isPrime(j) && i*j ==num) {
                        a = i;
                        b = j;
                    }
                }
            }
        }
        System.out.println(a + "," + b);
    }

    //判断是否为素数
    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
