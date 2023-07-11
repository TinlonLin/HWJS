package com.example.algorithmdemo.a0630.a100分新加题34;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2023/6/8 23:23
 * @ClassName: a23阿里巴巴找黄金宝箱3_100_逻辑分析
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130766482
题目描述：
一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0-N的箱子，每个箱子上面贴有一个数字。
阿里巴巴念出一个咒语数字，查看宝箱是否存在两个不同箱子，这两个箱子上贴的数字相同，同时这两个箱了的编号之差的绝对值小于等于咒语数字，
如果存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1.
输入描述：
第一行输入一个数字字串，数字之间使用逗号分隔，例如: 1,2,3,1
1 ≤ 字串中数字个数 ≤ 100000
-100000 ≤ 每个数字值 ≤ 100000
第二行输入咒语数字，例如: 3
1 ≤ 咒语数字 ≤ 100000
输出描述：
存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1

用例
输入
6,3,1,6
3
输出
1

输入
5,6,7,5,6,7
2
输出
0

 * @Version: V-1.0
 */
public class a22阿里巴巴找黄金宝箱3_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] boxes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int len = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(boxes, len));
    }

    public static int getResult(int[] boxes, int len) {
// 统计该数字上一个箱子的编号
        HashMap<Integer, Integer> lastIdx = new HashMap<>();
// 对应数字的箱子已经找到了，符合咒语要求的箱子对
        HashSet<Integer> find = new HashSet<>();

        int ans = -1;

        for (int i = 0; i < boxes.length; i++) {
// 箱子上贴的数字
            int num = boxes[i];

// 该数字是否已经找到符合咒语要求的箱子对，如果找到了，则不需要再看后面的，只找第一对即可
            if (find.contains(num)) {
                continue;
            }

// 检查箱子对是否符合咒语要求
            if (lastIdx.containsKey(num) && i - lastIdx.get(num) <= len) {
                find.add(num);
                ans = ans == -1 ? lastIdx.get(num) : Math.min(ans, lastIdx.get(num));
            } else {
                lastIdx.put(num, i);
            }
        }

        return ans;
    }
}
