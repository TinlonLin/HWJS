package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b2考古学家_200_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711587

 * @date: 2023/6/4 9:52
 * @version: V-1.0
 */
public class b2考古学家_200_深度优先搜索DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr);

        HashSet<String> set = new HashSet<>();
        dfs(arr, n, new boolean[n], new LinkedList<>(), set);
    }

    private static void dfs(
            String[] arr, int n, boolean[] used, LinkedList<String> path, HashSet<String> set) {
        if (path.size() == n) {
            StringBuilder sb = new StringBuilder();

            for (String node : path) {
                sb.append(node);
            }

            String ans = sb.toString();

            // 结果去重
            if (!set.contains(ans)) {
                System.out.println(ans);
                set.add(ans);
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i].equals(arr[i - 1]) && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                path.addLast(arr[i]);
                used[i] = true;
                dfs(arr, n, used, path, set);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
