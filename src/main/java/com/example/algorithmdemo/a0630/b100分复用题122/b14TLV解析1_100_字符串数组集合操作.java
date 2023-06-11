package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b14TLV解析1_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127944457
 *
 * @date: 2023/6/4 8:50
 * @version: V-1.0
 */
public class b14TLV解析1_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String target = sc.nextLine();
        String[] stream = sc.nextLine().split(" ");

        System.out.println(getResult(stream, target));
    }

    public static String getResult(String[] stream, String target) {
        int i = 0;

        while (i < stream.length) {
            String tag = stream[i++];

            String tmp1 = stream[i++];
            String tmp2 = stream[i++];

            int len = Integer.parseInt(tmp2 + tmp1, 16);

            ArrayList<String> val = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                val.add(stream[i++]);
            }

            if (tag.equals(target)) {
                StringJoiner sj = new StringJoiner(" ");
                for (String s : val) {
                    sj.add(s);
                }
                return sj.toString();
            }
        }

        return null;
    }
}
