package com.example.algorithmdemo.ExerciseDemo.code0523_数组;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/5/23 1:12
 * @ClassName: MaxMoney
 * @Desc: https://blog.csdn.net/weixin_44219664/article/details/123696410
 * 最大花费金额
 * 输入多个商品的价格数组和购买资金，输出其中三件商品的最大值
 * 输入：
 * 23,26,36,27
 * 78
 * 输出：
 * 76
 * 输入：
 * 23,26,27
 * 26
 * 输出：
 * -1
 * @Version: V-1.0
 */
public class MaxMoney_0523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /** 商品单个价格 */
        String[] M = sc.nextLine().split(",");
        /**购买资金 */
        int R= sc.nextInt();
        sc.close();
        /** 将价格转为整数数组 */
        int[] price = new int[M.length];
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.valueOf(M[i]);
        }
        /** 将价格升序处理 */
        Arrays.sort(price);
        /** 最大花费金额 */
        int max = -1;
        /** 任取三个不同的下标值x，y，z求和， */
        for (int x = 0; x < price.length; x++) {
            for (int y = 0; y < price.length - 1; y++) {
                for (int z = 0; z < price.length - 2; z++) {
                    if (x != y && y != z && z != x) {
                        int sum = price[x] + price[y] + price[z];
                        if (sum <= R && sum > max) {
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);


    }
}
