package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b44热点网站统计_200_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418376

 * @date: 2023/6/4 10:10
 * @version: V-1.0
 */
public class b44热点网站统计_200_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 改正则用于判断一个字符串是否为正整数
        Pattern reg = Pattern.compile("^\\d+$");
        // urls保存每次输入的url
        ArrayList<String> urls = new ArrayList<>();
        // cache记录每个url出现次数
        HashMap<String, Integer> cache = new HashMap<>();
        // ans保存输出
        ArrayList<String> ans = new ArrayList<>();

        while (sc.hasNextLine()) {
            String tmp = sc.nextLine();
            // 由于本题没有说明输入结束条件，我这里将输入空行作为输入结束的条件，此时打印前面统计的结果
            if ("".equals(tmp)) {
                for (String an : ans) {
                    System.out.println(an);
                }
                sc.close();
                break;
            }

            // 如果输入的是正整数
            if (reg.matcher(tmp).find()) {
                // 将统计结果记录到ans
                ans.add(sortURL(urls, Integer.parseInt(tmp), cache));
                // 清空urls，继续下次输入记录
                urls = new ArrayList<>();
            } else { // 输入的是url
                urls.add(tmp);
            }
        }
    }

    public static String sortURL(ArrayList<String> urls, int n, HashMap<String, Integer> cache) {
        for (String url : urls) {
            cache.put(url, cache.getOrDefault(url, 0) + 1);
        }

        StringJoiner sj = new StringJoiner(",");

        cache.entrySet().stream()
                .sorted(
                        (a, b) ->
                                Objects.equals(a.getValue(), b.getValue())
                                        ? a.getKey().compareTo(b.getKey())
                                        : b.getValue() - a.getValue())
                .limit(n)
                .map(ele -> ele.getKey())
                .forEach(url -> sj.add(url));

        return sj.toString();
    }
}
