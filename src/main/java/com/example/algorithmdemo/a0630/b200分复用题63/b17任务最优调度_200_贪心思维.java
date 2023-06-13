package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b17任务最优调度_200_贪心思维
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128173501

 * @date: 2023/6/4 9:58
 * @version: V-1.0
 */
public class b17任务最优调度_200_贪心思维 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.next().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        int wait = sc.nextInt();

        System.out.println(getResult(arr, wait));
    }

    private static int getResult(Integer[] arr, int wait) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (Integer t : arr) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }

        ArrayList<Integer[]> tasks = new ArrayList<>();
        for (Integer t : count.keySet()) {
            tasks.add(new Integer[] {count.get(t), 0});
        }

        tasks.sort((a, b) -> b[0] - a[0]);

        int total = arr.length;
        int time = 0;

        while (total > 0) {
            time++;
            boolean flag = true;
            for (Integer[] task : tasks) {
                if (flag && task[0] > 0 && task[1] == 0) {
                    flag = false;
                    task[0]--;
                    total--;
                    task[1] = wait;
                } else {
                    if (task[1] > 0) {
                        task[1]--;
                    }
                }
            }
        }

        return time;
    }
}
