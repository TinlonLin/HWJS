package com.example.algorithmdemo.a0630.a200分新加题18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a12数字游戏_200_前缀和加数学问题
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130775047?spm=1001.2014.3001.5501
题目描述:
小明玩一个游戏。
系统发1+n张牌，每张牌上有一个整数。
第一张给小明，后n张按照发牌顺序排成连续的一行。
需要小明判断，后n张牌中，是否存在连续的若干张牌，其和可以整除小明手中牌上的数字。
输入描述:
输入数据有多组，每组输入数据有两行，输入到文件结尾结束。
第一行有两个整数n和m，空格隔开。m代表发给小明牌上的数字。
第二行有n个数，代表后续发的n张牌上的数字，以空格隔开。
输出描述:
对每组输入，如果存在满足条件的连续若干张牌，则输出1;否则，输出0
备注:
1 ≤ n ≤ 1000
1 ≤ 牌上的整数 ≤ 400000
输入的组数，不多于1000
用例确保输入都正确，不需要考虑非法情况。

用例
输入
6 7
2 12 6 3 5 5
10 11
1 1 1 1 1 1 1 1 1 1
输出
1
0
说明
两组输入。第一组小明牌的数字为7，再发了6张牌。第1、2两张牌教字和为14，可以整除7，输出1，
第二组小明牌的教字为11，再发了10张牌，这10张牌数字和为10，无法整除11，输出0。

本题优化是基于一个数学性质：
如果两个数a,b，他们的差a - b可以被k整除，则必然 a % k == b % k。
反之，如果a % k == b % k，那么 a - b 必然可以被k整除。

 * @date: 2023/6/6 11:43 下午
 * @version: V-1.0
 */
public class a12数字游戏_200_前缀和加数学问题 {
    static class Case {
        int m;
        int[] nums;

        public Case(int m, int[] nums) {
            this.m = m;
            this.nums = nums;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Case> cases = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
// 题目没有说明输入截止条件，因此以输入空行作为截止条件
            if ("".equals(line)) {
                getResult(cases);
                break;
            } else {
                int[] tmp = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                cases.add(new Case(tmp[1], nums));
            }
        }
    }

    public static void getResult(ArrayList<Case> cases) {
        for (Case ca : cases) {
            System.out.println(isExist(ca.nums, ca.m));
        }
    }

    public static int isExist(int[] nums, int m) {
        HashSet<Integer> remain = new HashSet<>();
        remain.add(0);

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (remain.contains(sum % m)) {
                return 1;
            } else {
                remain.add(sum % m);
            }
        }
        return 0;
    }
}
