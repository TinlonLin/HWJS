package com.example.algorithmdemo.a0630.a100分新加题29;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a2告警抑制_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130768150
题目描述：
告警抑制，是指高优先级告警抑制低优先级告警的规则。高优先级告警产生后，低优先级告警不再产生。
请根据原始告警列表和告警抑制关系，给出实际产生的告警列表。
不会出现循环抑制的情况。
告警不会传递，比如A->B,B->C，这种情况下A不会直接抑制C。但被抑制的告警仍然可以抑制其他低优先级告警。
输入描述：
第一行为数字N，表示告警抑制关系个数，0 ≤ N ≤ 120
接下来N行，每行是由空格分隔的两个告警ID，例如: id1 id2，表示id1抑制id2，告警ID的格式为：
大写字母+0个或者1个数字
最后一行为告警产生列表，列表长度[1,100]
输出描述：
真实产生的告警列表
备注
告警ID之间以单个空格分隔

用例：
输入
2
A B
B C
A B C D E
输出
A D E
说明
A抑制了B，B抑制了C，最后实际的告警为A D E

输入
4
F G
C B
A G
A0 A
A B C D E
输出
A C D E

思路：
只需要记录每一个告警id2的所有抑制它的告警集合id1s，然后遍历告警列表alertList，遍历每一个告警id2：
 * @date: 2023/6/4 8:26
 * @version: V-1.0
 */
public class a2告警抑制_100_逻辑分析y {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        HashMap<String, HashSet<String>> fa = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            // id1抑制id2
            String id1 = tmp[0], id2 = tmp[1];
            fa.putIfAbsent(id2, new HashSet<>());
            // fa用于记录抑制id2的所有id1的集合
            fa.get(id2).add(id1);
        }

        List<String> alertList = Arrays.asList(sc.nextLine().split(" "));

        getResult(fa, alertList);
    }

    public static void getResult(HashMap<String, HashSet<String>> fa, List<String> alertList) {
        HashSet<String> alertSet = new HashSet<>(alertList);

        StringJoiner sj = new StringJoiner(" ");

        for (String id2 : alertList) {
            // 如果没有抑制id2的更高级的告警，或者有抑制id2的更高级的告警，但是此高级告警没有出现在alertList列表中
            if (!fa.containsKey(id2) || Collections.disjoint(fa.get(id2), alertSet)) {
                // 此时id2就可以正常告警
                sj.add(id2);
            }
        }
        System.out.println(sj.toString());
    }
}
