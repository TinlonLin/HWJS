package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b107求最多可以派出多少支团队_100_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418310

 * @date: 2023/6/4 9:45
 * @version: V-1.0
 */
public class b107求最多可以派出多少支团队_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Integer[] capacities =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int minCap = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(n, capacities, minCap));
    }

    private static int getResult(int n, Integer[] capacities, int minCap) {
        if (capacities.length == 1) {
            return capacities[0] >= minCap ? 1 : 0;
        }

        Arrays.sort(capacities, (a, b) -> b - a);

        int l = 0;
        int r = capacities.length - 1;

        int maxTeamCount = 0;
        while (l < r) {
            if (capacities[l] >= minCap) {
                l++;
                maxTeamCount++;
            } else if (capacities[l] + capacities[r] >= minCap) {
                l++;
                r--;
                maxTeamCount++;
            } else {
                r--;
            }
        }

        return maxTeamCount;
    }
}
