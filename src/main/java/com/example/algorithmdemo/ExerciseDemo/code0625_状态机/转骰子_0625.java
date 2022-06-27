package com.example.algorithmdemo.ExerciseDemo.code0625_状态机;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 转骰子_0625
 * @desc: 转骰子
 * https://blog.csdn.net/qq_34465338/article/details/125031254?spm=1001.2014.3001.5506
 * <p>
 * 输入：
 * LR
 * 输出：
 * 123456
 * 说明：骰子先向左翻转再向右翻转，故还是原来的状态123456
 * <p>
 * 输入：
 * FCR
 * 输出：
 * 342156
 * 说明：
 * 骰子向前翻转，状态变为125643，再顺时针旋转，状态变为651243，最后向右翻转，状态变为342156
 * @date: 2022/6/21 11:15 下午
 * @version: V-1.0
 */
public class 转骰子_0625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //骰子的初始状态
        String state = "123456";

        for (int i = 0; i < s.length(); i++) {
            state = zhuanSZ(String.valueOf(s.charAt(i)), state);
        }
        System.out.println(state);
    }

    private static String zhuanSZ(String s, String state) {

        /**
         * 需要将char转成sting，否则会变成ASCII码值的和
         */
        String s1 = String.valueOf(state.charAt(0));
        String s2 = String.valueOf(state.charAt(1));
        String s3 = String.valueOf(state.charAt(2));
        String s4 = String.valueOf(state.charAt(3));
        String s5 = String.valueOf(state.charAt(4));
        String s6 = String.valueOf(state.charAt(5));

        /**
         * 骰子转向各个方向的重新排序
         */
        switch (s) {
            case "L":
                return s5 + s6 + s3 + s4 + s2 + s1;
            case "R":
                return s6 + s5 + s3 + s4 + s1 + s2;
            case "F":
                return s1 + s2 + s5 + s6 + s4 + s3;
            case "B":
                return s1 + s2 + s6 + s5 + s3 + s4;
            case "A":
                return s4 + s3 + s1 + s2 + s5 + s6;
            case "C":
                return s3 + s4 + s2 + s1 + s5 + s6;
            default:
                return "";
        }
    }
}
