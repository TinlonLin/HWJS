package com.example.algorithmdemo.ExerciseDemo.code0621_杂项;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 最多可以派出多少支团队_0621
 * @desc: 最多可以派出多少只团队
 * https://blog.csdn.net/weixin_44219664/article/details/124003825
 * https://blog.csdn.net/weixin_44052055/article/details/123957841
用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为N，每个团队可以由1人或2人组成，
且1个人只能参加1个团队， 请计算出最多可以派出多少支符合要求的团队？

输入描述:
5
3 1 5 7 9
8
第一行数组代表总人数，范围[1,500000]
第二行数组代表每个人的能力，每个元素的取值范围[1, 500000]，数组的大小范围[1,500000]
第三行数值为团队要求的最低能力值，范围[1, 500000]
输出描述：
3
最多可以派出的团队数量
示例 1：

输入
5
3 1 5 7 9
8
输出
3
说明
3,5组成一队，1,7组成一队，9自己一个队，故输出3

示例 2：

输入
7
3 1 5 7 9 2 6
8
输出
4
说明
1、7组成一队 3、5一队 2、6一队 9自己一队 输出4

示例 3：

输入
3
1 1 9
8
输出
1

 * @date: 2022/6/19 8:47 下午
 * @version: V-1.0
 */
public class 求最多可以派出多少支团队_0621 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> abilityList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            abilityList.add(sc.nextInt());
        }
        Collections.sort(abilityList);
        int N = sc.nextInt();
        getMaxCountOfTeam(n, abilityList, N);
    }

    private static void getMaxCountOfTeam(int n, List<Integer> abilityList, int N) {
        //最多团队数
        int count = 0;
        //单个可以达到最低能力
        for (Integer integer : abilityList) {
            if (integer >= N) {
                count++;
            }
        }
        //双指针，在剩余的n-count个数字里面寻找满足条件的两个值
        int left = 0;
        int right = n - count - 1;
        while (left < right) {
            if (abilityList.get(left) + abilityList.get(right) >= N) {
                count++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        System.out.println(count);
    }
}
