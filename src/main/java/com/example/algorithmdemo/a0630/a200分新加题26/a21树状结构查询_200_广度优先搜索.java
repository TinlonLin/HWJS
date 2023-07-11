package com.example.algorithmdemo.a0630.a200分新加题26;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/12 0:12
 * @ClassName: a21树状结构查询_200_广度优先搜索
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130773940
题目描述
通常使用多行的节点、父节点表示一棵树，比如
西安 陕西
陕西 中国
江西 中国
中国 亚洲
泰国 亚洲
输入一个节点之后，请打印出来树中他的所有下层节点
输入描述
第一行输入行数，下面是多行数据，每行以空格区分节点和父节点
接着是查询节点
输出描述
输出查询节点的所有下层节点。以字典序排序
备注
树中的节点是唯一的，不会出现两个节点，是同一个名字

用例
输入
5
b a
c a
d c
e c
f d
c
输出
d
e
f
说明
无


 * @Version: V-1.0
 */
public class a21树状结构查询_200_广度优先搜索 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, HashSet<String>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ch = sc.next();
            String fa = sc.next();

            tree.putIfAbsent(fa, new HashSet<>());
            tree.get(fa).add(ch);
        }

        String target = sc.next();

        getResult(tree, target);
    }

    public static void getResult(HashMap<String, HashSet<String>> tree, String target) {
        if (!tree.containsKey(target)) {
            System.out.println("");
            return;
        }

        LinkedList<String> queue = new LinkedList<>(tree.get(target));

        ArrayList<String> ans = new ArrayList<>();

        while (queue.size() > 0) {
            String node = queue.removeFirst();
            ans.add(node);

            if (tree.containsKey(node)) {
                queue.addAll(tree.get(node));
            }
        }

        ans.sort(String::compareTo);

        ans.forEach(System.out::println);
    }
}
