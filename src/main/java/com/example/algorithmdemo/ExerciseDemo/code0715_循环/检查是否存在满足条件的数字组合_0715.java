package com.example.algorithmdemo.ExerciseDemo.code0715_循环;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 检查是否存在满足条件的数字组合_0715
 * @desc: 检查是否存在满足条件的数字组合
 * https://blog.csdn.net/qq_34465338/article/details/124962351
 *
输入：
4
2 7 3 0
输出：
7 3 2
 *
 * @date: 2022/6/21 11:32 下午
 * @version: V-1.0
 */
public class 检查是否存在满足条件的数字组合_0715 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            List<Integer> numList = new ArrayList<>();
            for(int i=0;i<n;i++){
                numList.add(sc.nextInt());
            }

            List<String> list = new ArrayList<>();

            //对输入的list遍历 为A
            for(int i=0;i<numList.size();i++){
                int A = numList.get(i);
                for(int j=0;j<numList.size();j++){
                    //对输入的list遍历 为B
                    if(i==j){
                        //下标相同为同一值，跳过
                        continue;
                    }
                    int B = numList.get(j);
                    for(int k=0;k<numList.size();k++){
                        if(i==k || j==k){
                            //下标相同为同一值，跳过
                            continue;
                        }
                        int C = numList.get(k);
                        if(A == B + 2*C ){
                            //进行A=B+2C处理判断
                            String res = A +" "+ B +" "+ C;
                            list.add(res);
                        }
                    }
                }
            }

            if(list.size()==0){
                System.out.println(0);
            }else {
                list.forEach(v->{
                    System.out.println(v);
                });
            }
        }

}
