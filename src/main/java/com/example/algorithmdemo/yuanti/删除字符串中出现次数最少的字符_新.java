package com.example.algorithmdemo.yuanti;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 删除字符串中出现次数最少的字符_新
 * @desc: 100%
 * @date: 2022/7/16 11:49 上午
 * @version: V-1.0
 */
public class 删除字符串中出现次数最少的字符_新 {
    /*
    删除字符串中出现次数最少的字符
    如果多个字符出现次数一样则都删除

    例子：
    输入
      abcdd
      字符串中只
     输出
      dd

    输入
      aabbccdd

    输出
      empty

      如果都被删除  则换为empty

     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        in.close();
        HashMap<Character, Long> map = new HashMap<>();
        for (char c : line.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1L);
        }

        Long[] counts = new Long[map.values().size()];
        Long[] longs = map.values().toArray(counts);
        Arrays.sort(longs);
        Long min = longs[0];
        for (Map.Entry<Character, Long> entry : map.entrySet()) {
            if (entry.getValue().equals(min)) {
                line = line.replaceAll(entry.getKey() + "", "");
            }
        }

        System.out.println(line.length() == 0 ? "empty" : line);
    }
}
