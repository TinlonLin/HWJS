package com.example.algorithmdemo.a0630.b100分复用题122;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b9单词接龙_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127943786
题目描述:
单词接龙的规则是：
可用于接龙的单词首字母必须要前一个单词的尾字母相同；
当存在多个首字母相同的单词时，取长度最长的单词，如果长度也相等，则取字典序最小的单词；已经参与接龙的单词不能重复使用。
现给定一组全部由小写字母组成单词数组，并指定其中的一个单词作为起始单词，进行单词接龙，
请输出最长的单词串，单词串是单词拼接而成，中间没有空格。
输入描述:
输入的第一行为一个非负整数，表示起始单词在数组中的索引K，0 <= K < N ；
输入的第二行为一个非负整数，表示单词的个数N；
接下来的N行，分别表示单词数组中的单词。
备注：
单词个数N的取值范围为[1, 20]；
单个单词的长度的取值范围为[1, 30]；
输出描述:
输出一个字符串，表示最终拼接的单词串。

用例
输入
0
6
word
dd
da
dc
dword
d
输出
worddwordda
说明
先确定起始单词word，再接以d开头的且长度最长的单词dword，剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，所以最后输出worddwordda。

输入
4
6
word
dd
da
dc
dword
d
输出
dwordda
说明
先确定起始单词dword，剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，所以最后输出dwordda。


public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int k = sc.nextInt();
int n = sc.nextInt();

String[] words = new String[n];
for (int i = 0; i < n; i++) words[i] = sc.next();

System.out.println(getResult(k, n, words));
}

public static String getResult(int k, int n, String[] words) {
ArrayList<String> chain = new ArrayList<>();
chain.add(words[k]);

words[k] = null;

HashMap<Character, LinkedList<String>> prefix = new HashMap<>();
for (String word : words) {
if (word != null) {
char c = word.charAt(0);
prefix.putIfAbsent(c, new LinkedList<>());
prefix.get(c).add(word);
}
}

for (Character c : prefix.keySet()) {
prefix
.get(c)
.sort((a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
}

while (true) {
String tail = chain.get(chain.size() - 1);
char c = tail.charAt(tail.length() - 1);

if (prefix.containsKey(c) && prefix.get(c).size() > 0) {
chain.add(prefix.get(c).removeFirst());
} else {
break;
}
}

StringBuilder sb = new StringBuilder();
for (String s : chain) sb.append(s);
return sb.toString();
}


 * @date: 2023/6/4 8:49
 * @version: V-1.0
 */
public class b9单词接龙_100_字符串数组集合操作 {
}
