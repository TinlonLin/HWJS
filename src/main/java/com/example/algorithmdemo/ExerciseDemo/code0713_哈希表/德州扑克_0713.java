package com.example.algorithmdemo.ExerciseDemo.code0713_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 德州扑克_0713
 * @desc: 德州扑克
 * https://blog.csdn.net/vsky_ma/article/details/83020594
 * https://zh.wikipedia.org/zh-hans/%E6%92%B2%E5%85%8B%E7%89%8C%E5%9E%8B
五张牌，每张牌由牌大小和花色组成，牌大小2~10、J、Q、K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一。 判断牌型:

牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
牌型6，三条：三张相同 + 两张单。
牌型7，其他。

说明：
1）五张牌里不会出现牌大小和花色完全相同的牌。
2）前面的牌型比后面的牌型大，如同花顺比四条大，依次类推。

输入描述:
输入由5行组成
每行为一张牌大小和花色，牌大小为2~10、J、Q、K、A，花色分别用字符H、S、C、D表示红桃、黑桃、梅花、方块。

输出描述:
输出牌型序号，5张牌符合多种牌型时，取最大的牌型序号输出

示例1
输入：
2 H
3 C
6 S
5 S
4 S

输出：
5

A H
2 S
3 S
4 S
5 D

10 H
J H
Q H
K H
A H
5
 * @date: 2022/6/21 11:30 下午
 * @version: V-1.0
 */
public class 德州扑克_0713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] m = new int[5];
        String[] n = new String[5];
        for (int i = 0; i < 5; i++) {
            String[] line = sc.nextLine().split("\\s+");
            switch (line[0]) {
                case "J":
                    m[i] = 11;
                    break;
                case "Q":
                    m[i] = 12;
                    break;
                case "K":
                    m[i] = 13;
                    break;
                case "A":
                    m[i] = 1;
                    break;
                default:
                    m[i] = Integer.parseInt(line[0]);
                    break;
            }
            n[i] = line[1];
        }
        ArrayList<Integer> list = new ArrayList<>();
        boolean errflag = false;
        for (int i = 0; i < n.length; i++) {
            if (!"HSCD".contains(n[i])) {
                System.out.println(7);
                errflag = true;
            }
        }
        Arrays.sort(m);
        boolean nflag = false;
        if (n[0].equals(n[1]) && n[1].equals(n[2]) && n[2].equals(n[3]) && n[3].equals(n[4])) {
            nflag = true;
            list.add(4);
        }

        int lcnt = 1;
        for (int i = 0; i < m.length - 1; i++) {
            if (m[i + 1] - m[i] == 1) {
                lcnt++;
            }
        }
        int e1cnt = 1;
        int e2cnt = 1;
        iw:
        for (int i = 0; i < m.length - 1; i++) {
            if (m[i + 1] == m[i]) {
                e1cnt++;
            } else if (m[i + 1] != m[i]) {
                for (int j = i + 1; j < m.length - 1; j++) {
                    if (m[j + 1] == m[j]) {
                        e2cnt++;
                    }
                }
                break iw;
            }
        }
        if (lcnt == 5 && nflag) {
            list.add(1);
        } else if ((e1cnt == 4 || e2cnt == 4) && !nflag) {
            list.add(2);
        } else if ((e1cnt == 3 && e2cnt == 2) || ((e1cnt == 2 && e2cnt == 3)) && !nflag) {
            list.add(3);
        } else if (lcnt == 5 && !nflag) {
            list.add(5);
        } else if ((e1cnt == 3 && e2cnt == 1) || ((e1cnt == 1 && e2cnt == 3)) && !nflag) {
            list.add(6);
        } else {
            list.add(7);
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
}
