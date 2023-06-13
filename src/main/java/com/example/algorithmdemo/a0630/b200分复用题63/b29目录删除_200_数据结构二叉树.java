package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b29目录删除_200_数据结构二叉树
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127710374

 * @date: 2023/6/4 10:02
 * @version: V-1.0
 */
public class b29目录删除_200_数据结构二叉树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int[][] relations = new int[m][2];
        for (int i = 0; i < m; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        int del = sc.nextInt();

        System.out.println(getResult(m, relations, del));
    }

    public static String getResult(int m, int[][] relations, int del) {
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();

        for (int[] relation : relations) {
            int child = relation[0];
            int father = relation[1];
            tree.putIfAbsent(father, new ArrayList<>());
            tree.get(father).add(child);
        }

        if (del == 0) {
            return "";
        }

        ArrayList<Integer> res = new ArrayList<>();
        dfs(tree, 0, del, res);

        res.sort((a, b) -> a - b);
        StringJoiner sj = new StringJoiner(" ");
        for (Integer v : res) {
            sj.add(v + "");
        }
        return sj.toString();
    }

    public static void dfs(
            HashMap<Integer, ArrayList<Integer>> tree, int node, int del, ArrayList<Integer> res) {
        if (tree.containsKey(node)) {
            ArrayList<Integer> children = tree.get(node);
            for (Integer child : children) {
                if (child != del) {
                    res.add(child);
                    dfs(tree, child, del, res);
                }
            }
        }
    }
}
