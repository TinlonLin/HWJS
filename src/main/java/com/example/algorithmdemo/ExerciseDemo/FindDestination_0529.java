package com.example.algorithmdemo.ExerciseDemo;

import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/5/30 0:32
 * @ClassName: findDestinaion_0529
 * @Desc: 找终点
 * https://blog.csdn.net/weixin_42973768/article/details/121531225
 * https://blog.csdn.net/weixin_44219664/article/details/123809478
 * @Version: V-1.0
 * 输入：
 * 7 5 9 4 2 6 8 3 5 4 3 9
 * 输出：
 * 2
 * 输入：
 * 1 2 3 7 1 5 9 3 2 1
 * 输出：
 * -1
 * 说明：第一步：第一个可选步长选择2，第一个成员7走第2个成员，第二步，第2个成员为9，经过9个成员到最后
 *
 * 给定一个正整数数组，最大为100个成员，从第一个成员开始，走到数组最后一个成员最少的步骤数。
 * 第一步必须从第一元素开始，1<=步长<len/2, 第二步开始以所在成员的数字走相应的步数，如果目标不可达返回-1，只输出最少的步骤数。
 */
public class FindDestination_0529 {
    private static int[] input = null;
    private static int step = 0;
    public static void main(String[] args) {

    String str1 = "7 5 9 4 2 6 8 3 5 4 3 9";
    findMinStep(str1);

    String str2 = "1 2 3 7 1 5 9 3 2 1";
    findMinStep(str2);

    }

    private static void findMinStep(String str) {
        String[] inputStr = str.split(" ");
        /** 输入数组的长度 */
        int len = inputStr.length;
        input = new int[len];
        for (int i = 0; i < len; i++) {
            input[i] = Integer.parseInt(inputStr[i]);
        }
        /** 对结果去重排序 */
        TreeSet<Integer> set = new TreeSet<>();
        /** 最小步数，最少两步 */
        int minStep = 2;
        for (int i = 1; i < len/2; i++) {
            /** 走的步数，第一步必须走 */
            int step= 1;
            set.add(getStep(i,i));

        }
        System.out.println(set.first());
    }

    /** 递归获取步数 */
    private static int getStep(int index, int nexIndex) {
        /** 每步走的距离 */
        int stepLen = input[index];
        if (nexIndex == input.length - 1) {
            return step;
        } else if (nexIndex < input.length -1) {
            step++;
            return getStep(nexIndex, nexIndex + stepLen);
        } else {
            return -1;
        }
    }
}