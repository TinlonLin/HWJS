package com.example.algorithmdemo.a0630.b100分复用题122;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b10找出符合要求的字符串子串_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127944263
题目描述:
给定两个字符串，从字符串2中找出字符串1中的所有字符，去重并按照ASCII值从小到大排序。
输入字符串1：长度不超过1024
输入字符串2：长度不超过1000000
字符范围满足ASCII编码要求，按照ASCII的值由小到大排序
输入描述:
bach
bbaaccedfg
输出描述:
abc
备注
输入字符串1 为给定字符串bach，输入字符串2 bbaaccedfg
从字符串2中找出字符串1的字符，去除重复的字符，并且按照ASCII值从小到大排序，得到输出的结果为abc。
字符串1中的字符h在字符串2中找不到不输出。

用例
输入
fach
bbaaccedfg
输出
acf


public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

String s1 = sc.next();
String s2 = sc.next();

System.out.println(getResult(s1, s2));
}

public static String getResult(String s1, String s2) {
HashSet<Character> set1 = new HashSet<>();
for (char c : s1.toCharArray()) set1.add(c);

HashSet<Character> set2 = new HashSet<>();
for (char c : s2.toCharArray()) set2.add(c);

Character[] characters = set1.stream().filter(c -> set2.contains(c)).toArray(Character[]::new);
Arrays.sort(characters);

StringBuilder sb = new StringBuilder();
for (Character c : characters) sb.append(c);

return sb.toString();
}

 * @date: 2023/6/4 8:49
 * @version: V-1.0
 */
public class b10找出符合要求的字符串子串_100_字符串数组集合操作 {
}
