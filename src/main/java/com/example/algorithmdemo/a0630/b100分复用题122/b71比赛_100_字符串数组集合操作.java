package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b71比赛_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128007856

 * @date: 2023/6/4 9:29
 * @version: V-1.0
 */
public class b71比赛_100_字符串数组集合操作 {
    public static void main(String[] args) {
        // 将输入分隔符设置为“,”或者换行
        Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] scores = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                scores[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(m, n, scores));
    }

    private static String getResult(int m, int n, int[][] scores) {
        if (m < 3 || m > 10 || n < 3 || n > 100) {
            return "-1";
        }

        HashMap<Integer, Integer[]> players = new HashMap<>();

        for (int j = 0; j < n; j++) {
            // 列
            Integer[] player = new Integer[m];
            for (int i = 0; i < m; i++) {
                // 行
                if (scores[i][j] > 10 || scores[i][j] < 1) {
                    return "-1";
                }
                // 队员得分1~10合法，否则不合法
                player[i] = scores[i][j];
            }
            // 将每个队员的得分降序
            Arrays.sort(player, (a, b) -> b - a);
            players.put(j, player);
        }

        StringJoiner sj = new StringJoiner(",");

        players.entrySet().stream()
                .sorted(
                        (a, b) -> {
                            Integer[] playerA = a.getValue();
                            Integer[] playerB = b.getValue();

                            int sumA = sum(playerA);
                            int sumB = sum(playerB);

                            if (sumA != sumB) { // 按总分降序
                                return sumB - sumA;
                            }

                            for (int i = 0; i < m; i++) {
                                if (playerA[i].equals(playerB[i])) {
                                    continue;
                                }
                                return playerB[i] - playerA[i]; // 按最高分降序
                            }

                            return 0;
                        })
                .limit(3)
                .forEach(p -> sj.add(p.getKey() + 1 + ""));

        return sj.toString();
    }

    private static int sum(Integer[] arr) {
        return Arrays.stream(arr).reduce(Integer::sum).orElse(0);
    }
}
