package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b23考勤信息_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127944519

 * @date: 2023/6/4 8:54
 * @version: V-1.0
 */
public class b23考勤信息_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[][] records = new String[n][];
        for (int i = 0; i < n; i++) {
            records[i] = sc.nextLine().split(" ");
        }

        getResult(n, records);
    }

    private static void getResult(int n, String[][] records) {
        for (int i = 0; i < n; i++) {
            System.out.println(isAward(records[i]));
        }
    }

    private static boolean isAward(String[] record) {
        int absent = 0;
        int present = 0;

        // pre用于记录前一次考勤
        String pre = "";

        for (int i = 0; i < record.length; i++) {
            // cur用于记录本次考勤
            String cur = record[i];

            switch (cur) {
                case "absent":
                    // 缺勤超过1次，则拿不到全勤奖
                    if (++absent > 1) return false;
                    break;
                case "late":
                case "leaveearly":
                    // 连续早退/迟到，则拿不到全勤奖
                    if ("late".equals(pre) || "leaveearly".equals(pre)) return false;
                    break;
                case "present":
                    present++;
            }

            pre = cur;

            // 连续7次考勤，可以看出滑窗，即滑窗长度为7，初始滑窗的左边界为0，右边界为6
            if (i >= 6) {
                // 如果滑窗内部present次数少于4，那么说明迟到，早退，缺勤的总和次数 > 3，此时就拿不到全勤奖，因为：连续7次考勤，缺勤/迟到/早退不超过3次。
                if (present < 4) {
                    return false;
                }

                // 滑窗左边界右移一个，如果失去的record[i - 6]是present，则滑窗内部present数量--
                if ("present".equals(record[i - 6])) {
                    present--;
                }
            }
        }

        return true;
    }
}
