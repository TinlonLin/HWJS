package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b111统计射击比赛成绩_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/126005902

 * @date: 2023/6/4 9:47
 * @version: V-1.0
 */
public class b111统计射击比赛成绩_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Integer[] ids =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        Integer[] scores =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(n, ids, scores));
    }

    private static String getResult(int n, Integer[] ids, Integer[] scores) {
        HashMap<Integer, ArrayList<Integer>> players = new HashMap<>();

        for (int i = 0; i < n; i++) {
            players.putIfAbsent(ids[i], new ArrayList<>());
            players.get(ids[i]).add(scores[i]);
        }

        ArrayList<int[]> ans = new ArrayList<>();

        for (int id : players.keySet()) {
            ArrayList<Integer> idScores = players.get(id);
            if (idScores.size() >= 3) {
                int total =
                        idScores.stream().sorted((a, b) -> a - b).limit(3).reduce(Integer::sum).orElse(0);

                ans.add(new int[] {id, total});
            }
        }

        ans.sort((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);

        StringJoiner sj = new StringJoiner(",");
        for (int[] player : ans) {
            sj.add(player[0] + "");
        }

        return sj.toString();
    }
}
