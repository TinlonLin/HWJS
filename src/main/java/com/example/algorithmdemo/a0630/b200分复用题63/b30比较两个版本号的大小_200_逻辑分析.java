package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b30比较两个版本号的大小_200_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128179974

 * @date: 2023/6/4 10:02
 * @version: V-1.0
 */
public class b30比较两个版本号的大小_200_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String v1 = sc.next();
        String v2 = sc.next();

        System.out.println(getResult(v1, v2));
    }

    // 算法入口
    public static int getResult(String v1, String v2) {
        String[] arr1 = convert(v1);
        String[] arr2 = convert(v2);

        int n = Math.max(arr1.length, arr2.length);

        for (int i = 0; i < n; i++) {
            String tmp1 = arr1.length > i ? arr1[i] : "0";
            String tmp2 = arr2.length > i ? arr2[i] : "0";

            try {
                int i1 = Integer.parseInt(tmp1);
                int i2 = Integer.parseInt(tmp2);
                if (i1 != i2) return i1 > i2 ? 1 : -1;
            } catch (Exception e) {
                int res = tmp1.compareTo(tmp2);
                if (res != 0) return res > 0 ? 1 : -1;
            }
        }

        return 0;
    }

    public static String[] convert(String version) {
        // 注意split方法入参会被当成正则，因此这里不能直接使用"."，因为"."在正则中是元字符，有特殊含义，我们应该使用转义后的"\\."
        return Arrays.stream(version.split("\\."))
                .map(
                        sub -> {
                            String s = sub.replaceAll("^0+", ""); // 去除前导0
                            return "".equals(s) ? "0" : s; // 如果是"0"，去除前导0后就变为了""，需要做特殊处理
                        })
                .toArray(String[]::new);
    }
}
