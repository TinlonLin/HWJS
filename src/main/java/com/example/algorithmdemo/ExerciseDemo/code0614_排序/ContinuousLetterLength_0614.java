package com.example.algorithmdemo.ExerciseDemo.code0614_排序;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: ContinuousLetteLength_0614
 * @desc: 连续字母长度
 * https://blog.csdn.net/weixin_44219664/article/details/123809325?spm=1001.2014.3001.5506
 * （关键）给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第k长的字母的次数，相同字母只取最长的子串
 * 输入
 * 第一行 一个子串 1<len<=100
 * 只包含大写字母
 * 第二行为k的值
 *
 * 输出
 * 输出连续出现次数第k多的字母的次数
 *
 * 例子：
 * 输入
 * AABAAA
 * 2
 * 输出
 * 1
 * 同一字母连续出现最多的A 3次
 * 第二多2次  但A出现连续3次
 *
 * 输入
 * AAAAHHHBBCDHHHH
 * 3
 *
 * 输出
 * 2
 * 如果子串中只包含同一字母的子串数小于k则输出-1
 * @date: 2022/6/14 12:44 上午
 * @version: V-1.0
 */
public class ContinuousLetterLength_0614 {
    public static void main(String[] args) {
        String str = "AABAAA";
        int k = 2;
        System.out.println("输入：\n"+str+"\n"+k);
        System.out.println("输出：");
        getKCount(str,k);

        String str1 = "AAAAHHHBBCDHHHH";
        int k1 = 3;
        System.out.println("输入：\n"+str1+"\n"+k1);
        System.out.println("输出：");
        getKCount(str1,k1);

    }

    private static void getKCount(String str, int k) {
        //使用Map存储字母及出现的次数，相同字母只存次数大的
        Map<Character,Integer> charCountMap = new HashMap<>();
        //以第一个字母为起点，出现次数为1
        char curChar = str.charAt(0);
        int count = 1;
        charCountMap.put(curChar,count);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == curChar) {
                count++;
            } else {
                curChar = str.charAt(i);
                count = 1;
            }
            //判断map中中是否已有当前字母及比较次数
            if (!charCountMap.containsKey(curChar)) {
                charCountMap.put(curChar,count);
            } else if (count > charCountMap.get(curChar)) {
                charCountMap.replace(curChar,count);
            }
        }
        //统计好后将entrySet存入List并根据map的value降序排序
        List<Map.Entry<Character,Integer>> charCountList = new ArrayList<>(charCountMap.entrySet());
        charCountList.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        //排序后先判断k与list大小的关系
        if (k > charCountList.size()) {
            System.out.println(-1);
        } else {
            System.out.println(charCountList.get(k-1).getValue());
        }
     }
}
