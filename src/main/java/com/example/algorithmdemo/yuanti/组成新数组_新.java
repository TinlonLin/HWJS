package com.example.algorithmdemo.yuanti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 组成新数组_习
 * @desc: 100%
 * @date: 2022/7/16 11:36 上午
 * @version: V-1.0
 */
public class 组成新数组_新 {
    /*
        现在有多组整数数组
        需要将他们合并成一个新的数组
        合并规则从每个数组里按顺序取出固定长度的内容
        合并到新的数组
        取完的内容会删除掉
        如果改行不足固定长度，或者已经为空
        则直接取出剩余部分的内容放到新的数组中继续下一行

        输入描述
          第一 行每次读取的固定长度
          长度0<len<10
          第二行是整数数组的数目
          数目 0<num<10000
          第3~n行是需要合并的数组
          不同的数组用换行分割
          元素之间用逗号分割
          最大不超过100个元素

         输出描述
          输出一个新的数组，用逗号分割

          示例1
          输入
              3
              2
              2,5,6,7,9,5,7
              1,7,4,3,4
          输出
              2,5,6,1,7,4,7,9,5,3,4,7

          说明  获得长度3和数组数目2
             先遍历第一行 获得2,5,6
             再遍历第二行 获得1,7,4
             再循环回到第一行获得7,9,5
             再遍历第二行获得3,4
             再回到第一行获得7

          示例2
          输入
             4
             3
             1,2,3,4,5,6
             1,2,3
             1,2,3,4
           输出
             1,2,3,4,1,2,3,1,2,3,4,5,6
         */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            String[] arr = scanner.nextLine().split(",");
            sum += arr.length;
            list.add(new ArrayList<String>(Arrays.asList(arr)));
        }
        while (res.size() != sum) {
            for (ArrayList<String> strList : list) {
                if (strList.size() == 0) continue;
                int times = Math.min(strList.size(), len);
                for (int i = 0; i < times; i++) {
                    res.add(strList.remove(0));
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String str : res) {
            builder.append(str).append(",");
        }
        String resStr = builder.toString();
        System.out.println(resStr.substring(0, resStr.length() - 1));

        scanner.close();
    }
}
