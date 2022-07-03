package com.example.algorithmdemo.ExerciseDemo.code0704_BFS广搜图;

import org.yaml.snakeyaml.nodes.ScalarNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 篮球比赛_0704
 * @desc: 篮球比赛
 * https://blog.csdn.net/qq_34465338/article/details/124429066
 * <p>
 * 篮球（5V5）比赛中，每个球员拥有一个战斗力，每个队伍的所有球员战斗力之和为该队伍的总体战斗力
 * 现有10个球员准备分为两队进行训练赛，教练希望2个队伍战斗力差值尽可能的小，已达到最佳训练效果。
 * 给定10个球员的战斗力，你该如何分队，才能达到最佳效果？请输出该方案下的最小战斗力差值
 * <p>
 * 输入描述：
 * 10个篮球队员的战斗力（整数，范围[1,10000]），战斗力之间用空格分隔，如：10 9 8 7 6 5 4 3 2 1
 * 不需要考虑异常输入的场景
 * 输出描述：
 * 最小的战斗力差值，如：1
 * <p>
 * 示例1
 * 输入：
 * 10 9 8 7 6 5 4 3 2 1
 * 输出：
 * 1
 * <p>
 * 说明：
 * 1 2 5 9 10分为一队，3 4 6 7 8分为一队，两队战斗力之差最小，输出差值1
 * 备注：球员分队方案不唯一，但最小战斗力差值固定是1
 * @date: 2022/6/21 11:21 下午
 * @version: V-1.0
 */
public class 篮球比赛_0704 {

    public static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        int len = strings.length;
        int[] ints = new int[len];
        int count = 0;

        for (int i = 0; i < len; i++) {
            int temp = Integer.valueOf(strings[i]);
            ints[i] = temp;
            count += temp;
        }
        //对篮球队员进行全排列
        combine(ints, 5, new ArrayList<>(), 0);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            min = Math.min(Math.abs(count - nums.get(i) * 2), min);
        }
        System.out.println(min);
    }

    //M个字符取N个字符全排列

    /**
     * 经典的 M 个字符中取 N 个字符的全排列算法
     *
     * @param s     所有队员
     * @param n     需要的队员个数
     * @param list  加入的队员
     * @param index 队员下标
     */
    public static void combine(int[] s, int n, List<Integer> list, int index) {

        if (n == 0) {
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                res += list.get(i);
            }
            nums.add(res);
        } else {
            for (int i = index; i < s.length; i++) {
                list.add(s[i]);
                combine(s, n - 1, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
