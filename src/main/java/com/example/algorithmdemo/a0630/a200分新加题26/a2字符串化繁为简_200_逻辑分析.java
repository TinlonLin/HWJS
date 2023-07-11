package com.example.algorithmdemo.a0630.a200分新加题26;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a2字符串化繁为简_200_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130765683
题目描述:
给定一个输入字符串，字符串只可能由英文字母（ 'a' ~ 'z'、'A' ~ 'Z' ）和左右小括号（ '('、')' ）组成。
当字符里存在小括号时，小括号是成对的，可以有一个或多个小括号对，小括号对不会嵌套，
小括号对内可以包含1个或多个英文字母，也可以不包含英文字母。
当小括号对内包含多个英文字母时，这些字母之间是相互等效的关系，而且等效关系可以在不同的小括号对之间传递，
即当存在 'a' 和 'b' 等效和存在 'b' 和 'c' 等效时，'a' 和 'c' 也等效，
另外，同一个英文字母的大写字母和小写字母也相互等效（即使它们分布在不同的括号对里）
需要对这个输入字符串做简化，输出一个新的字符串，
输出字符串里只需保留输入字符串里的没有被小括号对包含的字符（按照输入字符串里的字符顺序），
并将每个字符替换为在小括号对里包含的且字典序最小的等效字符。
如果简化后的字符串为空，请输出为"0"。
示例 :
输入字符串为"never(dont)give(run)up(f)()"，初始等效字符集合为('d', 'o', 'n', 't')、('r', 'u', 'n')，
由于等效关系可以传递，因此最终等效字符集合为('d', 'o', 'n', 't', 'r', 'u')，
将输入字符串里的剩余部分按字典序最小的等效字符替换后得到"devedgivedp'
输入描述:
input_string
输入为1行，代表输入字符串
输出描述:
output_string
输出为1行，代表输出字符串
备注
输入字符串的长度在1~100000之间

用例
输入
()abd
输出
abd
说明
输入字符串里没有被小括号包含的子字符串为"abd"，其中每个字符没有等效字符，输出为"abd"

输入
(abd)demand(fb)()for
输出
aemanaaor
说明
等效字符集为('a', 'b', 'd', 'f')，输入字符串里没有被小括号包含的子字符串集合为'demandfor"，
将其中字符替换为字典序最小的等效字符后输出为："aemanaaor"

输入
()happy(xyz)new(wxy)year(t)
输出
happwnewwear
说明
等效字符集为(‘x’, 'y', 'z', 'w')，输入字符串里没有被小括号包含的子字符串集合为"happynewyear"，
将其中字符替换为字典序最小的等效字符后输出为："happwnewwear"

输入
()abcdefgAC(a)(Ab)(C)
输出
AAcdefgAC
说明
等效字符集为('a', 'A', 'b')，输入字符里没有被小括号包含的子字符串集合为"abcdefgAC"，
将其中字符替换为字典序最小的等效字符后输出为："AAcdefgAC"

题目解析
本题首先需要将：
输入字符串里的没有被小括号对包含的字符（主体字符）
输入字符串里的被小括号对包含的字符（等效字符）
这两部分内容解析出来。
我的思路是，定义一个标志 isOpen = fasle，表示有没有遇到 '(' 字符，初始时肯定没遇到，因此初始化为false。
然后开始遍历输入字符串的每一个字符c：
如果 c == '('，则将isOpen=true，并新建一个等效字符容器eq
如果 c == ')'，则将isOpen=false
如果 c 是其他字符，如果此时isOpen==true，则将c加入“等效字符容器eq”中，否则将c加入“主体字符cArr”容器中。
这样，我们就可以得到了一个（主体字符容器）和多个（等效字符容器）。
接下来，就是对等效字符容器，进行合并操作，两个等效字符容器可以合并的原则是：
存在相同的字符
虽然不存在相同字符，但是一个有大写字符，另一个由小写字符
这个合并操作，目前没有想到好办法，只能暴力合并。具体请看代码实现。
最后，遍历每一个合并后的等效字符容器，求出对应容器中字典序最小的字符，作为容器内其他字符的替换字符。按照此替换规则，来替换主体字符容器中对应的字符。

 * @date: 2023/6/4 8:41
 * @version: V-1.0
 */
public class a2字符串化繁为简_200_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getResult(s));
    }

    public static String getResult(String s) {
// 主体字符容器
        StringBuilder sb = new StringBuilder();
// 等效字符容器的集合
        LinkedList<TreeSet<Character>> eqs = new LinkedList<>();
//  isOpen标志，表示有没有遇到 '(' 字符
        boolean isOpen = false;
// 下面逻辑用于从输入字符串中解析处主体字符，和等效字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                isOpen = true;
                eqs.add(new TreeSet<>());
            } else if (c == ')') {
                isOpen = false;
                if (eqs.getLast().size() == 0) eqs.removeLast(); // 如果等效字符容器为空，则删除
            } else {
                if (!isOpen) sb.append(c);
                else eqs.getLast().add(c);
            }
        }

// 暴力的对等效字符容器进行合并
        outer:
        while (true) {
            for (int i = 0; i < eqs.size(); i++) {
                for (int j = i + 1; j < eqs.size(); j++) {
                    if (canCombine(eqs.get(i), eqs.get(j))) {
                        eqs.get(i).addAll(eqs.get(j));
                        eqs.remove(j);
                        continue outer;
                    }
                }
            }
            break;
        }

        char[] cArr = sb.toString().toCharArray();
// 替换主体字符容器中的字符
        for (TreeSet<Character> eq : eqs) {
            Character t = eq.first();
            for (int i = 0; i < cArr.length; i++) {
                if (eq.contains(cArr[i])) cArr[i] = t;
            }
        }
        String ans = new String(cArr);
// 如果简化后的字符串为空，请输出为"0"。
        return ans.length() == 0 ? "0" : ans;
    }

    public static boolean canCombine(TreeSet<Character> set1, TreeSet<Character> set2) {
// c 是小写字符
        for (char c = 'a'; c <= 'z'; c++) {
            char uc = (char) (c - 32); // uc是大写字符
            if ((set1.contains(c) || set1.contains(uc)) && (set2.contains(c) || set2.contains(uc))) {
                return true;
            }
        }
        return false;
    }
}
