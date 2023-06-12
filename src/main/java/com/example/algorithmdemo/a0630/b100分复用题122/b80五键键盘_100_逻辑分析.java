package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b80五键键盘_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418458

 * @date: 2023/6/4 9:34
 * @version: V-1.0
 */
public class b80五键键盘_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] commands = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(commands));
    }

    private static int getResult(int[] commands) {
        ArrayList<String> screen = new ArrayList<>();
        ArrayList<String> clip = new ArrayList<>();
        boolean isSelect = false;

        for (int command : commands) {
            switch (command) {
                case 1:
                    // a
                    if (isSelect) screen.clear();
                    screen.add("a");
                    isSelect = false;
                    break;
                case 2:
                    // ctrl-c
                    if (isSelect) {
                        clip.clear();
                        clip.addAll(screen);
                    }
                    break;
                case 3:
                    // ctrl-x
                    if (isSelect) {
                        clip.clear();
                        clip.addAll(screen);
                        screen.clear();
                        isSelect = false;
                    }
                    break;
                case 4:
                    // ctrl-v
                    if (isSelect) screen.clear();
                    screen.addAll(clip);
                    isSelect = false;
                    break;
                case 5:
                    // ctrl-a
                    if (screen.size() != 0) isSelect = true;
                    break;
            }
        }

        return screen.size();
    }
}
