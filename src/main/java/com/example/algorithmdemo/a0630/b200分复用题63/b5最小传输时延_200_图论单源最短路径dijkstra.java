package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b5最小传输时延_200_图论单源最短路径dijkstra
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127649555

 * @date: 2023/6/4 9:53
 * @version: V-1.0
 */
public class b5最小传输时延_200_图论单源最短路径dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] times = new int[m][3];
        for (int i = 0; i < m; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
            times[i][2] = sc.nextInt();
        }

        int src = sc.nextInt();
        int dist = sc.nextInt();

        System.out.println(getResult(n, times, src, dist));
    }

    public static int getResult(int n, int[][] times, int src, int tar) {
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[] {v, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        ArrayList<Integer> needCheck = new ArrayList<>();
        while (true) {
            boolean flag = false;

            if (graph.containsKey(src)) {
                for (int[] next : graph.get(src)) {
                    int v = next[0], w = next[1];
                    int newDist = dist[src] + w;

                    if (newDist >= dist[v]) {
                        break;
                    }
                    dist[v] = newDist;

                    if (!needCheck.contains(v)) {
                        needCheck.add(v);
                        flag = true;
                    }
                }
            }

            if (needCheck.size() == 0) {
                break;
            }

            if (flag) {
                needCheck.sort((a, b) -> dist[a] - dist[b]);
            }

            src = needCheck.remove(0);
        }

        return dist[tar] == Integer.MAX_VALUE ? -1 : dist[tar];
    }
}
