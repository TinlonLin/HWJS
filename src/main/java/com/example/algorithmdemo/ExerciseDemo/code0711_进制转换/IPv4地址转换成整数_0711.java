package com.example.algorithmdemo.ExerciseDemo.code0711_进制转换;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: IPv4地址转换成整数_0711
 * @desc: IPv4地址转换成整数
 * https://blog.csdn.net/qq_34465338/article/details/125050489
 *

输入：
100#101#1#5
输出：
1684340997

输入：
1#2#3
输出：
invalid IP
 *
 * @date: 2022/6/21 11:28 下午
 * @version: V-1.0
 */
public class IPv4地址转换成整数_0711 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] strings = sc.nextLine().split("#");
            int len = strings.length;
            long count = 0; //需要用long类型
            boolean isF = true;

            if(len==4){
                for(int i=0;i<len;i++){
                    long n = Integer.valueOf(strings[i]);
                    //第一节 1~128
                    if(i==0 && (n<1 || n>128)){
                        isF = false;
                        break;
                    }else if(n<0 || n>255){
                        //二、三、四节 0~255
                        isF = false;
                        break;
                    }
                    /**
                     * 首先使用把IP地址分成4个数字： 128 199 231 44
                     *
                     * 把每个数字转换为2进制，如果转换后这个数字对应的二进制数不够8位，在左侧补0： 10000000 11000111 11100111 00101100
                     */
                    count += n<<(8*(3-i));
                }
            }else {
                isF = false;
            }

            if(isF){
                System.out.println(count);
            }else {
                System.out.println("invalid IP");
            }
        }
}
