package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b8统计文本数量_200_正则匹配
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128165419

 * @date: 2023/6/4 9:54
 * @version: V-1.0
 */
public class b8统计文本数量_200_正则匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<String> lines = new LinkedList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if ("".equals(line)) {
                System.out.println(getResult(lines));
                sc.close();
                break;
            } else {
                lines.add(line);
            }
        }
    }

    private static int getResult(LinkedList<String> lines) {
        int count = 0;

        for (String line : lines) {
            String tmp = line.replaceAll("\\[\"']", "").replaceAll("([\"']).*?\1", "");

            int idx = tmp.indexOf("-");

            if (idx != -1) {
                tmp = tmp.substring(0, idx);
            }

            Pattern compile = Pattern.compile("^\\s*$");

            if (tmp.contains(";")) {
                count +=
                        Arrays.stream(tmp.split(";")).filter(str -> !compile.matcher(str).matches()).count();
            }
        }

        if (!lines.getLast().contains(";")) {
            count++;
        }

        return count;
    }
}
