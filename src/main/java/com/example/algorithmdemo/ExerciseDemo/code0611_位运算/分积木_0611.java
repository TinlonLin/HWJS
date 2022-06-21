package com.example.algorithmdemo.ExerciseDemo.code0611_位运算;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: DivideBlocks_0611
 * @desc: 分积木
 * https://www.nowcoder.com/discuss/837528?order=0&pos=9&page=1
 * https://blog.csdn.net/qq_40016949/article/details/113762549
 * 哥哥弟弟分一堆积木，每块积木重量不同。弟弟要求平分两组，每组数量可以不同但总重量必须相等。
 * 然而弟弟只会二进制并且加法不进位。例如三块积木 3,5,6 分成两组 [3] 和 [5,6]
 * 弟弟认为 5（二进制1001）加上6（二进制1010）是0011：
 * 0101
 * 0110
 * -------
 * 0011
 * 然后 3 的二进制也是 0011，所以弟弟认为两组积木等重，接受这种分配方案。哥哥实际能分到 5+6=11 块积木。
 * 要求输出哥哥能拿的最大实际重量。如果给定的积木没法按弟弟视角分成重量相等的两组，就输出‘NO’。
 * 样例
 * 输入：5,6,3
 * 输出：11
 * @date: 2022/6/12 9:51 上午
 * @version: V-1.0
 */
public class 分积木_0611 {
    public static void main(String[] args) {
        String str = "5,6,3";
        System.out.println("输入：\n" + str);
        System.out.println("输出：");
        //输出：11
        getRealMaxWeight(str);
    }

    private static void getRealMaxWeight(String str) {
        String[] strArr = str.split(",");
        //先考虑不满足题意的情况
        if (strArr.length <= 1) {
            System.out.println("NO");
            return;
        }
        //只有两个值但不相等
        if (strArr.length == 2 && (Integer.parseInt(strArr[0]) != Integer.parseInt(strArr[1]))) {
            System.out.println("NO");
            return;
        }
        //转为int数组
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        //正常情况，弟弟的运算方法为异或运算(有交换和结合律)，哥哥的运算方法为正常累加
        //重量最小值取第一个值
        int min = numArr[0];
        //哥哥方式总总量
        int bigSum = min;
        //弟弟方式总重量
        int smallSum = min;
        //从第二个数开始
        for (int i = 1; i < numArr.length; i++) {
            //获取最小重量
            if (min > numArr[i]) {
                min = numArr[i];
            }
            bigSum += numArr[i];
            smallSum ^= numArr[i];
        }
        //如果存在相等两组，则总体异或结果为0,当弟弟取最小的值时哥哥拿到的实际重量最大
        if (smallSum == 0) {
            System.out.println(bigSum - min);
        } else {
            System.out.println("NO");
        }
    }
}
