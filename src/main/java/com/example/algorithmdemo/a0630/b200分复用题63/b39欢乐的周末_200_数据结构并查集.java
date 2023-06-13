package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b39欢乐的周末_200_数据结构并查集
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711495

 * @date: 2023/6/4 10:05
 * @version: V-1.0
 */
public class b39欢乐的周末_200_数据结构并查集 {
    private static // 并查集实现
    class UnionFindSet {
        int[] fa;

        public UnionFindSet(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
        }

        public int find(int x) {
            if (x != this.fa[x]) {
                this.fa[x] = this.find(this.fa[x]);
                return this.fa[x];
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

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(n, m, matrix));
    }

    public static int getResult(int n, int m, int[][] matrix) {
        UnionFindSet ufs = new UnionFindSet(n * m);

        ArrayList<Integer> huawei = new ArrayList<>();
        ArrayList<Integer> restaurants = new ArrayList<>();

        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != 1) {
                    int x = i * m + j;
                    if (matrix[i][j] == 2) {
                        huawei.add(x);
                    } else if (matrix[i][j] == 3) {
                        restaurants.add(x);
                    }

                    for (int[] offset : offsets) {
                        int newI = i + offset[0];
                        int newJ = j + offset[1];
                        if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && matrix[newI][newJ] != 1) {
                            ufs.union(x, newI * m + newJ);
                        }
                    }
                }
            }
        }

        int hua_fa = ufs.find(huawei.get(0));
        int wei_fa = ufs.find(huawei.get(1));

        if (hua_fa != wei_fa) {
            return 0;
        }

        int ans = 0;
        for (Integer restaurant : restaurants) {
            if (ufs.find(restaurant) == hua_fa) {
                ans++;
            }
        }

        return ans;
    }
}
