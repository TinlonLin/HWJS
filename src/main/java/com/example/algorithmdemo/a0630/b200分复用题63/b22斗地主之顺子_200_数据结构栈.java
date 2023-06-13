package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b22斗地主之顺子_200_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127578510

 * @date: 2023/6/4 9:59
 * @version: V-1.0
 */
public class b22斗地主之顺子_200_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cards = sc.nextLine().split(" ");
        getResult(cards);
    }

    private static void getResult(String[] cards) {
        // 总牌数
        int total = cards.length;

        // 记录每张牌的数量
        int[] count = new int[15];
        for (String card : cards) {
            int num = mapToNum(card);
            count[num]++;
        }

        // 记录顺子，顺子表示为数组，数组含义：[起始牌，结束牌]
        ArrayList<int[]> straights = new ArrayList<>();

        for (int i = 3; i <= 10; i++) {
            // 先求五张的顺子
            if (isStraight(count, i, i + 4)) {
                // 如果可以组成五张顺子，则记录该顺子
                straights.add(new int[] {i, i + 4});
                // 总牌数减5
                total -= 5;
                // 对应的牌的数量减1
                for (int j = i; j <= i + 4; j++) count[j]--;
            }
        }

        // 如果五张的顺子求解完后，还有剩余牌
        if (total > 0) {
            // 则尝试将剩余牌追加到五张顺子后面
            for (int[] straight : straights) {
                for (int i = 3; i <= 14; i++) {
                    if (count[i] > 0 && i - straight[1] == 1) {
                        straight[1] = i;
                        count[i]--;
                    }
                }
            }
        }

        // 如果没有顺子，则返回No
        if (straights.size() == 0) {
            System.out.println("No");
            return;
        }

        // 如果有顺子，则打印顺子
        for (int[] straight : straights) {
            int start = straight[0];
            int end = straight[1];

            StringJoiner sj = new StringJoiner(" ");
            for (int i = start; i <= end; i++) {
                sj.add(mapToCard(i));
            }
            System.out.println(sj);
        }
    }

    private static boolean isStraight(int[] count, int start, int end) {
        int i = start;
        for (; i <= end; i++) {
            if (count[i] == 0) break;
        }
        return i > end;
    }

    private static int mapToNum(String card) {
        switch (card) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(card);
        }
    }

    private static String mapToCard(int num) {
        switch (num) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            default:
                return num + "";
        }
    }
}
