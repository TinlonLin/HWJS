package com.example.algorithmdemo.ExerciseDemo.code0704_BFS广搜图;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 跳格子游戏_0704
 * @desc: 跳格子游戏
 * https://blog.csdn.net/qq_34465338/article/details/124497822
 *
输入：
3
0 1
0 2
输出：
yes

输入：
6
0 1
0 2
0 3
0 4
0 5
输出:
yes

输入:
2
1 0
0 1
输出：
no

输入：
5
4 3
0 4
2 1
3 2
输出:
yes

输入：
4
1 2
1 0
输出：
yes
 *
 * @date: 2022/6/21 11:23 下午
 * @version: V-1.0
 */
public class 跳格子游戏_0704 {
    public static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isTrue = true;

        while (sc.hasNext()){

            int key = sc.nextInt();

            //题目没有输出条件，可以使用-1输出
            if(key == -1){
                break;
            }
            if(key <0 || key>n){
                System.out.println("输入有误");
                return;
            }

            int value = sc.nextInt();

            if(value <0 || value>n){
                System.out.println("输入有误");
                return;
            }

            List<Integer> listChild = new ArrayList<>();
            listChild.add(key);
            listChild.add(value);
            list.add(listChild);
        }

        int len = list.size();
        for (int i=0;i<len;i++){
            if(isBH(list.get(i))){
                isTrue = false;
                break;
            }
        }

        System.out.println(isTrue ? "yes" : "no");
    }

    /**
     * {4,3}{0,4}{2,1}{3,2}{2,0}
     * 遍历所有的键值对
     *例：
     *  从第一个{4,3}开始
     *  {4,3}->{3,2}  {4,3,2}
     *      ┊
     *      --{4,3,2}->{2,1}  {4,3,2,1}
     *      ┊
     *      --{4,3,2}->{2,0} {4,3,2,0}
     *          ┊
     *          --{4,3,2,0}->{0,4}  {4,3,2,0}中包含4产生闭环，返回false
     */
    public static boolean isBH(List<Integer> listC){

        for(int i=0;i<list.size();i++){
            List<Integer> temp = list.get(i);
            if(temp.get(0) == listC.get(listC.size()-1)){
                if(listC.contains(temp.get(1))){
                    return true;
                }
                listC.add(temp.get(1));
                isBH(listC);
            }
        }
        return false;
    }
}
