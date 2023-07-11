package com.example.algorithmdemo.a0630.a100分新加题34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2023/6/8 23:30
 * @ClassName: a23跳房子1_100_哈希表加两数之和问题
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130766192?spm=1001.2014.3001.5502
题目描述：
跳房子，也叫跳飞机，是一种世界性的儿童游戏。
游戏参与者需要分多个回合按顺序跳到第1格直到房子的最后一格。
跳房子的过程中，可以向前跳，也可以向后跳。
假设房子的总格数是count，小红每回合可能连续跳的步教都放在数组steps中，请问数组中是否有一种步数的组合，可以让小红两个回合跳到量后一格?
如果有，请输出索引和最小的步数组合。
注意：
数组中的步数可以重复，但数组中的元素不能重复使用。
提供的数据保证存在满足题目要求的组合，且索引和最小的步数组合是唯一的。
输入描述：
第一行输入为房子总格数count，它是int整数类型。
第二行输入为每回合可能连续跳的步数，它是int整数数组类型。
输出描述:
返回索引和最小的满足要求的步数组合（顺序保持steps中原有顺序）
备注
count ≤ 1000
0 ≤ steps.length ≤ 5000
-100000000 ≤ steps ≤ 100000000

用例
输入
[1,4,5,2,2]
7
输出
[5, 2]

输入
[-1,2,4,9,6]
8
输出
[-1, 9]
说明
此样例有多种组合满足两回合跳到最后，譬如：[-1,9]，[2,6]，其中[-1,9]的索引和为0+3=3，[2,6]的索和为1+4=5，所以索引和最小的步数组合[-1,9]

本质为两数之和


 * @Version: V-1.0
 */
public class a23跳房子1_100_哈希表加两数之和问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String tmp = sc.nextLine();
        int[] steps =
                Arrays.stream(tmp.substring(1, tmp.length() - 1).split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int count = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(steps, count));
    }

    public static String getResult(int[] steps, int count) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < steps.length; i++) {
            int step = steps[i];
            map.putIfAbsent(step, new ArrayList<>());
            map.get(step).add(i);
        }

        int minIdxSum = Integer.MAX_VALUE;
        String ans = "";

        for (int step1 : map.keySet()) {
            int step2 = count - step1;
            if (map.containsKey(step2)) {
                int idx1 = map.get(step1).get(0);
                int idx2 = map.get(step2).get(0);

                if (idx1 == idx2) {
                    if (map.get(step2).size() >= 2) idx2 = map.get(step2).get(1);
                    else continue;
                }

                int idxSum = idx1 + idx2;

                if (idxSum < minIdxSum) {
                    minIdxSum = idxSum;
                    ans = idx1 < idx2 ? "[" + step1 + ", " + step2 + "]" : "[" + step2 + ", " + step1 + "]";
                }
            }
        }

        return ans;
    }
}
