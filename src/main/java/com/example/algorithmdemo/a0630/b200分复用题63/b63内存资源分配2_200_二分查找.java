package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b63内存资源分配2_200_二分查找
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/128503240

 * @date: 2023/6/4 10:17
 * @version: V-1.0
 */
public class b63内存资源分配2_200_二分查找 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[][] pools =
                Arrays.stream(sc.nextLine().split(","))
                        .map(
                                str -> Arrays.stream(str.split(":")).map(Integer::parseInt).toArray(Integer[]::new))
                        .toArray(Integer[][]::new);

        Integer[] applies =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(pools, applies));
    }

    public static String getResult(Integer[][] pools, Integer[] applies) {
        Integer[][] sortedPools =
                Arrays.stream(pools).sorted((a, b) -> a[0] - b[0]).toArray(Integer[][]::new);

        ArrayList<Integer> sizes = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        for (Integer[] pool : sortedPools) {
            sizes.add(pool[0]);
            counts.add(pool[1]);
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (Integer apply : applies) {
            int idx = Collections.binarySearch(sizes, apply);

            if (idx < 0) {
                idx = -idx - 1;
            }

            if (idx >= sizes.size()) {
                ans.add(false);
                continue;
            }

            counts.set(idx, counts.get(idx) - 1);
            ans.add(true);
            if (counts.get(idx) == 0) {
                counts.remove(idx);
                sizes.remove(idx);
            }
        }

        StringJoiner sj = new StringJoiner(",");
        for (Boolean an : ans) {
            sj.add(an + "");
        }
        return sj.toString();
    }
}
