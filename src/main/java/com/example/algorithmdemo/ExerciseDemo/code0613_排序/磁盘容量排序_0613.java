package com.example.algorithmdemo.ExerciseDemo.code0613_排序;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: DiskCapcitySort_0613
 * @desc: 磁盘容量排序
 * https://blog.csdn.net/weixin_44052055/article/details/124049468
 * 输入描述：
 * 第一行包含一个整数n 2<=n<=100 表示磁盘的个数
 * 接下来的n行，每一行一个字符串为磁盘的容量 2~30，由一个或多个格式为mv的子串构成，m为容量大小，v为荣量单位，有T、G、M
 * 1T = 1024G 1G = 1024M
 * 输出描述：
 * 输出n行，为磁盘排序后的结果，从大到小稳定排序
输入:
3
1G
2G
1024M
输出：
1G
1024M
2G
注：稳定排序要求值相等时保持原来的顺序
输入：
3
2G4M
3M2G
1T
输出：
3m2G
2G3M
1T
 * @date: 2022/6/12 10:09 上午
 * @version: V-1.0
 */
public class 磁盘容量排序_0613 {
    public static void main(String[] args) {
        //获取输入的n和n个磁盘容量
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] capStrArr = new String[n];
        for (int i = 0; i < n; i++) {
            capStrArr[i] = sc.nextLine();
        }
        sc.close();
        //将字符串存入List中，方便后续排序交换位置
        List<String> capList = new ArrayList<>();
        for (String s : capStrArr) {
            capList.add(s);
        }
        getSortedDiskCapacity(capList);
    }

    private static void getSortedDiskCapacity(List<String> capList) {
        //遍历List，按从小到大排序，如果前面值大于后面值，则交换，值相等不交换，保持原顺序
        for (int i = 0; i < capList.size() - 1; i++) {
            if (getValueByStr(capList.get(i)) > getValueByStr(capList.get(i + 1))) {
                swapByIndex(capList, i, i + 1);
            }
        }
        //遍历交换完输出排序后的list
        for (String s : capList) {
            System.out.println(s);
        }
    }

    private static int getValueByStr(String str) {
        //统一转为多少M
        //先根据M、G、T分割出容量大小
        String[] sizeArr = str.split("[MGT]");
        //再根据数字分割出容量单位
        String[] unitArr = str.split("[0-9]");
        //遍历容量大小和容量单位数组计算总大小
        int sum = 0;
        for (int i = 0; i < sizeArr.length; i++) {
            for (int j = 0; j < unitArr.length; j++) {
                if ("M".equals(unitArr[j])) {
                    sum += Integer.parseInt(sizeArr[i]);
                } else if ("G".equals(unitArr[j])) {
                    sum += Integer.parseInt(sizeArr[i]) * 1024;
                } else if ("T".equals(unitArr[j])) {
                    sum += Integer.parseInt(sizeArr[i]) * 1024 * 1024;
                }
            }
        }
        return sum;
    }

    private static void swapByIndex(List<String> list, int i, int j) {
        //根据下标交换两个值的位置
        String tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
