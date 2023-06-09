package com.example.algorithmdemo.ExerciseDemo.code0520_数组;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/5/22 19:19
 * @ClassName: MaxDifference
 * @Desc: todo
 * https://blog.csdn.net/weixin_44052055/article/details/124064445
 * 判断一组不等式是否满足约束并输出最大差
 * 思路：通过对输入的字符串切分，分别将变量x,系数，目标值，不等符号存入数组，
 * 然后计算不等式左边的值与目标值比较，判断时候满足约束，
 * 最后分别计算不等式左边的和与目标值的差的最大值
 * 输入1：2.3,3,5.6,7,6;11,3,8.6,25,1;0.3,9,5.3,66,7.8;1,3,2,7,5;340,670,80.6;<=,<=,<=
 * 输出1：false 458
 * 输入2：2.36,3,6,7.1,6;1,30,8.6,2.5,21;0.3,69,5.3,6.6,7.8;1,13,2,17,5;340,67,300.6;<=,>=,<=
 * 输出2: false 758
 * @Version: V-1.0
 */
public class 判断一组不等式是否满足约束并输出最大差_0520 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(";");
        sc.close();
        //等式数量
        int nums_eq = str[str.length - 1].split(",").length;
        //x数量
        int nums_x = str[0].split(",").length;
        //定义系数数组
        double[][] a = new double[nums_eq][nums_x];
        //定义变量x数组
        int[] x = new int[nums_x];
        //定义目标值数组b
        double[] b = new double[nums_eq];
        //定义符号数组
        String[] eq = new String[nums_eq];
        //定义差值数组result
        int[] result = new int[nums_eq];
        //定义最大值max
        int max = 0;
        //是否满足约束isVaild
        boolean isValid = false;

        //处理系数a
        for (int i = 0; i < nums_eq; i++) {
            String[] temp1 = str[i].split(",");
            for (int j = 0; j < nums_x; j++) {
                a[i][j] = Double.parseDouble(temp1[j]);
            }
        }
        //处理变量x
        String[] temp2 = str[nums_eq].split(",");
        for (int i = 0; i < temp2.length; i++) {
            x[i] = Integer.parseInt(temp2[i]);
        }
        //处理目标值
        String[] temp3 = str[nums_eq + 1].split(",");
        for (int i = 0; i < temp3.length; i++) {
            b[i] = Double.parseDouble(temp3[i]);
        }
        //处理符号eq
        String[] temp4 = str[nums_eq + 2].split(",");
        for (int i = 0; i < temp4.length; i++) {
            eq[i] = temp4[i];
        }

        //不等式成立的数量，要三个不等式都成立结果才为true
        int count = 0;
        //判断是否满足约束
        for (int i = 0; i < nums_eq; i++) {
            //定义左边累加之和sum
            double sum = 0.0;
            for (int j = 0; j < nums_x; j++) {
                sum += a[i][j] * x[j];
                if ("<" == eq[i]) {
                    isValid = sum < b[i];
                } else if ("<=" == eq[i]) {
                    isValid = sum <= b[i];
                } else if ("=" == eq[i]) {
                    isValid = sum == b[i];
                } else if (">" == eq[i]) {
                    isValid = sum > b[i];
                } else if (">=" == eq[i]) {
                    isValid = sum >= b[i];
                }
                //将double强转为int
                result[i] = (int)(sum - b[i]);
                if (isValid) {
                    count++;
                }
            }
        }
        //计算最大差值
        for (int i = 0; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }
        if (3 == count) {
            isValid = true;
        } else {
            isValid = false;
        }
        System.out.println(isValid + " " + max);
     }
}
