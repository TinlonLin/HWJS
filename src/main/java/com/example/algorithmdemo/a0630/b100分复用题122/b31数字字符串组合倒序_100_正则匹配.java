package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b31数字字符串组合倒序_100_正则匹配
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127953928

 * @date: 2023/6/4 8:58
 * @version: V-1.0
 */
public class b31数字字符串组合倒序_100_正则匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(getResult(str));
    }

    private static String getResult(String str) {
        String reg1 = "[^0-9a-zA-Z\\-]";
        Pattern reg2 = Pattern.compile("-");
        Pattern reg3 = Pattern.compile("(?<=\\w)-(?=\\w)");

        ArrayList<String> ans = new ArrayList<>();

        Arrays.stream(str.split(reg1))
                .filter(s -> !"".equals(s))
                .forEach(
                        c -> {
                            if (!reg2.matcher(c).find() || reg3.matcher(c).find()) {
                                ans.add(c);
                            } else {
                                Arrays.stream(c.split("-")).filter(s -> !"".equals(s)).forEach(s -> ans.add(s));
                            }
                        });

        StringJoiner sj = new StringJoiner(" ");
        for (int i = ans.size() - 1; i >= 0; i--) {
            sj.add(ans.get(i));
        }
        return sj.toString();
    }
}
