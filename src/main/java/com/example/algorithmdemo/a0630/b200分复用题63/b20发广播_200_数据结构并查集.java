package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b20发广播_200_数据结构并查集
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127588130

 * @date: 2023/6/4 9:59
 * @version: V-1.0
 */
public class b20发广播_200_数据结构并查集 {
    // 并查集实现
    private static class UnionFindSet {
        int[] fa;
        int count;

        public UnionFindSet(int n) {
            this.fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            this.count = n;
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
                this.count--;
            }
        }
    }

    private static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] matrix = sc.nextLine().split(",");

        System.out.println(getResult(matrix));
    }

    private static int getResult(String[] matrix) {
        int n = matrix.length;

        UnionFindSet ufs = new UnionFindSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    ufs.union(i, j);
                }
            }
        }

        return ufs.count;
    }
}
