package com.example.algorithmdemo.yuanti;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 数字涂色
 * @desc: 100%
 * @date: 2022/7/16 11:33 上午
 * @version: V-1.0
 */
public class 数字涂色 {
    /*
        疫情过后希望小学终于又重新开学了
        3年2班开学第一天的任务是
        将后面的黑板报重新制作
        黑板上已经写上了N个正整数
        同学们需要给这每个数分别上一种颜色
        为了让黑板报既美观又有学习意义
        老师要求同种颜色的所有数都可以被这个颜色中最小的那个数整除
        现在帮小朋友们算算最少需要多少种颜色，给这N个数进行上色

        输入描述
            第一行有一个正整数N
            其中 1 <= n <=100
            第二行有N个int型数，保证输入数据在[1,100]范围中
            表示黑板上各个正整数的值

         输出描述
         输出只有一个整数，为最少需要的颜色种数

            输入
            3
            2 4 6
            输出
            1
            说明：
            所有数都能被2整除

            输入
            4
            2 3 4 9
            输出
            2
            说明：
            2与4涂一种颜色，4能被2整除
            3与9涂另一种颜色，9能被3整除
            不能涂同一种颜色

         */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nStr = in.nextLine();
        String[] nums = in.nextLine().split(" ");
        in.close();

        TreeSet<Integer> ints = new TreeSet<>();
        for (String num : nums) {
            ints.add(Integer.parseInt(num));
        }

        if (ints.contains(1)) {
            System.out.println(1);
            ints.remove(1);
            return;
        }

        ArrayList<Integer> intList = new ArrayList<>(ints);
        for (int i = 0; i < intList.size(); i++) {
            Integer cur = intList.get(i);
            for (int j = i + 1; j < intList.size(); ) {
                if (intList.get(j) % cur == 0) {
                    intList.remove(j);
                } else {
                    j++;
                }
            }
        }
        System.out.println(intList.size());
    }
}
