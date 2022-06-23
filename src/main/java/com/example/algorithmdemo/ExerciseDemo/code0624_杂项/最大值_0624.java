package com.example.algorithmdemo.ExerciseDemo.code0624_杂项;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 最大值_0624
 * @desc: 最大值
 * https://leetcode.cn/problems/largest-number/
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * @date: 2022/6/21 11:15 下午
 * @version: V-1.0
 */
public class 最大值_0624 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numStrArr = sc.nextLine().split(",");
        getMaxNum(numStrArr);
    }

    private static void getMaxNum(String[] numStrArr) {
        List<String> numStrList = new ArrayList<>();
        for (String s : numStrArr) {
            numStrList.add(s);
        }
        //自定义排序，根据相邻两个数字字符串拼接后的整数值降序排序，最后得到总体最大的值
        numStrList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int s1 = Integer.parseInt(o1 + o2);
                int s2 = Integer.parseInt(o2 + o1);
                return s2 - s1;
            }
        });
        //排序后拼接输出最大值
        StringBuilder builder = new StringBuilder();
        for (String s : numStrList) {
            builder.append(s);
        }
        System.out.println(builder.toString());
    }
}
