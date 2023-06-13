package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b45找到比自己强的人数_200_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128192252

 * @date: 2023/6/4 10:10
 * @version: V-1.0
 */
public class b45找到比自己强的人数_200_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        // 正则：(?<=\]),(?=\[)  的含义是，找这样一个“,“,它的前面跟着"]"，后面跟着"["
        Integer[][] relations =
                Arrays.stream(str.substring(1, str.length() - 1).split("(?<=\\]),(?=\\[)"))
                        .map(
                                s ->
                                        Arrays.stream(s.substring(1, s.length() - 1).split(","))
                                                .map(Integer::parseInt)
                                                .toArray(Integer[]::new))
                        .toArray(Integer[][]::new);

        System.out.println(getResult(relations));
    }

    private static String getResult(Integer[][] relations) {
        // fa用于统计每个师傅名下的直接徒弟的排名，fa对象的属性是师傅排名，属性值是一个数组，里面元素是直接徒弟的排名
        HashMap<Integer, ArrayList<Integer>> fa = new HashMap<>();

        for (Integer[] relation : relations) {
            int f = relation[0];
            int c = relation[1];

            fa.putIfAbsent(f, new ArrayList<>());
            fa.putIfAbsent(c, new ArrayList<>());

            fa.get(f).add(c);
        }

        ArrayList<Integer[]> ans = new ArrayList<>();

        // 输出结果要求依次统计：排名第一的师傅的高于自己的徒弟的个数，排名第二的师傅的高于自己的徒弟的个数，......
        for (Integer f : fa.keySet()) {
            ans.add(new Integer[] {f, getHighC(f, f, new HashSet<>(), fa)});
        }

        // 按照师傅排名升序后，输出高于师傅排名的徒弟的个数
        ans.sort((a, b) -> a[0] - b[0]);

        return Arrays.toString(ans.stream().map(arr -> arr[1]).toArray(Integer[]::new));
    }

    /**
     * @param f 当前的师傅，初始时为源头祖师
     * @param src 源头祖师
     * @param highC 比源头祖师排名的高的徒弟的排名集合
     * @param fa fa对象的属性是师傅排名，属性值是一个数组，里面元素是直接徒弟的排名
     * @return 比源头祖师排名的高的徒弟的个数，即highC.size
     */
    private static int getHighC(
            int f, int src, HashSet<Integer> highC, HashMap<Integer, ArrayList<Integer>> fa) {
        if (f == 1) {
            return 0; // 如果当前师傅是第一名，那么肯定没有徒弟超过它，因此直接返回0
        }

        // 遍历当前师傅的所有徒弟
        for (int c : fa.get(f)) {
            // flag标记是否需要统计间接徒弟，默认需要
            boolean flag = true;

            // 如果徒弟的排名高于源头祖师（排名越高，值越小），则应该统计到highC集合中
            if (c < src) {
                if (!highC.contains(c)) {
                    // 如果highC集合没有这个徒弟，则统计，并需要统计这个徒弟的徒弟（即间接徒弟）的排名情况
                    highC.add(c);
                } else {
                    // 如果highC中已经有了当前的徒弟，则说明当前徒弟已经统计过了，不需要再统计，且当前徒弟的徒弟也不需要再统计了
                    flag = false;
                }
            } else if (c == src) { // 形成环，需要打断
                return 0;
            }

            // 统计间接徒弟
            if (flag) {
                getHighC(c, src, highC, fa);
            }
        }

        return highC.size();
    }
}
