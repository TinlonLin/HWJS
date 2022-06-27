package com.example.algorithmdemo.ExerciseDemo.code0628_滑窗;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 求满足条件的最长子串的长度_0628
 * @desc: 求满足条件的最长子串的长度
 * https://blog.csdn.net/qq_40712210/article/details/105127391?spm=1001.2014.3001.5506
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 条件：该子串中各字符最多出现两次。
 * <p>
 * 测试用例：
 * 输入：abcabcbb
 * 输出：6
 * 说明：子串abcabc每个字符出现的次数都小于等于2，满足条件且为最长，输出长度6。
 * @date: 2022/6/21 11:18 下午
 * @version: V-1.0
 */
public class 求满足条件的最长子串的长度_0628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        getLongestNoRepeatSubStr(str);
    }

    private static void getLongestNoRepeatSubStr(String str) {
        int length = 0;
        //map记录扫描后已存在的字符以及字符在原字符串序列中的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                i = Math.max(i, map.get(str.charAt(j)));
            }
            length = Math.max(length, i - j + 1);
            map.put(str.charAt(i), i + 1);
        }
        System.out.println(length);
    }
}
