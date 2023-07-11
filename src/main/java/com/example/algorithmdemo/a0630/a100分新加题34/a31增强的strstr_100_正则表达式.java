package com.example.algorithmdemo.a0630.a100分新加题34;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/10 22:52
 * @ClassName: a31增强的strstr_100_正则表达式
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/131389464?spm=1001.2014.3001.5502
题目描述
C 语言有一个库函数： char *strstr (const char *haystack, const char *needle) ，
实现在字符串 haystack 中查找第一次出现字符串 needle 的位置，如果未找到则返回 null。
现要求实现一个strstr的增强函数，可以使用带可选段的字符串来 模糊查询，与strstr一样返回首次查找到的字符串位置。
可选段使用“[]”标识，表示该位置是可选段中任意一个字符即可满足匹配条件。比如“a[bc]”表示可以匹配“ab”或“ac”。
 * @Version: V-1.0
 */
public class a31增强的strstr_100_正则表达式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String src = sc.nextLine();
        String tar = sc.nextLine();

        System.out.println(getResult(src, tar));
    }

    public static int getResult(String src, String tar) {
        Matcher matcher = Pattern.compile(tar).matcher(src);

        if (matcher.find()) {
            return src.indexOf(matcher.group());
        } else {
            return -1;
        }
    }
}
