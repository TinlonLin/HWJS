package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b25完全二叉树非叶子部分后序遍历_200_数据结构二叉树
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128183646

 * @date: 2023/6/4 10:00
 * @version: V-1.0
 */
public class b25完全二叉树非叶子部分后序遍历_200_数据结构二叉树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    // 算法入口
    public static String getResult(Integer[] arr) {
        if (arr.length == 1) return arr[0] + "";

        ArrayList<Integer> res = new ArrayList<>();
        dfs(arr, 0, res);

        StringJoiner sj = new StringJoiner(" ");
        for (Integer re : res) {
            sj.add(re + "");
        }

        return sj.toString();
    }

    public static void dfs(Integer[] arr, int root, ArrayList<Integer> res) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        if (arr.length > left) {
            dfs(arr, left, res);
            if (arr.length > right) {
                dfs(arr, right, res);
            }
            res.add(arr[root]);
        }
    }

}
