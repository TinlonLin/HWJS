package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b78判断一组不等式是否满足约束并输出最大差_100_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127638658
 * @date: 2023/6/4 9:32
 * @version: V-1.0
 */
public class b78判断一组不等式是否满足约束并输出最大差_100_逻辑分析 {
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
