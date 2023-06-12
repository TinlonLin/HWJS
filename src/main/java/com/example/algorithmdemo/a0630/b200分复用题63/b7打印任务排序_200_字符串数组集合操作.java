package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b7打印任务排序_200_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127209862

 * @date: 2023/6/4 9:54
 * @version: V-1.0
 */
public class b7打印任务排序_200_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] priority =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int n = priority.length;

        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            // 优先级，初始序号
            tasks[i] = new int[] {priority[i], i};
        }

        // 按照优先级排序
        Arrays.sort(tasks, (a, b) -> b[0] - a[0]);

        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            // 将 排序序号 对应到 初始序号上
            ids[tasks[i][1]] = i;
        }

        StringJoiner sj = new StringJoiner(",");
        for (int id : ids) {
            sj.add(id + "");
        }
        System.out.println(sj);
    }
}
