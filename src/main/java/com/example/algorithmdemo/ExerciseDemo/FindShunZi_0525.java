package com.example.algorithmdemo.ExerciseDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/5/26 0:09
 * @ClassName: ShunZi_0525
 * @Desc: 斗地主之顺子
 * @Version: V-1.0
 * https://blog.csdn.net/weixin_44219664/article/details/123947636
 */
public class FindShunZi_0525 {
    public static void main(String[] args) {
        String s1 = "2 9 J 3 4 K A 7 9 A 5 6";
        findShunZi(s1);

//        String s2 = "3 4 5 6 7 8 9 10 J Q K A";
//        findShunZi(s2);

        String s3 = "2 9 J 10 3 4 K A 7 Q A 5 6";
        findShunZi(s3);

    }

    private static void findShunZi(String str) {
        String[] strArr = str.split(" ");
        /** 1.将字符串中的字母转为数字，并把非2的元素存入List中，并升序处理 */
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            if ("J".equals(strArr[i])) {
                intList.add(11);
            } else if ("Q".equals(strArr[i])) {
                intList.add(12);
            } else if ("K".equals(strArr[i])) {
                intList.add(13);
            } else if ("A".equals(strArr[i])) {
                intList.add(14);
            } else if (!"2".equals(strArr[i]) && !intList.contains(Integer.parseInt(strArr[i]))) {
                intList.add(Integer.parseInt(strArr[i]));
            }
        }
        Collections.sort(intList);

        /** 2.找顺子并且存储顺子并输出，结果为List包List即顺子的集合 */

        /** 最终结果 */
        List<List> allList = new ArrayList<>();

        /** 连续数字出现的次数 */
        int m = 1;
        int i = 0;
        while (i < intList.size()) {
            int j = i+1;
            while (j < intList.size()) {
                if (intList.get(i++) + 1 == intList.get(j++)) {
                    m++;
                    if (m >= 5) {
                        /** 截取相应的顺子list */
                        allList.add(intList.subList(j-m,j));
                    }
                } else {
                    i = j;
                    break;
                }
            }
        }

        if (allList.size() == 0) {
            System.out.println("No");
        } else {
            /** 循环结果列表，输出顺子结果 */
            for (List list : allList) {
                for (Object integer : list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(intToString((Integer) integer)).append(" ");
                }
                System.out.println(list);
            }
        }

    }

    /** 数字转为字符串 */
    private static String intToString(int num) {
        if (num == 11) {
            return "J";
        } else if (num == 12) {
            return "Q";
        } else if (num == 13) {
            return "K";
        } else if (num == 14) {
            return "A";
        } else {
            return String.valueOf(num);
        }
    }
}

