package com.example.algorithmdemo.ExerciseDemo.code0617_贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: ShuZiTuSe_0617
 * @desc: 数字涂色
 * https://blog.csdn.net/weixin_44219664/article/details/123857124
 * 有N个正整数，需要给每个数上色，要求同种颜色的所有数都可以被最小的数整除
 * 计算最少需要多种颜色给这N个数上色
 * 输入描述：
 * 第一行 正整数N 1<= N <= 100
 * 第二行 N 个int型数，保证输入数据在[1,100]范围中，表示黑板上N个正整数的值
 * 输出描述：
 * 只有一个整数，为最少需要的颜色种数
 * 输入
 * 3
 * 2 4 6
 * 输出
 * 1
 * 说明：
 * 所有数都能被2整除
 *
 * 输入
 * 4
 * 2 3 4 9
 * 输出
 * 2
 * 说明：
 * 2与4涂一种颜色，4能被2整除
 * 3与9涂另一种颜色，9能被3整除
 * 不能涂同一种颜色
 * @date: 2022/6/16 9:34 下午
 * @version: V-1.0
 */
public class ShuZiTuSe_0617 {
    public static void main(String[] args) {
        int N = 3;
        String numStr = "2 4 6";
        System.out.println("输入：\n"+N +"\n" + numStr);
        System.out.println("输出：");
        getMinKindOfColor(N, numStr);


        int N1 = 4;
        String numStr1 = "2 3 4 9";
        System.out.println("输入：\n" + N1 +"\n" + numStr1);
        System.out.println("输出：");
        getMinKindOfColor(N1, numStr1);

        int N2 = 4;
        String numStr2 = "1 3 4 9";
        System.out.println("输入：\n" + N2 +"\n" + numStr2);
        System.out.println("输出：");
        getMinKindOfColor(N2, numStr2);

    }

    private static void getMinKindOfColor(int N, String numStr) {
        //将N个数存入List中
        String[] numStrArr = numStr.split(" ");
        int[] numArr = new int[N];
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(numStrArr[i]);
            numList.add(numArr[i]);
        }
        //升序排序，将最小的值放到最前面
        Collections.sort(numList);
        //特殊情况，最小值为1，它可以整除任何正整数，只有一种组合
        if (numList.get(0) == 1) {
            System.out.println(1);
            return;
        }
        //最小值非1，能被最小数整除的一类数中只保留最小值，最终list的大小即为需要的最小颜色种数
        for (int i = 0; i < numList.size(); i++) {
            int min = numList.get(i);
            for (int j = i + 1; j < numList.size();) {
                //如果可以被最小值整除，则移除该元素
                if (numList.get(j) % min == 0) {
                    numList.remove(j);
                } else {
                    j++;
                }
            }
        }
        System.out.println(numList.size());
    }
}
