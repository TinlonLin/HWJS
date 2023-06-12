package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b6叠积木_200_回溯算法
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127710334

 * @date: 2023/6/4 9:54
 * @version: V-1.0
 */
public class b6叠积木_200_回溯算法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr));
    }

    private static int getResult(Integer[] arr) {
        Arrays.sort(arr, (a, b) -> b - a);

        int sum = 0;
        for (Integer ele : arr) {
            sum += ele;
        }

        int m = arr.length;

        while (m > 1) {
            LinkedList<Integer> link = new LinkedList<>();
            Collections.addAll(link, arr);
            if (canPartitionMSubsets(link, sum, m)) return m;
            m--;
        }

        return -1;
    }

    private static boolean canPartitionMSubsets(LinkedList<Integer> link, int sum, int m) {
        if (sum % m != 0) {
            return false;
        }

        int subSum = sum / m;

        if (subSum < link.get(0)) {
            return false;
        }

        //    while (link.get(0) == subSum) { // 此段代码可能越界
        while (link.size() > 0 && link.get(0) == subSum) {
            link.removeFirst();
            m--;
        }

        int[] buckets = new int[m];
        return partition(link, 0, buckets, subSum);
    }

    private static boolean partition(LinkedList<Integer> link, int index, int[] buckets, int subSum) {
        if (index == link.size()) {
            return true;
        }

        int select = link.get(index);

        for (int i = 0; i < buckets.length; i++) {
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            if (select + buckets[i] <= subSum) {
                buckets[i] += select;
                if (partition(link, index + 1, buckets, subSum)) return true;
                buckets[i] -= select;
            }
        }

        return false;
    }
}
