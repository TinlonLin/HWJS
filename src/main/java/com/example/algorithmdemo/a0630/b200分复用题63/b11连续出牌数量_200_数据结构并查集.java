package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b11连续出牌数量_200_数据结构并查集
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711078

 * @date: 2023/6/4 9:55
 * @version: V-1.0
 */
public class b11连续出牌数量_200_数据结构并查集 {
    private static class UnionFindSet {
        int[] fa;
        int count;

        public UnionFindSet(int n) {
            this.count = n;
            this.fa = new int[n];
            for (int i = 0; i < n; i++) {
                this.fa[i] = i;
            }
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

        String[] nums = sc.nextLine().split(" ");
        String[] colors = sc.nextLine().split(" ");

        System.out.println(getResult(nums, colors));
    }

    private static int getResult(String[] nums, String[] colors) {
        int n = nums.length;

        UnionFindSet ufs = new UnionFindSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i].equals(nums[j]) || colors[i].equals(colors[j])) {
                    ufs.union(i, j);
                }
            }
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int f = ufs.find(i);
            count.put(f, count.getOrDefault(f, 0) + 1);
        }

        return count.values().stream().max((a, b) -> a - b).orElse(1);
    }
}


