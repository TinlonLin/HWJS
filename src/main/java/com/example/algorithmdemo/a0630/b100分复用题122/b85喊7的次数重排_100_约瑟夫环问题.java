package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b85喊7的次数重排_100_约瑟夫环问题
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127247293

 * @date: 2023/6/4 9:36
 * @version: V-1.0
 */
public class b85喊7的次数重排_100_约瑟夫环问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    private static String getResult(Integer[] arr) {
        // totalGo表示一共喊了多少次过
        int totalGo = Arrays.stream(arr).reduce(Integer::sum).orElse(0);

        // n表示一共几个人
        int n = arr.length;
        // p[i]表示每个人喊了几次过，初始为0
        int[] p = new int[n];

        // go保存含有7的数字，或者是7倍数的数字
        ArrayList<Integer> go = new ArrayList<>();

        int i = 7;
        while (go.size() != totalGo) {
            if (i % 7 == 0 || (i + "").contains("7")) {
                go.add(i);
            }
            i++;
        }

        for (Integer idx : go) {
            p[idx % n - 1]++;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int v : p) {
            sj.add(v + "");
        }
        return sj.toString();
    }
}
