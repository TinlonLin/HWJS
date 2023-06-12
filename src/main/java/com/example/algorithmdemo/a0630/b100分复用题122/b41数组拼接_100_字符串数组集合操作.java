package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b41数组拼接_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418403

 * @date: 2023/6/4 9:03
 * @version: V-1.0
 */
public class b41数组拼接_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subLen = Integer.parseInt(sc.nextLine());

        int n = Integer.parseInt(sc.nextLine());

        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            lists.add(
                    new LinkedList<>(
                            Arrays.stream(sc.nextLine().split(","))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList())));
        }

        System.out.println(getResult(subLen, lists));
    }

    public static String getResult(int subLen, LinkedList<LinkedList<Integer>> lists) {
        ArrayList<Integer> ans = new ArrayList<>();

        while (lists.size() > 0) {
            LinkedList<Integer> list = lists.removeFirst();
            ans.addAll(removeRange(list, 0, subLen));
            if (list.size() > 0) lists.addLast(list);
        }

        StringJoiner sj = new StringJoiner(",");
        for (Integer an : ans) {
            sj.add(an + "");
        }
        return sj.toString();
    }

    private static List<Integer> removeRange(LinkedList<Integer> list, int start, int end) {
        if (end > list.size()) {
            end = list.size();
        }

        List<Integer> tmp = list.subList(start, end);

        List<Integer> ans = new ArrayList<>(tmp);
        tmp.clear();

        return ans;
    }
}
