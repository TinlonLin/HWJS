package com.example.algorithmdemo.ExerciseDemo.code0620_贪心;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 分糖果
 * @desc: 分糖果
 * https://blog.csdn.net/weixin_44219664/article/details/124240193
 * 小明从糖果盒中随意抓一把糖果
 * 每次小明会取出一半分给同学们
 * 当糖果不能平均分配时，小明可以从糖果盒中（假设盒中糖果足够）取出一个或放回一个糖果
 * 小明至少需要多少次（取出放回和平均分配均记一次）能将手中的糖果分至只剩一颗
 * 输入描述：
 * 抓取糖果数（小于1000000）：15
 * 输出描述：
 * 最少分至一颗糖果的次数
 * <p>
 * 示例1：
 * 输入:
 * 15
 * 输出：
 * 5
 * 注：
 * 1）15+1=16
 * 2) 16/2=8
 * 3) 8/2=4
 * 4) 4/2=2
 * 5) 2/2=1
 * @date: 2022/6/19 4:39 下午
 * @version: V-1.0
 */
public class 分糖果_0620 {
    public static void main(String[] args) {
        int n = 15;
        getMinCount(n);
    }

    private static void getMinCount(int n) {
        int count = 0;
        while (n > 1) {
            //n为偶数
            if (n % 2 == 0) {
                n /= 2;
                count++;
            } else {
                //奇数出现的次数越少，分糖果的步骤越少
                if ((n - 1) / 2 == 1 || (n - 1) / 2 % 2 == 0) {
                    n--;
                } else {
                    n++;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
