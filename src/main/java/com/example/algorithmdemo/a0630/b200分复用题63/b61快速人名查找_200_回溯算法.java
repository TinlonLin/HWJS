package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b61快速人名查找_200_回溯算法
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128192439

 * @date: 2023/6/4 10:17
 * @version: V-1.0
 */
public class b61快速人名查找_200_回溯算法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split(",");
        String abbr = sc.nextLine();

        System.out.println(getResult(names, abbr));
    }

    public static String getResult(String[] names, String abbr) {
        ArrayList<String> ans = new ArrayList<>();

        for (String name : names) {
            String[] parts = name.split(" ");
            if (parts.length > abbr.length()) {
                continue;
            }

            boolean res = dfs(parts, 0, abbr, 0);
            if (res) {
                ans.add(name);
            }
        }

        StringJoiner sj = new StringJoiner(",");
        for (String an : ans) {
            sj.add(an);
        }
        return sj.toString();
    }

    public static boolean dfs(String[] parts, int index, String abbr, int start) {
        if (start >= abbr.length()) {
            return index >= parts.length;
        }

        for (int i = index; i < parts.length; i++) {
            String part = parts[i];

            for (int j = 0; j < part.length(); j++) {
                if (start < abbr.length() && part.charAt(j) == abbr.charAt(start)) {
                    boolean res = dfs(parts, i + 1, abbr, ++start);
                    if (res) return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }
}
