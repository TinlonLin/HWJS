package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b73磁盘容量排序_100_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127417798

 * @date: 2023/6/4 9:29
 * @version: V-1.0
 */
public class b73磁盘容量排序_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] capacitys = new String[n];
        for (int i = 0; i < n; i++) {
            capacitys[i] = sc.next();
        }

        getResult(n, capacitys);
    }

    private static void getResult(int n, String[] capacitys) {
        Arrays.sort(capacitys, (a, b) -> calc(a) - calc(b));
        for (String capacity : capacitys) {
            System.out.println(capacity);
        }
    }

    private static int calc(String capacity) {
        int ans = 0;

        StringBuilder num = new StringBuilder();
        for (int i = 0; i < capacity.length(); i++) {
            char c = capacity.charAt(i);

            if (c >= '0' && c <= '9') {
                num.append(c);
            } else {
                switch (c) {
                    case 'M':
                        ans += Integer.parseInt(num.toString());
                        break;
                    case 'G':
                        ans += Integer.parseInt(num.toString()) * 1024;
                        break;
                    case 'T':
                        ans += Integer.parseInt(num.toString()) * 1024 * 1024;
                        break;
                }

                num = new StringBuilder();
            }
        }

        return ans;
    }
}
