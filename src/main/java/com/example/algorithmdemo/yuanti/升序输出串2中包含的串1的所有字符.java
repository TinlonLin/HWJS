package com.example.algorithmdemo.yuanti;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 升序输出串2中包含的串1的所有字符
 * @desc: Todo
 * @date: 2022/7/16 12:08 下午
 * @version: V-1.0
 */
public class 升序输出串2中包含的串1的所有字符 {
/*
题目描述：
给定两个字符串，
从字符串2中找出字符串1中的所有字符，
去重并按照ASCII码值从小到大排列，

输入描述
字符范围满足ASCII编码要求，
输入字符串1长度不超过1024，
字符串2长度不超过100

输出描述
按照ASCII由小到大排序

示例一
输入
bach
bbaaccddfg

输出
abc

示例二
输入
fach
bbaaccedfg

输出
acf
 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        solution(str1, str2);
    }

    private static void solution(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = str2.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars2) {
            set.add(c);
        }

        Set<Character> res = new TreeSet<>();
        for (char c : chars1) {
            if (set.contains(c)) {
                res.add(c);
            }
        }

        for (Character c : res) {
            System.out.print(c);
        }
    }
}
