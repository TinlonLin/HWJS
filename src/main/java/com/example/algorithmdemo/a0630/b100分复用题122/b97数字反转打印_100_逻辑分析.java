package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b97数字反转打印_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418133

 * @date: 2023/6/4 9:41
 * @version: V-1.0
 */
public class b97数字反转打印_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getResult(n);
    }

    private static void getResult(int n) {
        // 每行要打印的数，起始为第一行第一个数1
        int print = 1;

        for (int i = 1; i <= n; i++) {
            // 多少行
            int[] printList = new int[i];
            for (int j = 0; j < i; j++) {
                // 每行多少个数
                printList[j] = print++;
            }

            if (i % 2 == 0) reverse(printList);
            // 如果是偶数行，则逆序

            StringJoiner printListStr = new StringJoiner("    ");
            for (int ele : printList) {
                StringBuilder sb = new StringBuilder(ele + "");
                while (sb.length() < 4) sb.append("*");
                // 如果数字不足4位则后面用*补足
                printListStr.add(sb);
            }

            StringBuilder res = new StringBuilder(printListStr.toString());
            for (int k = 0; k < n - i; k++) {
                res.insert(0, "    ");
                // 每行的缩进
            }
            System.out.println(res);
        }
    }

    private static void reverse(int[] printList) {
        int l = 0;
        int r = printList.length - 1;

        while (l < r) {
            int tmp = printList[l];
            printList[l] = printList[r];
            printList[r] = tmp;
            l++;
            r--;
        }
    }
}
