package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b57城市聚集度_200_数据结构并查集
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711368

 * @date: 2023/6/4 10:15
 * @version: V-1.0
 */
public class b57城市聚集度_200_数据结构并查集 {
    private static class UnionFindSet {
        int[] fa;

        public UnionFindSet(int n) {
            this.fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            if (this.fa[x] != x) {
                return this.fa[x] = this.find(this.fa[x]);
            }
            return x;
        }

        public void union(int x, int y) {
            int x_fa = this.find(x);
            int y_fa = this.find(y);

            if (x_fa != y_fa) {
                this.fa[y_fa] = x_fa;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] relations = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        System.out.println(getResult(n, relations));
    }

    private static String getResult(int n, int[][] relations) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> city = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            UnionFindSet ufs = new UnionFindSet(n + 1);
            for (int[] relation : relations) {
                int x = relation[0], y = relation[1];
                if (x == i || y == i) {
                    continue;
                }
                ufs.union(x, y);
            }

            HashMap<Integer, Integer> count = new HashMap<>();
            for (int f : ufs.fa) {
                f = ufs.find(f);
                count.put(f, count.getOrDefault(f, 0) + 1);
            }

            int dp = count.values().stream().max((a, b) -> a - b).orElse(0);

            if (dp < min) {
                min = dp;
                city = new ArrayList<>();
                city.add(i);
            } else if (dp == min) {
                city.add(i);
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (Integer c : city) {
            sj.add(c + "");
        }
        return sj.toString();
    }
}