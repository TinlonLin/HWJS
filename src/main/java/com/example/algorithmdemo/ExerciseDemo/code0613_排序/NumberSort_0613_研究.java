package com.example.algorithmdemo.ExerciseDemo.code0613_排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: NumberSort_0613
 * @desc: 数字排列
 * https://blog.csdn.net/u010005281/article/details/80412990
 * https://blog.csdn.net/Inmotea/article/details/122905252
 * 小明负责公司年会，想出一个趣味游戏：屏幕给出1~9中任意3个不重复的数字，
 * 大家以最快时间给出这几个数字可拼成的数字从小到大排列位于第N位置的数字，其中N为给出的数字中最大的（如果不到这么多个数字则给出最后一个即可），谁最快给出谁得奖。
 * 注意：
 * （1）屏幕如果给出的是“2”，大家可把它当作“2”，也可把它当作“5”来拼接数字；同理，如果屏幕给的是“5”，大家可把它当作“5”，也可以把它当作“2”来拼接数字，但屏幕不能同时给出“2”和“5”。
 * （2）屏幕如果给出的是“6”，大家可把它当作“6”，也可把它当作“9”来拼接数字；同理，如果屏幕给的是“9”，大家可把它当作“9”，也可以把它当作“6”来拼接数字，但屏幕不能同时给出“6”和“9”。
 * 现在需要编写一个小程序，根据给出的数字计算出能组合的所有2数字以及最终的正确答案。
 * 如：给出：1，4，8，则可以拼成的数字为：
 * 1，4，8，14，18，41，48，81，84，148，184，418，481，814，841
 * 那么最第N（即8）个的数字为81.
 * 输入描述：以逗号为分隔，描述3个int类型整数的字符串。
 * 输出描述：这几个数字可拼成的数字从小到大排列位于第N（N为输入数字中最大的数字）位置的数字，如果输入的数字为负数或者不是合法的字符串或者有重复，返回-1。
 * 输入例子：1，4，8
 * 输出例子：81
 * @date: 2022/6/12 10:11 上午
 * @version: V-1.0
 */
public class NumberSort_0613_研究 {
    public static void main(String[] args) {
        String str = "1,4,8";
        System.out.println("输入：\n" + str);
        System.out.println("输出：");
        //81
        System.out.println(getNoN(str));
    }

    private static int getNoN(String str) {
        //将拆分的数字存入List中，并先处理特殊情况
        ArrayList<Integer> array = getSingleNumsArray(str);
        if (array == null) {
            return -1;
        }
        //同时包含2，5非法
        if (array.contains(2) && array.contains(5)) {
            return -1;
        }
        //同时包含6，9非法
        if (array.contains(6) && array.contains(9)) {
            return -1;
        }
        //使用set存储所有组合，并去重
        HashSet<Integer> hashSet = new HashSet<>();
        getCombinedNumsArray(array, hashSet);
        //对2、5、6、9单独处理
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(2)) {
                array.set(i, 5);
                getCombinedNumsArray(array, hashSet);
            } else if (array.get(i).equals(5)) {
                array.set(i, 2);
                getCombinedNumsArray(array, hashSet);
            } else if (array.get(i).equals(6)) {
                array.set(i, 9);
                getCombinedNumsArray(array, hashSet);
            } else if (array.get(i).equals(9)) {
                array.set(i, 6);
                getCombinedNumsArray(array, hashSet);
            }
        }
        //将set中的值存入list中，并排序，因为list可以根据下标获取值
        ArrayList<Integer> resArray = new ArrayList<>();
        for (Integer i : hashSet) {
            resArray.add(i);
        }
        Collections.sort(resArray);
        //System.out.println(resArray);
        //先单独处理输入包含2、6的情况，讨论最大值是否比5大，输入包含6，最大值为9
        int maxNum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == 2) {
                maxNum = Math.max(maxNum, 5);
            } else if (array.get(i) == 6) {
                maxNum = 9;
            } else {
                //遍历输入数组获取最大值
                maxNum = Math.max(maxNum,array.get(i));
            }
        }
        return resArray.get(maxNum - 1);
    }

    private static ArrayList<Integer> getSingleNumsArray(String line) {
        String[] threeValues = line.split(",");
        //按题意必须要三个数
        if (threeValues.length != 3) {
            return null;
            //三个数中有重复值也不符合条件
        } else if (threeValues[0].equals(threeValues[1]) || threeValues[0].equals(threeValues[2])
                || threeValues[1].equals(threeValues[2])) {
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : threeValues) {
            int num = Integer.parseInt(s);
            //数字要在1~9之间
            if (num < 1 || num > 9) {
                return null;
            }
            res.add(num);
        }
        return res;
    }

    private static void getCombinedNumsArray(ArrayList<Integer> list, HashSet<Integer> hashSet) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            //添加个位数
            hashSet.add(list.get(i));
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                //添加不同数组成的两位数
                hashSet.add(list.get(i) * 10 + list.get(j));
                for (int k = 0; k < len; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    //添加不同数组成的三位数
                    hashSet.add(list.get(i) * 100 + list.get(j) * 10 + list.get(k));
                }
            }
        }
    }

}
