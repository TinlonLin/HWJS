package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b46ABR车路协同场景_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127971131

 * @date: 2023/6/4 9:05
 * @version: V-1.0
 */
public class b46ABR车路协同场景_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Matcher m = Pattern.compile("A=\\{(.+)},B=\\{(.+)},R=(.+)").matcher(s);

        if (m.matches()) {
            Integer[] A =
                    Arrays.stream(m.group(1).split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer[] B =
                    Arrays.stream(m.group(2).split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer R = Integer.parseInt(m.group(3));
            System.out.println(getResult(A, B, R));
        }
    }

    private static String getResult(Integer[] A, Integer[] B, Integer R) {
        ArrayList<String> ans = new ArrayList<>();
        int start = 0;

        for (int a : A) {
            boolean isFind = false;
            for (int j = 0; j < B.length; j++) {
                int b = B[j];
                if (b >= a && B[start] < a) {
                    start = j;
                }

                if (a + R == b) {
                    ans.add("(" + a + "," + b + ")");
                    isFind = true;
                    break;
                }
            }

            if (!isFind && B[start] >= a) ans.add("(" + a + "," + B[start] + ")");
        }

        StringBuilder sb = new StringBuilder();
        for (String an : ans) {
            sb.append(an);
        }
        return sb.toString();
    }
}
