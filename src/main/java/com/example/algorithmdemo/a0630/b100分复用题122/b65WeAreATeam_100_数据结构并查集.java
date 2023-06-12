package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b65WeAreATeam_100_数据结构并查集
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127710873

 * @date: 2023/6/4 9:26
 * @version: V-1.0
 */
public class b65WeAreATeam_100_数据结构并查集 {

    private static class UnionFindSet {
        int[] fa;

        private UnionFindSet(int n) {
            this.fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        private int find(int x) {
            if (this.fa[x] != x) {
                return this.fa[x] = this.find(this.fa[x]);
            }
            return x;
        }

        private void union(int x, int y) {
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
        int m = sc.nextInt();

        int[][] msgs = new int[m][3];
        for (int i = 0; i < m; i++) {
            msgs[i][0] = sc.nextInt();
            msgs[i][1] = sc.nextInt();
            msgs[i][2] = sc.nextInt();
        }

        getResult(msgs, n, m);
    }

    private static void getResult(int[][] msgs, int n, int m) {
        if (n < 1 || n >= 100000 || m < 1 || m >= 100000) {
            System.out.println("Null");
            return;
        }

        UnionFindSet ufs = new UnionFindSet(n + 1);

        Arrays.sort(msgs, (x, y) -> x[2] - y[2]);

        for (int[] msg : msgs) {
            int a = msg[0], b = msg[1], c = msg[2];

            if (a < 1 || a > n || b < 1 || b > n) {
                System.out.println("da pian zi");
                continue;
            }

            if (c == 0) {
                ufs.union(a, b);
            } else if (c == 1) {
                System.out.println(ufs.find(a) == ufs.find(b) ? "We are a team" : "We are not a team");
            } else {
                System.out.println("da pian zi");
            }
        }
    }
}


