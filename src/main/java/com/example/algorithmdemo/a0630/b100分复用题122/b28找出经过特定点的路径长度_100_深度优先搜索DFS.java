package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b28找出经过特定点的路径长度_100_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127946640

 * @date: 2023/6/4 8:56
 * @version: V-1.0
 */
public class b28找出经过特定点的路径长度_100_深度优先搜索DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String all = sc.next();
        String must = sc.next();

        System.out.println(getResult(all, must));
    }

    private static int getResult(String all, String must) {
        HashMap<Character, ArrayList<Integer>> mustCharIdx = new HashMap<>();

        HashSet<Character> mustChar = new HashSet<>();
        for (char c : must.toCharArray()) {
            mustChar.add(c);
        }

        for (int i = 0; i < all.length(); i++) {
            char c = all.charAt(i);
            if (mustChar.contains(c)) {
                mustCharIdx.putIfAbsent(c, new ArrayList<>());
                mustCharIdx.get(c).add(i);
            }
        }

        int[] ans = {Integer.MAX_VALUE};
        dfs(0, must, mustCharIdx, new LinkedList<>(), ans);
        return ans[0];
    }

    private static void dfs(
            int index,
            String must,
            HashMap<Character, ArrayList<Integer>> mustCharIdx,
            LinkedList<Integer> path,
            int[] ans) {
        if (path.size() == must.length()) {
            // 运动起点必须从第一行输入all的第一个字母开始
            int dis = path.get(0);
            // int dis = 0; // 运动起点从all中must第一个字母位置开始
            for (int i = 1; i < path.size(); i++) {
                dis += Math.abs(path.get(i) - path.get(i - 1));
            }
            ans[0] = Math.min(ans[0], dis);
            return;
        }

        for (int i = index; i < must.length(); i++) {
            ArrayList<Integer> idxs = mustCharIdx.get(must.charAt(i));
            for (Integer idx : idxs) {
                path.add(idx);
                dfs(i + 1, must, mustCharIdx, path, ans);
                path.removeLast();
            }
        }
    }
}
