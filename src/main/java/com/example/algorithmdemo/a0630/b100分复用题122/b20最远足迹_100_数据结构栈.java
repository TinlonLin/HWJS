package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b20最远足迹_100_数据结构栈
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418477
 *
 * @date: 2023/6/4 8:53
 * @version: V-1.0
 */
public class b20最远足迹_100_数据结构栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static String getResult(String s) {
        int maxFar = 0;
        String ans = "(0,0)";

        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                l = i + 1;
            } else if (c == ')') {
                String[] pos = s.substring(l, i).split(",");

                if (pos[0].charAt(0) == '0' || pos[1].charAt(0) == '0') continue;

                int x = Integer.parseInt(pos[0]);
                int y = Integer.parseInt(pos[1]);

                if (x <= 0 || x >= 1000 || y <= 0 || y >= 1000) {
                    continue;
                }

                int far = x * x + y * y;
                if (far > maxFar) {
                    maxFar = far;
                    ans = "(" + x + "," + y + ")";
                }
            }
        }

        return ans;
    }
}
