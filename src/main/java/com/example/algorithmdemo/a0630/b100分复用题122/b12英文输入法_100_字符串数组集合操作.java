package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b12英文输入法_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418419

 * @date: 2023/6/4 8:50
 * @version: V-1.0
 */
public class b12英文输入法_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pre = sc.nextLine();
        System.out.println(getResult(str, pre));
    }

    private static String getResult(String str, String pre) {
        String[] tmp = str.split("[^a-zA-Z]");
        TreeSet<String> cache = new TreeSet<>();
        Collections.addAll(cache, tmp);

        StringJoiner sj = new StringJoiner(" ");
        cache.stream().filter(s -> s.startsWith(pre)).forEach(s -> sj.add(s));

        String ans = sj.toString();
        if (ans.length() > 0) {
            return ans;
        } else {
            return pre;
        }
    }
}
