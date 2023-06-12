package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b29全量和已占用字符集_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127950674

 * @date: 2023/6/4 8:57
 * @version: V-1.0
 */
public class b29全量和已占用字符集_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(getResult(str));
    }

    private static String getResult(String str) {
        String[][][] tmp =
                Arrays.stream(str.split("@"))
                        .map(
                                s1 ->
                                        Arrays.stream(s1.split(",")).map(s2 -> s2.split(":")).toArray(String[][]::new))
                        .toArray(String[][][]::new);

        String[][] all = tmp[0];
        String[][] used = tmp[1];

        // 注意 输出的字符顺序要跟输入的一致，如用例不能输出b:3,a:2,c:2
        // 因此这里用LinkedHashMap维护输入顺序
        LinkedHashMap<String, Integer> allMap = new LinkedHashMap<>();
        for (String[] arr : all) {
            allMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        HashMap<String, Integer> usedMap = new HashMap<>();
        for (String[] arr : used) {
            usedMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        for (String key : usedMap.keySet()) {
            if (allMap.containsKey(key)) {
                int remain = allMap.get(key) - usedMap.get(key);
                if (remain > 0) {
                    allMap.put(key, remain);
                } else {
                    allMap.remove(key);
                }
            }
        }

        StringJoiner sj = new StringJoiner(",");
        for (Map.Entry<String, Integer> entry : allMap.entrySet()) {
            sj.add(entry.getKey() + ":" + entry.getValue());
        }
        return sj.toString();
    }
}
