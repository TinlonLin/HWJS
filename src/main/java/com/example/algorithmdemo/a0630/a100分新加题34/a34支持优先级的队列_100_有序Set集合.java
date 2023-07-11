package com.example.algorithmdemo.a0630.a100分新加题34;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/11 23:52
 * @ClassName: a34支持优先级的队列
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/131174955?spm=1001.2014.3001.5502
题目描述
实现一个支持优先级的队列，高优先级先出队列；同优先级时先进先出。
如果两个输入数据和优先级都相同，则后一个数据不入队列被丢弃。
队列存储的数据内容是一个整数。
输入描述
一组待存入队列的数据 (包含内容和优先级)
输出描述
备注
队列的数据内容(优先级信息输出时不再体现)
不用考虑输入数据不合法的情况，测试数据不超过100个

用例
输入
(10,1),(20,1),(30,2),(40,3)
输出
40,30,10,20
说明
输入样例中，向队列写入了4个数据，每个数据由数据内容和优先级组成。
输入和输出内容都不含空格。
数据40的优先级最高，所以最先输出，其次是30;
10和20优先级相同，所以按输入顺序输出。

输入
(10,1),(10,1),(30,2),(40,3)
输出
40,30,10
说明
输入样例中，向队列写入了4个数据，每个数据由数据内容和优先级组成。
输入和输出内容都不含空格。
数据40的优先级最高，所以最先输出，其次是30;
两个10和10构成重复数据，被丢弃一个。


 * @Version: V-1.0
 */
public class a34支持优先级的队列_100_有序Set集合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        int[][] tasks =
                Arrays.stream(line.substring(1, line.length() - 1).split("\\),\\("))
                        .map(s -> Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray())
                        .toArray(int[][]::new);

        System.out.println(getResult(tasks));
    }

    public static String getResult(int[][] tasks) {
        HashMap<Integer, LinkedHashSet<Integer>> map = new HashMap<>();

        for (int[] task : tasks) {
            int num = task[0];
            int priority = task[1];

            map.putIfAbsent(priority, new LinkedHashSet<>());
            map.get(priority).add(num);
        }

        StringJoiner sj = new StringJoiner(",");
        map.keySet().stream()
                .sorted((a, b) -> b - a)
                .forEach(
                        p -> {
                            map.get(p).forEach(num -> sj.add(num + ""));
                        });

        return sj.toString();
    }
}
