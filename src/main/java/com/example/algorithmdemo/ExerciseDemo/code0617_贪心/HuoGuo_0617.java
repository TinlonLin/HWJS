package com.example.algorithmdemo.ExerciseDemo.code0617_贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: HuoGuo_0617
 * @desc: 火锅
 * https://blog.csdn.net/ximaiyao1984/article/details/125003620
 * 入职后，导师会请你吃饭，你选择了火锅。
 * 火锅里会在不同时间下很多菜。
 * 不同食材要煮不同的时间，才能变得刚好合适。你希望吃到最多的刚好合适的菜，但你的手速不够快，
 * 用m代表手速，每次下手捞菜后至少要过m秒才能在捞（每次只能捞一个）。
 * 那么用最合理的策略，最多能吃到多少刚好合适的菜？
 *
 * 输入描述：
 * 第一行两个整数n，m，其中n代表往锅里下的菜的个数，m代表手速。
 * 接下来有n行，每行有两个数x，y代表第x秒下的菜过y秒才能变得刚好合适。
 * （1 < n, m < 1000）
 * （1 < x, y < 1000）
 *
 * 输出描述：
 * 输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量
输入：
2 1
1 2
2 1
输出:
1
 *
 * @date: 2022/6/16 9:35 下午
 * @version: V-1.0
 */
public class HuoGuo_0617 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            // 设置一个数组，存放每道菜可以吃到的时间。
            int[] arrTime = new int[n];
            for (int i = 0; i < n; i++) {
                arrTime[i] = x[i] + y[i];
            }
            // 对数组进行从小到大进行排序，这样便于后面比较计算
            Arrays.sort(arrTime);

            // 新建一个数组，和数组arrTime对应，用于记录每道菜是否可以吃到，可以吃到标记加1.
            int[] arrCount = new int[n];

            int next = 0;
            arrCount[0] = 1;
            for (int i = 1; i < n; i++) {
                if (arrTime[i] >= (arrTime[next] + m)) {
                    arrCount[i] = 1;
                    next = i;
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arrCount[i] > 0) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

}
