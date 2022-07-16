package com.example.algorithmdemo.yuanti;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 按照数组元素十进制最低位从小到大进行排序_新
 * @desc: 100%
 * @date: 2022/7/16 11:32 上午
 * @version: V-1.0
 */
public class 按照数组元素十进制最低位从小到大进行排序_新 {
    /*
         给定一个非空数组(列表)
         起元素数据类型为整型
         请按照数组元素十进制最低位从小到大进行排序
         十进制最低位相同的元素，相对位置保持不变
         当数组元素为负值时，十进制最低为等同于去除符号位后对应十进制值最低位

         输入描述
         给定一个非空数组(列表)
         其元素数据类型为32位有符号整数
        数组长度为[1,1000]
        输出排序后的数组

        输入
        1,2,5,-21,22,11,55,-101,42,8,7,32
        输出
        1,-21,11,-101,2,22,42,32,5,55,7,8

         */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(",");
        in.close();

        ArrayList<Integer> list = new ArrayList<>();
        for (String num : nums) {
            list.add(Integer.parseInt(num));
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return getKey(o1) - getKey(o2);
            }

            public Integer getKey(int i) {
                i = i > 0 ? i : -i;
                return i % 10;
            }
        });

        String listStr = list.toString();
        String res = listStr.substring(1, listStr.length() - 1)
                .replaceAll(" ", "");

        System.out.println(res);
    }
}
