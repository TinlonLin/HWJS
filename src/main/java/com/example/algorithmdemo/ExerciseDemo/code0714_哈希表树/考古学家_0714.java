package com.example.algorithmdemo.ExerciseDemo.code0714_哈希表树;

import javafx.scene.transform.Scale;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 考古学家_0714
 * @desc: 考古学家
 * https://blog.csdn.net/Muse_God/article/details/125468729
 *
题目描述
考古问题，假设以前的石碑被打碎成了很多块，每块上面都有一个或若干个字符，
请你写个程序来把之前石碑上文字可能的组合全部写出来，按升序进行排列。

示例
示例1
输入
3
a b c
输出
abc
acb
bac
bca
cab
cba

示例2
输入
3
a b a
输出
aab
aba
baa
 *
 * @date: 2022/6/21 11:31 下午
 * @version: V-1.0
 */
public class 考古学家_0714 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(strArr[i]);
        }
        Set<String> resultSet = getAllPermutations(builder.toString());
        for (String s : resultSet) {
            System.out.println(s);
        }
    }

    private static Set<String> getAllPermutations(String str) {
        Set<String> permutationSet = new TreeSet<>();

        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            permutationSet.add("");
            return permutationSet;
        }

        char firstC = str.charAt(0);
        String remainStr = str.substring(1);
        Set<String> remainStrSet = getAllPermutations(remainStr);
        for (String s : remainStrSet) {
            for (int i = 0; i <= s.length(); i++) {
                permutationSet.add(s.substring(0, i) + firstC + s.substring(i));
            }
        }
        return permutationSet;
    }
}
