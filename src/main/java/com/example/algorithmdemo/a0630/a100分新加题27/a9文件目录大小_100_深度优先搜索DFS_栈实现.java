package com.example.algorithmdemo.a0630.a100分新加题27;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a9文件目录大小_100_深度优先搜索DFS_栈实现
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130765017?spm=1001.2014.3001.5501
题目描述:
一个文件目录的数据格式为：目录id，本目录中文件大小，(子目录id列表）。
其中目录id全局唯一，取值范围[1, 200]，本目录中文件大小范围[1, 1000]，子目录id列表个数[0,10]
例如 : 1 20 (2,3) 表示目录1中文件总大小是20，有两个子目录，id分别是2和3
现在输入一个文件系统中所有目录信息，以及待查询的目录 id ，返回这个目录和及该目录所有子目录的大小之和。
输入描述:
第一行为两个数字M，N，分别表示目录的个数和待查询的目录id,
1 ≤ M ≤ 100
1 ≤ N ≤ 200
接下来M行，每行为1个目录的数据：
目录id 本目录中文件大小 (子目录id列表)
子目录列表中的子目录id以逗号分隔。
输出描述:
待查询目录及其子目录的大小之和

用例:
输入
3 1
3 15 ()
1 20 (2)
2 10 (3)
输出
45
说明
目录1大小为20，包含一个子目录2 (大小为10)，子目录2包含一个子目录3(大小为15)，总的大小为20+10+15=45

输入
4 2
4 20 ()
5 30 ()
2 10 (4,5)
1 40 ()
输出
60
说明
目录2包含2个子目录4和5，总的大小为10+20+30 = 60
 * @date: 2023/6/4 8:28
 * @version: V-1.0
 */
public class a9文件目录大小_100_深度优先搜索DFS_栈实现 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        HashMap<Integer, ArrayList<Integer>> children = new HashMap<>();
        HashMap<Integer, Integer> cap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int fa_id = sc.nextInt();
            int fa_cap = sc.nextInt();

            children.putIfAbsent(fa_id, new ArrayList<>());
            cap.putIfAbsent(fa_id, fa_cap);

            String ch_str = sc.next();
            if (ch_str.length() > 2) {
                children
                        .get(fa_id)
                        .addAll(
                                Arrays.stream(ch_str.substring(1, ch_str.length() - 1).split(","))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList()));
            }
        }

        System.out.println(getResult(children, cap, n));
    }

    public static int getResult(
            HashMap<Integer, ArrayList<Integer>> children, HashMap<Integer, Integer> cap, int target) {
        int ans = 0;

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(target);

        while (stack.size() > 0) {
            Integer id = stack.pop();
            if (!cap.containsKey(id)) continue;
            ans += cap.get(id);
            stack.addAll(children.get(id));
        }

        return ans;
    }

}
