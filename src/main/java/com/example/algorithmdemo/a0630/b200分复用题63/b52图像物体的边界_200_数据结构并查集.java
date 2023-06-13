package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b52图像物体的边界_200_数据结构并查集
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127647130

 * @date: 2023/6/4 10:13
 * @version: V-1.0
 */
public class b52图像物体的边界_200_数据结构并查集 {
    private static class UnionFindSet {
        int[] fa;
        int count;

        public UnionFindSet(int n) {
            this.count = n;
            this.fa = new int[n];
            for (int i = 0; i < n; i++) this.fa[i] = i;
        }

        public int find(int x) {
            if (x != this.fa[x]) {
                return (this.fa[x] = this.find(this.fa[x]));
            }
            return x;
        }

        public void union(int x, int y) {
            int x_fa = this.find(x);
            int y_fa = this.find(y);

            if (x_fa != y_fa) {
                this.fa[y_fa] = x_fa;
                this.count--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(matrix, m, n));
    }

    private static int getResult(int[][] matrix, int m, int n) {
        ArrayList<int[]> brands = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 5) {
                    brands.add(new int[] {i, j});
                }
            }
        }

        int k = brands.size();
        if (k == 0 || k == n * m) {
            return 0;
        }

        UnionFindSet ufs = new UnionFindSet(k);

        for (int i = 0; i < k; i++) {
            int x1 = brands.get(i)[0], y1 = brands.get(i)[1];
            for (int j = i + 1; j < k; j++) {
                int x2 = brands.get(j)[0], y2 = brands.get(j)[1];

                if (Math.abs(x2 - x1) <= 3 && Math.abs(y2 - y1) <= 3) {
                    ufs.union(i, j);
                }
            }
        }

        return ufs.count;
    }
}
