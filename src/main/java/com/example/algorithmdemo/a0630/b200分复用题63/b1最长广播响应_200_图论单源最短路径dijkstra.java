package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b1最长广播响应_200_图论单源最短路径dijkstra
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711123

 * @date: 2023/6/4 9:52
 * @version: V-1.0
 */
public class b1最长广播响应_200_图论单源最短路径dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[][] relations = new int[t][2];
        for (int i = 0; i < t; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        int src = sc.nextInt();
        System.out.println(getResult(n, src, relations));
    }

    private static int getResult(int n, int src, int[][] relations) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int[] relation : relations) {
            int u = relation[0];
            int v = relation[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);

            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(u);
        }

        ArrayList<Integer> dist = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        dist.set(src, 0);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        while (true) {
            if (graph.containsKey(src)) {
                for (Integer v : graph.get(src)) {
                    int newDist = dist.get(src) + 1;
                    if (newDist < dist.get(v)) {
                        dist.set(v, newDist);
                        pq.offer(new Integer[] {v, newDist});
                    }
                }
            }

            if (pq.isEmpty()) {
                break;
            }
            src = pq.poll()[0];
        }

        dist.remove(0);

        return dist.stream().max((a, b) -> a - b).get() * 2;
    }
}
