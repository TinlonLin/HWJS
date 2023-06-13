package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b55跳格子游戏_200_图论拓扑排序
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127710834

 * @date: 2023/6/4 10:14
 * @version: V-1.0
 */
public class b55跳格子游戏_200_图论拓扑排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Integer[]> relations = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if ("".equals(line)) break; // 题目没有说输入终止条件，因此我这里将输入空行作为终止条件
            relations.add(Arrays.stream(line.split(" ")).map(Integer::parseInt).toArray(Integer[]::new));
        }

        System.out.println(getResult(n, relations));
    }

    private static String getResult(int n, ArrayList<Integer[]> relations) {
        int[] inDegree = new int[n];
        HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();

        for (Integer[] relation : relations) {
            int a = relation[0], b = relation[1];
            inDegree[b]++;
            next.putIfAbsent(a, new ArrayList<>());
            next.get(a).add(b);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                stack.add(i);
            }
        }

        int count = 0;
        while (stack.size() > 0) {
            int a = stack.removeLast();
            count++;

            if (next.containsKey(a)) {
                for (int b : next.get(a)) {
                    if (--inDegree[b] == 0) {
                        stack.add(b);
                    }
                }
            }
        }

        return count == n ? "yes" : "no";
    }
}
