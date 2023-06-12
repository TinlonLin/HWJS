package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b18非严格递增连续数字序列_100_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418433

 * @date: 2023/6/4 8:52
 * @version: V-1.0
 */
public class b18非严格递增连续数字序列_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(getResult(s));
    }

    private static int getResult(String s) {
        int l = 0;
        int r = 0;
        int maxLen = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (c >= '0' && c <= '9') {
                if (l != r) {
                    if (c >= s.charAt(r - 1)) {
                        maxLen = Math.max(maxLen, r - l + 1);
                    } else {
                        maxLen = Math.max(maxLen, r - l);
                        l = r;
                    }
                    r++;
                } else {
                    maxLen = Math.max(maxLen, 1);
                    r++;
                }
            } else {
                maxLen = Math.max(maxLen, r - l);
                r++;
                l = r;
            }
        }

        return maxLen;
    }
}
