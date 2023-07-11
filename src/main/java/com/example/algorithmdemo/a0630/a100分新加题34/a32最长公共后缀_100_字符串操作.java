package com.example.algorithmdemo.a0630.a100分新加题34;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/11 23:43
 * @ClassName: a32最长公共后缀_100_字符串操作
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/131021419?spm=1001.2014.3001.5502
题目描述
编写一个函数来查找字符串数组中的最长公共后缀；
如果不存在公共后缀，返回固定字符串： @Zero。
补充说明：
字符串长度范围：[2, 1000]
字符串中字符取值范围为[1, 126]
输入描述
无
输出描述
无

用例
输入
["abc","bbc","c"]
输出
"c"
说明
返回公共后缀: c

 * @Version: V-1.0
 */
public class a32最长公共后缀_100_字符串操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] strings =
                Arrays.stream(line.substring(1, line.length() - 1).split(","))
                        .map(s -> s.substring(1, s.length() - 1))
                        .toArray(String[]::new);

        System.out.println(getResult(strings));
    }

    public static String getResult(String[] strings) {
        // 假设第0个字符串就是最长公共后缀
        String suffix = strings[0];

        // 从第1个字符串开始，求解和最长公共后缀suffix的最长公共后置
        for (int i = 1; i < strings.length; i++) {
            suffix = getLCS(suffix, strings[i]);

            // 如果最长公共后缀为“”,则直接返回"@Zero"
            if ("".equals(suffix)) return "@Zero";
        }

        return suffix;
    }

    /**
     * 求两个字符串的最长公共后缀
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 两个字符串的最长公共后缀
     */
    public static String getLCS(String s1, String s2) {
        // 如果尾字符不同，则没有公共后缀
        if (charAt(s1, -1) != charAt(s2, -1)) return "";

        // 最长公共后缀的长度上限是：两个字符串中较短的那个的长度值
        int maxLen = Math.min(s1.length(), s2.length());

        // 开始逐位比较
        for (int i = -2; i >= -maxLen; i--) {
            // 如果某位对应字符不同,则该位后面的就是最长公共后缀
            if (charAt(s1, i) != charAt(s2, i)) return s1.substring(s1.length() + i + 1);
        }

        // 如果比较完了，都没有发现对应位不同字符，则说明，两个字符串中较短者本身就是最长公共后缀
        return s1.substring(s1.length() - maxLen);
    }

    // 负数索引找字符，比如索引-1  等价于 索引s.length-1
    public static char charAt(String s, int negativeIndex) {
        return s.charAt(s.length() + negativeIndex);
    }
}
