package com.example.algorithmdemo.ExerciseDemo.code0610_排序;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: MinOfTwoAbsSum_0610
 * @desc: 乱序整数序列两数之和绝对值最小
 * https://blog.csdn.net/weixin_44219664/article/details/123835811
 * 输入描述：一串空格分割的整数序列字符串，整数范围在-65535，65355之间
 * 输出描述：两数之和绝对值最小时对应的两个数（从小到大）以及两数之和绝对值的最小值 空格分割
 * 输入：-1 -3 7 5 11 15
 * 输出：-3 5 2
 * @date: 2022/6/12 11:28 上午
 * @version: V-1.0
 */
public class 乱序整数序列两数之和绝对值最小_0610 {
    public static void main(String[] args) {
        String str = "-1 -3 7 5 11 15";
        System.out.println("输入:\n"+str);
        System.out.println("输出：");
        getMinAbsSum(str);
    }

    private static void getMinAbsSum(String str){
        //按空格分割并转为int数组
        String[] strArr = str.split(" ");
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        //双重遍历numArr,错开1，找和的绝对值最小值即对应的
        //和绝对值最小值
        int minAbsSum = 65355;
        int x = 0;
        int y = 0;
        for (int i = 0; i < numArr.length; i++) {
            for (int j = i+1; j < numArr.length; j++) {
                int absSum = Math.abs(numArr[i] + numArr[j]);
                if (absSum < minAbsSum) {
                    minAbsSum = absSum;
                    x = numArr[i];
                    y = numArr[j];
                }
            }
        }
        //找到最小值及对应下标后拼接输出
        StringBuilder builder = new StringBuilder();
        builder.append(x).append(" ").append(y).append(" ").append(minAbsSum);
        System.out.println(builder.toString());
    }
}
