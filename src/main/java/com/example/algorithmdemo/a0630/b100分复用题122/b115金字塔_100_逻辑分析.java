package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b115金字塔_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128052725

 * @date: 2023/6/4 9:48
 * @version: V-1.0
 */
public class b115金字塔_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        System.out.println(getResult(arr));
    }

    private static String getResult(int[][] arr) {
        HashMap<Integer, Integer> agent = new HashMap<>();

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        int first = arr[arr.length - 1][1];

        for (int[] ele : arr) {
            int id = ele[0];
            int preId = ele[1];
            int money = ele[2];

            if (agent.containsKey(id)) money += agent.get(id);
            agent.put(preId, agent.getOrDefault(preId, 0) + money / 100 * 15);
        }

        return first + " " + agent.get(first);
    }
}
