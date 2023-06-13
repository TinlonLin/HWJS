package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b40猜密码_200_深度优先搜索DFS
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127686582

 * @date: 2023/6/4 10:08
 * @version: V-1.0
 */
public class b40猜密码_200_深度优先搜索DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(",");
        int level = Integer.parseInt(sc.nextLine());
        getResult(arr, level);
    }

    public static void getResult(String[] arr, int level) {
        Arrays.sort(arr);

        ArrayList<String> res = new ArrayList<>();
        dfs(arr, 0, level, new LinkedList<>(), res);

        if (res.size() > 0) {
            for (String v : res) {
                System.out.println(v);
            }
        } else {
            System.out.println("None");
        }
    }

    public static void dfs(
            String[] arr, int index, int level, LinkedList<String> path, ArrayList<String> res) {
        if (path.size() >= level) {
            StringJoiner sj = new StringJoiner(",");
            for (String v : path) {
                sj.add(v);
            }
            res.add(sj.toString());
        }

        for (int i = index; i < arr.length; i++) {
            path.add(arr[i]);
            dfs(arr, i + 1, level, path, res);
            path.removeLast();
        }
    }
}
