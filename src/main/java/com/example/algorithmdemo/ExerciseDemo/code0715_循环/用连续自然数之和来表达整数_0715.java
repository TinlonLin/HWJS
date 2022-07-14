package com.example.algorithmdemo.ExerciseDemo.code0715_循环;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 用连续自然数之和来表达整数_0715
 * @desc: 用连续自然数之和来表达整数
 * https://blog.csdn.net/weixin_44219664/article/details/123884052
 *
一个整数可以由连续的自然数之和来表示。给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式。

输入描述
一个目标整数 t，1 <= t <= 1000

输出描述
1、该整数的所有表达式和表达式的个数。如果有多种表达式，自然数个数最少的表达式优先输出
2、每个表达式中按自然数递增输出

具体的格式参见样例
在每个测试数据结束时，输出一行"Result:X"，其中 X 是最终的表达式个数

示例 1
输入
9
输出
9=9
9=4+5
9=2+3+4
Result:3

示例 2
输入
10
输出
10=10
10=1+2+3+4
Result:2

 *
 * @date: 2022/6/21 11:32 下午
 * @version: V-1.0
 */
public class 用连续自然数之和来表达整数_0715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        getAllExpressionAndCount(t);
    }

    private static void getAllExpressionAndCount(int t) {
        List<List<Integer>> resultList = new ArrayList<>();
        //每个数本身就符合要求
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(t);
        resultList.add(tmpList);
        //双重循环，寻找是否存在1~t-1开头的连续数和满足条件
        for (int i = 1; i < t; i++) {
            List<Integer> singleList = new ArrayList<>();
            int sum = 0;
            for (int j = i; sum < t; j++) {
                sum += j;
                singleList.add(j);
                //满足条件才加入结果中
                if (sum == t) {
                    resultList.add(singleList);
                    break;
                }
            }
        }
        //按照长度升序排序
        resultList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        //拼接输出结果
        for (List<Integer> list : resultList) {
            StringBuilder builder = new StringBuilder();
            builder.append(t).append("=");
            for (Integer integer : list) {
                builder.append(integer).append("+");
            }
            System.out.println(builder.substring(0, builder.length() - 1).toString());
        }
        System.out.println("Result:" + resultList.size());
    }
}
