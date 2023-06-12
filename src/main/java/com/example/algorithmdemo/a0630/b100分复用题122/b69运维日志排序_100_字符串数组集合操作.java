package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b69运维日志排序_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/126003757

 * @date: 2023/6/4 9:27
 * @version: V-1.0
 */
public class b69运维日志排序_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] logs = new String[n];
        for (int i = 0; i < n; i++) {
            logs[i] = sc.nextLine();
        }

        getResult(logs);
    }

    private static void getResult(String[] logs) {
        Arrays.sort(logs, (a, b) -> (int) (convet(a) - convet(b)));

        for (String log : logs) {
            System.out.println(log);
        }
    }

    private static long convet(String log) {
        String reg = "(\\d+):(\\d+):(\\d+).(\\d+)";

        Matcher matcher = Pattern.compile(reg).matcher(log);

        if (matcher.find()) {
            long H = Long.parseLong(matcher.group(1)) * 60 * 60 * 1000;
            long M = Long.parseLong(matcher.group(2)) * 60 * 1000;
            long S = Long.parseLong(matcher.group(3)) * 1000;
            long N = Long.parseLong(matcher.group(4));
            return H + M + S + N;
        } else {
            return 0;
        }
    }
}
