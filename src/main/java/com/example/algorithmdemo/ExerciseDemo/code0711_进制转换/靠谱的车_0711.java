package com.example.algorithmdemo.ExerciseDemo.code0711_进制转换;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 靠谱的车_0711
 * @desc: 靠谱的车
 * https://blog.csdn.net/m0_64656053/article/details/124095146
程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。

出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。

你能根据计费表的数字，计算出实际的数字吗？

示例1、input 5 output 4

示例2、input 17 output 15

示例3、input 100 output 81

示例4、input 500 output 324

 * @date: 2022/6/21 11:28 下午
 * @version: V-1.0
 */
public class 靠谱的车_0711 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入数字");
        String wrongNum = scanner.nextLine();
        char[] chars = wrongNum.toCharArray();
        // 实际数字
        int factNum = 0;
        for (int i = 0; i <chars.length; i++) {
            int num = Integer.parseInt(String.valueOf(chars[i]));
            if (num>4) {
                num = (num - 1);
            }
            // 做个循环，计算num*9^9...
            for (int k = chars.length - i - 1 ; k > 0; k--){
                num = num * 9;
            }
            factNum = factNum + num;
        }
        System.out.println(factNum);
    }
}
