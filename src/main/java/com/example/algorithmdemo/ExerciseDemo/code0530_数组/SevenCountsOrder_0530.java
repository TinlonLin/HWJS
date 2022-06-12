package com.example.algorithmdemo.ExerciseDemo.code0530_数组;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/5/30 0:17
 * @ClassName: SevenCountsOrder_0529
 * @Desc: 喊7的次数重排
 * https://wenku.baidu.com/view/9687c1df971ea76e58fafab069dc5022aaea46f4.html
 * @Version: V-1.0
 * 输入：
 * 0 1 0
 * 输出：
 * 1 0 0
 * 输入：
 * 0 0 0 2 1
 * 输出：
 * 0 2 0 1 0
 */
public class SevenCountsOrder_0530 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        int[] res = new int[split.length];

        int j = 0;
        for (int i = 1; i <= 200; i++, j++) {
            if (j == split.length) {
                j = 0;
            }
            if (i % 7 == 0 || (i + "").contains("7")) {
                res[j] += 1;
            }
            int sum1 = 0;
            for (int re : res) {
                sum1 += re;
            }
            if (sum == sum1) {
                break;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int re : res) {
            builder.append(re).append(" ");
        }

        String s = builder.toString();
        System.out.println(s.substring(0, s.length() - 1));

        sc.close();
    }
}
