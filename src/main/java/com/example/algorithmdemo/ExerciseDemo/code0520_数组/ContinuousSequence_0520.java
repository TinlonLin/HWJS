package com.example.algorithmdemo.ExerciseDemo.code0520_数组;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/5/22 22:08
 * @ClassName: ContinuousSequence
 * @Desc: https://blog.csdn.net/qq_41821422/article/details/123885977
 * 求解连续数列：已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N(0<S<100000,0<N<100000),求此数列K。
 * 输入描述:
 * 输入包含两个参数，1)连续正整数数列和S，2)数列里数的个数N。
 * 输出描述:
 * 如果有解输出数列K，如果无解输出-1。
 * 输入：
 * 525
 * 6
 * 输出：80 86 87 88 89 90
 * 思路：该数列为差为1的等差数列 根据公式 S = N*(K1 + KN)/2 = N*(2K1+N-1)/2
 * 推出K1 = (2S/N - N + 1)/2 ,且2S/N-N+1是2的倍数才有意义
 * 然后依次给数列赋值并输出
 * @Version: V-1.0
 */
public class ContinuousSequence_0520 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int N = sc.nextInt();
        sc.close();
        int[] nums = new int[N];
        //2*S%N和(2*S/N - N + 1)%2都要是整数
        if (2*S%N != 0 || (2*S/N - N + 1)%2 != 0 || (2*S/N - N + 1)/2 <= 0) {
            System.out.println(-1);
        } else {
            nums[0] = (2*S/N - N + 1)/2;
            for (int i = 1; i < N; i++) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
