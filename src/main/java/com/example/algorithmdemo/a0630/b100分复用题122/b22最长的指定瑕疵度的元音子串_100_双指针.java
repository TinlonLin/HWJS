package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b22最长的指定瑕疵度的元音子串_100_双指针
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711201

 * @date: 2023/6/4 8:54
 * @version: V-1.0
 */
public class b22最长的指定瑕疵度的元音子串_100_双指针 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int flaw = sc.nextInt();
        String s = sc.next();

        System.out.println(getResult(flaw, s));
    }

    private static int getResult(int flaw, String s) {
        char[] yuan = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> set = new HashSet<>();
        for (char c : yuan) {
            set.add(c);
        }

        ArrayList<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                idxs.add(i);
            }
        }

        int ans = 0;
        int n = idxs.size();

        int l = 0;
        int r = 0;

        int diff; // diff保存 瑕疵度
        while (r < n) {
            // 瑕疵度计算
            if (r - l == idxs.get(r) - idxs.get(l)) {
                diff = 0;
            } else {
                diff = idxs.get(r) - idxs.get(l) - (r - l);
            }

            if (diff > flaw) {
                l++;
            } else if (diff < flaw) {
                r++;
            } else {
                ans = Math.max(ans, idxs.get(r) - idxs.get(l) + 1);
                r++;
            }
        }

        return ans;
    }
}
