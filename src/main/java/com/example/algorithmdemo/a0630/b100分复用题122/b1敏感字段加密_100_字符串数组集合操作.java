package com.example.algorithmdemo.a0630.b100分复用题122;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b1敏感字段加密_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418027
题目描述：
给定一个由多个命令字组成的命令字符串：
1、字符串长度小于等于127字节，只包含大小写字母，数字，下划线和偶数个双引号；
2、命令字之间以一个或多个下划线_进行分割；
3、可以通过两个双引号””来标识包含下划线_的命令字或空命令字（仅包含两个双引号的命令字），双引号不会在命令字内部出现；
请对指定索引的敏感字段进行加密，替换为******（6个*），并删除命令字前后多余的下划线_。
如果无法找到指定索引的命令字，输出字符串ERROR。
输入描述：
输入为两行，第一行为命令字索引K（从0开始），第二行为命令字符串S。
输出描述：
输出处理后的命令字符串，如果无法找到指定索引的命令字，输出字符串ERROR

用例
输入
1
password__a12345678_timeout_100
输出
password_******_timeout_100

输入
2
aaa_password_"a12_45678"_timeout__100_""_
输出
aaa_password_******_timeout_100_""


public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int k = Integer.parseInt(sc.nextLine());
String s = sc.nextLine();

System.out.println(getResult(k, s));
}

public static String getResult(int k, String s) {
StringBuilder stack = new StringBuilder();
LinkedList<String> result = new LinkedList<>();

for (int i = 0; i < s.length(); i++) {
char c = s.charAt(i);

if (c == '_' && (stack.length() == 0 || stack.charAt(0) != '"')) {
result.add(stack.toString());
stack = new StringBuilder();
} else if (c == '"' && stack.length() != 0) {
stack.append('"');
result.add(stack.toString());
stack = new StringBuilder();
} else {
stack.append(c);
}
}

if (stack.length() > 0) result.add(stack.toString());

List<String> ans = result.stream().filter(str -> !"".equals(str)).collect(Collectors.toList());

if (k > ans.size() - 1) return "ERROR";
ans.set(k, "******");

StringJoiner sj = new StringJoiner("_");
for (String an : ans) sj.add(an);
return sj.toString();
}

 * @date: 2023/6/4 8:45
 * @version: V-1.0
 */
public class b1敏感字段加密_100_字符串数组集合操作 {
}
