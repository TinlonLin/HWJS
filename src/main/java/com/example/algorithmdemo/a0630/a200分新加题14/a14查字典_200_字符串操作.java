package com.example.algorithmdemo.a0630.a200分新加题14;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2023/6/8 23:41
 * @ClassName: a14查字典_200_字符串操作
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130775122
题目描述：
输入一个单词前缀和一个字典，输出包含该前缀的单词
输入描述：
单词前缀+字典长度+字典
字典是一个有序单词数组
输入输出都是小写
输出描述：
所有包含该前缀的单词，多个单词换行输出
若没有则返回-1

用例
输入
b 3 a b c
输出
b

输入
abc 4 a ab abc abcd
输出
abc
abcd

输入
a 3 b c d
输出
-1

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

String[] tmp = sc.nextLine().split(" ");

String prefix = tmp[0];
int n = Integer.parseInt(tmp[1]);
String[] dict = Arrays.copyOfRange(tmp, 2, 2 + n);

getResult(prefix, dict);
}

public static void getResult(String prefix, String[] dict) {
boolean find = false;

for (String word : dict) {
if (word.startsWith(prefix)) {
find = true;
System.out.println(word);
}
}

if (!find) System.out.println(-1);
}

 * @Version: V-1.0
 */
public class a14查字典_200_字符串操作 {
}
