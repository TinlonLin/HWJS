package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b122整数编码_100_字符串数组集合操作
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130726480

 * @date: 2023/6/4 9:51
 * @version: V-1.0
 */
public class b122整数编码_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLong()));
    }

    private static String getResult(long num) {
        String bin = Long.toBinaryString(num);

        StringBuilder ans = new StringBuilder();

        int end = bin.length();
        while (end - 7 > 0) {
            ans.append(getHexString("1" + bin.substring(end - 7, end)));
            end -= 7;
        }

        if (end >= 0) {
            ans.append(getHexString(bin.substring(0, end)));
        }

        return ans.toString();
    }

    private static String getHexString(String binStr) {
        String hexStr = Integer.toHexString(Integer.parseInt(binStr, 2));
        if (hexStr.length() == 1) {
            hexStr = "0" + hexStr;
        }
        return hexStr.toUpperCase();
    }
}
