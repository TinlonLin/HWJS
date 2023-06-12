package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b92解密犯罪时间_100_深度优先搜索DFS
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127634016

 * @date: 2023/6/4 9:39
 * @version: V-1.0
 */
public class b92解密犯罪时间_100_深度优先搜索DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tmp = sc.nextLine().split(":");
        String hour = tmp[0];
        String minute = tmp[1];

        System.out.println(getResult(hour, minute));
    }

    public static String getResult(String hour, String minute) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < hour.length(); i++) {
            set.add(hour.charAt(i));
        }
        for (int i = 0; i < minute.length(); i++) {
            set.add(minute.charAt(i));
        }
        Character[] arr = set.toArray(new Character[0]);

        ArrayList<String> res = new ArrayList<>();
        dfs(arr, new LinkedList<>(), res);

        res.sort(String::compareTo);
        int index = res.indexOf(hour + minute);

        String recentTime;
        if (index == res.size() - 1) {
            recentTime = res.get(0);
        } else {
            recentTime = res.get(index + 1);
        }

        String[] split = recentTime.split("");
        split[1] += ":";
        return String.join("", split);
    }

    static Pattern p = Pattern.compile("(([01][0-9])|([2][0-3]))[0-5][0-9]");

    public static void dfs(Character[] arr, LinkedList<Character> path, ArrayList<String> res) {
        if (path.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (Character c : path) sb.append(c);
            String timeStr = sb.toString();

            if (p.matcher(timeStr).find()) {
                res.add(timeStr);
            }

            return;
        }

        for (Character c : arr) {
            path.add(c);
            dfs(arr, path, res);
            path.removeLast();
        }
    }
}
