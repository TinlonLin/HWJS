package com.example.algorithmdemo.ExerciseDemo.code0704_BFS广搜图;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 计算疫情扩散时间_0704
 * @desc: 计算疫情扩散时间
 * https://blog.csdn.net/weixin_44224529/article/details/116904481
 * https://blog.csdn.net/qq_38584967/article/details/124844936
 *
【计算疫情扩散时间】在一个地图中(地图由n*n个区域组成），有部分区域被感染病菌。
感染区域每天都会把周围（上下左右）的4个区域感染。
请根据给定的地图计算，多少天以后，全部区域都会被感染。
如果初始地图上所有区域全部都被感染，或者没有被感染区域，返回-1
输入描述：
一行NN个数字（只包含0,1，不会有其他数字）表示一个地图，
数字间用,分割，0表示未感染区域，1表示已经感染区域 每N个数字表示地图中一行，输入数据共表示N行N列的区域地图。
例如输入1,0,1,0,0,0,1,0,1，表示地图
1,0,1
0,0,0
1,0,1
输出描述：
一个整数，表示经过多少天以后，全部区域都被感染 1<=N<200
示例1：
输入
1,0,1,0,0,0,1,0,1
输出
2

 *
 * @date: 2022/6/21 11:23 下午
 * @version: V-1.0
 */
public class 计算疫情扩散时间_0704 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numStrArr = sc.nextLine().split(",");
        int[] nums = new int[numStrArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numStrArr[i]);
        }
        spreadDay(nums);
    }

    /**
     *  //bfs 方式，结束条件 Arrays.stream(nums).sum() == nums.length
     *
     */
    public static void spreadDay(int[] nums){
        //初始化
        int n = (int) Math.sqrt(nums.length);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) {
                queue.offer(i);
            }
        }
        if(Arrays.stream(nums).sum() == nums.length || Arrays.stream(nums).sum() == 0){
            System.out.println(-1);;
            return;
        }
        int day = 0;
        //开始扩散
        while (!queue.isEmpty()){
            int size = queue.size();
            //判断是否已全部感染
            if(Arrays.stream(nums).sum() == nums.length){
                System.out.println(day);
                return;
            }
            for(int i = 0; i < size; i++){
                //取得当前感染的区域
                int index = queue.poll();
                //感染 上下左右对应下标的区域
                spread(queue, index-n, nums);
                spread(queue, index-1, nums);
                spread(queue, index+1, nums);
                spread(queue, index+n, nums);
            }
            day++;
        }
        System.out.println(day);;
    }

    /**
     * 感染扩散
     * @param queue
     * @param index
     * @param nums
     */
    public static void spread(Queue<Integer> queue, int index, int[] nums){
        if(index >= 0 && index < nums.length && nums[index] == 0) {
            nums[index] = 1;
            queue.offer(index);
        }
    }

}
