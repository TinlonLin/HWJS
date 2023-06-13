package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b38服务失效判断_200_数据结构并查集
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711105

 * @date: 2023/6/4 10:05
 * @version: V-1.0
 */
public class b38服务失效判断_200_数据结构并查集 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] relations =
                Arrays.stream(sc.nextLine().split(",")).map(s -> s.split("-")).toArray(String[][]::new);

        String[] breakdowns = sc.nextLine().split(",");

        System.out.println(getResult(relations, breakdowns));
    }

    public static String getResult(String[][] relations, String[] breakdowns) {
        HashMap<String, HashSet<String>> next = new HashMap<>(); // 属性是父服务，属性值是子服务集合
        HashMap<String, Integer> first = new HashMap<>(); // 记录服务第一次出现的位置

        int i = 0;
        for (String[] relation : relations) {
            String c = relation[0];
            String f = relation[1];

            next.putIfAbsent(c, new HashSet<>());
            next.putIfAbsent(f, new HashSet<>());

            next.get(f).add(c);

            first.putIfAbsent(c, i++);
            first.putIfAbsent(f, i++);
        }

        for (String s : breakdowns) {
            remove(next, s);
        }

        String[] ans = next.keySet().toArray(new String[0]);
        if (ans.length == 0) return ",";

        Arrays.sort(ans, (a, b) -> first.get(a) - first.get(b));
        StringJoiner sj = new StringJoiner(",");
        for (String an : ans) {
            sj.add(an);
        }
        return sj.toString();
    }

    // 由于服务s是故障服务，因此s服务本身，和其所有子孙服务都无法运行
    public static void remove(HashMap<String, HashSet<String>> next, String s) {
        if (next.containsKey(s)) {
            HashSet<String> need_remove = next.get(s);
            next.remove(s);

            for (String ss : need_remove) {
                remove(next, ss);
            }
        }
    }
}
