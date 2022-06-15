package com.example.algorithmdemo.ExerciseDemo.code0616_贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: CalCarCount_0616
 * @desc: 停车场车辆统计
 * https://blog.csdn.net/weixin_44219664/article/details/124545587
 * 特定大小的停车场数组 cars
 * 其中 1代表有车 0代表没车
 * 车辆大小不一 小车占一个车位（长度1）货车占两个车位（长度2）卡车占三个车位（长度3）
 * 统计 停车场 最少可以停多少辆车
 * 返回具体的数目
 * <p>
 * 输入描述：
 * 整型字符串数组 cars，其中1表示有车，0表示没车 数组长度小于1000
 * 输出描述：
 * 整型数字字符串 表示最少停车数
 * <p>
 * 示例1：
 * 输入：
 * 1,0,1
 * 输出：
 * 2
 * 示例2：
 * 输入：
 * 1,1,0,0,1,1,1,0,1
 * 输出：
 * 3
 * @date: 2022/6/15 10:23 下午
 * @version: V-1.0
 */
public class CalCarCount_0616 {
    public static void main(String[] args) {
        String carStr = "1,0,1";
        System.out.println("输入：\n" + carStr);
        System.out.println("输出：");
        getMinCarCount(carStr);

        String carStr1 = "1,1,0,0,1,1,1,0,1";
        System.out.println("输入：\n" + carStr1);
        System.out.println("输出：");
        getMinCarCount(carStr1);
    }

    private static void getMinCarCount(String carStr) {
        //先根据","将数字字符串拆出来
        String[] tmpCarArr = carStr.split(",");
        //再拼接成字符串后根据0拆分出有车的数组，并存入List中
        StringBuilder builder = new StringBuilder();
        for (String s : tmpCarArr) {
            builder.append(s);
        }
        String[] carArr = builder.toString().split("0");
        //拆分出的可能有空串，将非空的串（所有车位串）存入List
        List<String> carList = new ArrayList<>();
        for (String s : carArr) {
            if (s.length() != 0) {
                carList.add(s);
            }
        }
        //遍历车位数组，尽可能存长度大的车，即按 3 2 1 的优先级找
        //最小的车辆数
        int minCount = 0;
        for (String s : carList) {
            //每个车位数组的长度，每个数组都取最小车数
            int count = 0;
            //先考虑特殊情况，长度为3或2倍数
            if (s.length() % 3 == 0) {
                count += s.length() / 3;
            } else if (s.length() % 2 == 0) {
                count += s.length() / 2;
            } else if (s.length() % 3 >= 1) {
                //长度比三的倍数还长1或2的情况
                if (s.length() % 3 % 2 == 0) {
                    count += s.length() % 3 / 2;
                } else {
                    count += s.length() % 3 % 2;
                }
            }
            minCount += count;
        }
        //遍历所有数组后输出总的最小数
        System.out.println(minCount);
    }
}
