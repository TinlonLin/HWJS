package com.example.algorithmdemo.ExerciseDemo.code0629_滑窗;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 字符串比较_0629
 * @desc: 字符串比较
 * https://blog.csdn.net/qq_34465338/article/details/124361029?spm=1001.2014.3001.5506
 *
 * 输入描述：
 * 第一行为字符串A，仅包含小写字符， 1 <= A.length <= 1000
 * 第二行为字符串B，仅包含小写字符， 1 <= B.length <= 1000
 * 第三行为正整数V，0<= V <= 10000
 * 输出描述：
 * 字符串最大连续子串的长度，要求该子串|A[i] - B[i]| 之和小于等于V
 *
示例：
输入：
xxcdefg
cdefghi
5
输出：
2
 * @date: 2022/6/21 11:19 下午
 * @version: V-1.0
 */
public class 字符串比较_0629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int V = Integer.parseInt(sc.nextLine());
        getMaxLenOfSubStr(A, B, V);
    }

    private static void getMaxLenOfSubStr(String A, String B, int V) {
        //最大连续长度
        int maxLen = 0;
        //每一次符合要求的连续字符串的长度
        int len = 0;
        //对应位置差的绝对值,假设第一字符开始符合要求
        int differ = Math.abs(A.charAt(0) - B.charAt(0));
        //差值之和
        int sum = differ;
        //使用List存储符合要求的字符串
        List<Integer> subStrList = new ArrayList<>();
        subStrList.add(differ);
        for (int i = 1; i < A.length(); i++) {
            differ = Math.abs(A.charAt(i) - B.charAt(i));
            subStrList.add(differ);
            sum += differ;
            //如果和满足条件则list长度即为最长的长度
            if (sum <= V) {
                len = subStrList.size();
            } else {
                //不满足条件则和减去第一个元素，并且list中将第一个元素移除
                sum -= subStrList.get(0);
                subStrList.remove(0);
            }
            maxLen = Math.max(maxLen,len);
        }
        System.out.println(maxLen);
    }
}
