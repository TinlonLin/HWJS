package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b24计算最大乘积_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127946085

 * @date: 2023/6/4 8:55
 * @version: V-1.0
 */
public class b24计算最大乘积_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        System.out.println(getResult(strings));
    }

    private static int getResult(String[] arr) {
        ArrayList<HashSet<Character>> list = new ArrayList<>();

        for (String s : arr) {
            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            list.add(set);
        }

        int ans = 0;

        for (int i = 0; i < list.size(); i++) {
            HashSet<Character> a = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                HashSet<Character> b = list.get(j);
                if (Collections.disjoint(a, b)) {
                    ans = Math.max(ans, arr[i].length() * arr[j].length());
                }
            }
        }

        return ans;
    }
}
