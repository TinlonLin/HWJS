package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b48最小传输时延2_200_深度优先搜索DFS
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/128192306

 * @date: 2023/6/4 10:11
 * @version: V-1.0
 */
public class b48最小传输时延2_200_深度优先搜索DFS {
    static int[][] matrix;
    static int m;
    static int n;

    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(matrix));
    }

    private static int getResult(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> path = new HashSet<>();
        path.add(0);

        dfs(0, 0, 0, Integer.MAX_VALUE, path, res);

        return res.stream().min((a, b) -> a - b).get();
    }

    /**
     * @param i 当前正在被dfs的节点的横坐标
     * @param j 当前正在被dfs的节点的纵坐标
     * @param delay 已累计的时延值
     * @param last 上一个节点的时延值，用于和当前节点时延值对比，若相同，则新增时延-1
     * @param path 记录扫描过的节点的位置，避免重复扫描
     * @param res 记录各种从起点到终点的路径的时延值
     */
    private static void dfs(
            int i, int j, int delay, int last, HashSet<Integer> path, ArrayList<Integer> res) {
        // 当前节点的时延值
        int cur = matrix[i][j];

        // flag用于标记，当前节点和上一个节点的时延值是否相同，若相同，则新增的时延值要-1
        boolean flag = cur == last;

        // 如果搜索到了最后一个点，那么就将该路径的时延计算出来，加入到res中，结束分支递归
        if (i == m - 1 && j == n - 1) {
            delay += cur - (flag ? 1 : 0);
            res.add(delay);
            return;
        }

        // 深度优先搜索当前点的八个方向
        for (int[] offset : offsets) {
            int newI = i + offset[0];
            int newJ = j + offset[1];

            // 将二维坐标，转成一维坐标pos
            int pos = newI * m + newJ;

            // 如果新位置越界，或者新位置已经扫描过，则停止递归
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !path.contains(pos)) {
                path.add(pos);
                dfs(
                        newI,
                        newJ,
                        // 当前节点和上一个节点的时延值是否相同，若相同，则新增的时延值要-1
                        delay + cur - (flag ? 1 : 0),
                        cur,
                        path,
                        res);
                path.remove(pos);
            }
        }
    }
}
