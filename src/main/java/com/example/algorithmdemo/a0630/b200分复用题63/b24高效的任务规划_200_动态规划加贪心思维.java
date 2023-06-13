package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b24高效的任务规划_200_动态规划加贪心思维
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128179380

 * @date: 2023/6/4 10:00
 * @version: V-1.0
 */
public class b24高效的任务规划_200_动态规划加贪心思维 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int[][][] tasks = new int[m][][];

        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            int[][] task = new int[n][2];
            for (int j = 0; j < n; j++) {
                task[j][0] = sc.nextInt();
                task[j][1] = sc.nextInt();
            }
            tasks[i] = task;
        }

        getResult(tasks);
    }

    // 算法入口
    private static void getResult(int[][][] tasks) {
        for (int[][] task : tasks) {
            // 将每个任务中的机器工作顺序，按照运行时间降序排序
            Arrays.sort(task, (a, b) -> b[1] - a[1]);

            int n = task.length;

            //  dp[i]表示第i个机器完成工作的最少用时
            int[] dp = new int[n];
            dp[0] = task[0][0] + task[0][1];

            // 下面这段逻辑情况题解图示
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 1] - task[i - 1][1] + task[i][0] + task[i][1]);
            }

            System.out.println(dp[n - 1]);
        }
    }
}
