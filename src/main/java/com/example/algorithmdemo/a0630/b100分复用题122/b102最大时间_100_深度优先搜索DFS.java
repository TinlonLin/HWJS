package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b102最大时间_100_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128028544

 * @date: 2023/6/4 9:43
 * @version: V-1.0
 */
public class b102最大时间_100_深度优先搜索DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Integer[] arr =
                Arrays.stream(s.substring(1, s.length() - 1).split(","))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    static Pattern c = Pattern.compile("(([01][0-9])|([2][0-3])):([0-5][0-9]):([0-5][0-9])");

    private static String getResult(Integer[] arr) {
        ArrayList<String> res = new ArrayList<>();
        dfs(arr, new boolean[arr.length], new LinkedList<>(), res);

        if (res.size() == 0) return "invalid";
        res.sort((a, b) -> b.compareTo(a));
        return res.get(0);
    }

    private static void dfs(
            Integer[] arr, boolean[] used, LinkedList<Integer> path, ArrayList<String> res) {
        if (path.size() == arr.length) {
            Integer[] t = path.toArray(new Integer[0]);
            String time = t[0] + "" + t[1] + ":" + t[2] + "" + t[3] + ":" + t[4] + "" + t[5];

            if (c.matcher(time).matches()) res.add(time);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                path.add(arr[i]);
                used[i] = true;
                dfs(arr, used, path, res);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
