package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b8矩阵最大值_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127180489
题目描述:
给定一个仅包含0和1的N*N二维矩阵，请计算二维矩阵的最大值，计算规则如下：
1、 每行元素按下标顺序组成一个二进制数（下标越大越排在低位），二进制数的值就是该行的值。矩阵各行值之和为矩阵的值。
2、允许通过向左或向右整体循环移动每行元素来改变各元素在行中的位置。
比如：
[1,0,1,1,1]向右整体循环移动2位变为[1,1,1,0,1]，二进制数为11101，值为29。
[1,0,1,1,1]向左整体循环移动2位变为[1,1,1,1,0]，二进制数为11110，值为30。
输入描述:
1、输入的第一行为正整数，记录了N的大小，0 < N <= 20。
2、输入的第2到N+1行为二维矩阵信息，行内元素边角逗号分隔。
输出描述:
矩阵的最大值。

用例
输入
5
1,0,0,0,1
0,0,0,1,1
0,1,0,1,0
1,0,0,1,1
1,0,1,0,1
输出
122
说明
第一行向右整体循环移动1位，得到本行的最大值[1,1,0,0,0]，二进制值为11000，十进制值为24。
第二行向右整体循环移动2位，得到本行的最大值[1,1,0,0,0]，二进制值为11000，十进制值为24。
第三行向左整体循环移动1位，得到本行的最大值[1,0,1,0,0]，二进制值为10100，十进制值为20。
第四行向右整体循环移动2位，得到本行的最大值[1,1,1,0,0]，二进制值为11100，十进制值为28。
第五行向右整体循环移动1位，得到本行的最大值[1,1,0,1,0]，二进制值为11010，十进制值为26。
因此，矩阵的最大值为122。

 * @date: 2023/6/4 8:48
 * @version: V-1.0
 */
public class b8矩阵最大值_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int ans = 0;

        for (int i = 0; i < n; i++) {
            LinkedList<Integer> dq =
                    Arrays.stream(sc.nextLine().split(","))
                            .map(Integer::parseInt)
                            .collect(Collectors.toCollection(LinkedList::new));

            int max = getVal(dq);

            for (int j = 1; j < n; j++) {
                dq.addFirst(dq.removeLast());
                max = Math.max(max, getVal(dq));
            }

            ans += max;
        }

        System.out.println(ans);
    }

    private static int getVal(LinkedList<Integer> dq) {
        StringBuilder sb = new StringBuilder();
        for (Integer v : dq) {
            sb.append(v);
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
