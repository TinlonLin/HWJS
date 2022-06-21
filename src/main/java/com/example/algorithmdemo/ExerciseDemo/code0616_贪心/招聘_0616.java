package com.example.algorithmdemo.ExerciseDemo.code0616_贪心;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: ZhaoPin_0616
 * @desc: 招聘
 * https://blog.csdn.net/tiger9991/article/details/107037724
 *
 * 某公司组织一场公开招聘活动，假设由于人数和场地的限制，每人每次面试的时长不等，并已经安排给定，
 * 用(S1,E1)、(S2,E2)、(Sj,Ej)...(Si < Ei，均为非负整数)表示每场面试的开始和结束时间。
 * 面试采用一对一的方式，即一名面试官同时只能面试一名应试者，
 * 一名面试官完成一次面试后可以立即进行下一场面试，且每个面试官的面试人次不超过m。
 * <p>
 * 为了支撑招聘活动高效顺利进行，请你计算至少需要多少名面试官
 * <p>
 * 输入描述:
 * 输入的第一行为面试官的最多面试人次m，第二行为当天总的面试场次n，接下来的n行为每场面试的起始时间和结束时间，起始时间和结束时间用空格分隔。
 * 其中，1 <= n, m <= 500
 * <p>
 * 输出描述:
 * 输出一个整数，表示至少需要的面试官数量。
 * <p>
示例1
输入
2
5
1 2
2 3
3 4
4 5
5 6
输出
3
输入：
2
4
1 2
3 5
4 7
6 8
输出：2
 * 说明
 * 总共有5场面试，且面试时间都不重叠，但每个面试官最多只能面试2人次，所以需要3名面试官。
 * @date: 2022/6/15 10:56 下午
 * @version: V-1.0
 */
public class 招聘_0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //每人最多面试人数
        int m = Integer.parseInt(sc.nextLine());
        //总面试常数
        int n = Integer.parseInt(sc.nextLine());
        //每场面试的起始和结束时间 空格分开
        String[] startEndArr = new String[n];
        for (int i = 0; i < n; i++) {
            startEndArr[i] = sc.nextLine();
        }
        getMinInterViewerCount(m, n, startEndArr);
    }

    private static void getMinInterViewerCount(int m, int n, String[] startEndArr) {
        //使用List<List<Integer>>结构存储所有面试的起止时间
        List<List<Integer>> totalSEList = new ArrayList<>();
        //遍历startEndArr，拆分出起止时间，存入单个list中，并依次存入totalList中
        for (String s : startEndArr) {
            List<Integer> singleList = new ArrayList<>();
            String[] s_eArr = s.split(" ");
            singleList.add(Integer.parseInt(s_eArr[0]));
            singleList.add(Integer.parseInt(s_eArr[1]));
            if (!totalSEList.contains(singleList) && !singleList.isEmpty()) {
                totalSEList.add(singleList);
            }
            totalSEList.add(singleList);
        }
        //totalList按照结束时间升序排列
        totalSEList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(1).equals(o2.get(1))) {
                    return o1.get(0) - o1.get(0);
                }
                return o1.get(1) - o2.get(1);
            }
        });
        //需要面试官数量,面试场数>=1
        int count = 1;
        int time = 1;
        //如果当前面试的结束时间大于下场面试的开始时间，需要新增一名面试官
        for (int i = 0; i < n - 1; i++) {
            int preEnd = totalSEList.get(i).get(1);
            int nextStart = totalSEList.get(i + 1).get(0);
            if (time < m) {
                time++;
            } else if (time == m) {
                count++;
                time = 1;
            }
        }
        System.out.println(count);
    }
}
