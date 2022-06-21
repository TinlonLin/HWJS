package com.example.algorithmdemo.ExerciseDemo.code0523_数组;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/5/23 0:35
 * @ClassName: StringCompress
 * @Desc: todo
 * https://blog.csdn.net/qq_41821422/article/details/123845320
 * 针对全部由小写英文字母组成的字符串，将其中连续超过两个相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。
 * 例如：字符串“aaabbccccd”经过压缩成为字符串“3abb4cd”
 *
 *
 * @Version: V-1.0
 */
public class 一种字符串压缩表示的解压_0523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        char[] strArray = str.toCharArray();
        /** 将字母存入有序的treemap中，并统计出现的次数 */
        Map<Character,Integer> c_counts = new TreeMap<>();
        for (int i = 0; i < strArray.length; i++) {
            if (!c_counts.containsKey(strArray[i])) {
                c_counts.put(strArray[i],1);
            } else {
                c_counts.replace(strArray[i],c_counts.get(strArray[i])+1);
            }
        }
        /** 遍历map，根据出现的字母次数拼接新字符串 */
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character,Integer> entry : c_counts.entrySet()) {
            if (entry.getValue() >= 3) {
                sb.append(entry.getValue()).append(entry.getKey());
            } else if (entry.getValue() == 2){
                sb.append(entry.getKey()).append(entry.getKey());
            } else {
                sb.append(entry.getKey());
            }
        }

        System.out.println(sb.toString());

    }
}
