package com.example.algorithmdemo.ExerciseDemo.code0611_位运算;

import java.nio.ByteBuffer;
import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: DataClassification_0611
 * @desc: 数据分类
 * https://blog.csdn.net/weixin_41010318/article/details/120731252
 * 对一个数据a进行分类
 * 分类方法是 此数据a(4个字节大小)的4个字节相加对一个给定值b取模 即 取余 %  --->关键点
 * 如果得到的结果小于一个给定的值c则数据a为有效类型
 * 其类型为取模的值
 * 如果得到的结果大于或者等于c则数据a为无效类型
 * <p>
 * 比如一个数据a=0x01010101 b=3
 * 按照分类方法计算  (0x01+0x01+0x01+0x01)%3=1
 * 所以如果c等于2 则此a就是有效类型  其类型为1
 * 如果c等于1 则此a是无效类型
 * <p>
 * 又比如一个数据a=0x01010103 b=3
 * 按分类方法计算(0x01+0x01+0x01+0x03)%3=0
 * 所以如果c=2则此a就是有效类型  其类型为0
 * 如果c等于0 则此a是无效类型
 * <p>
 * （重点）
 * 输入12个数据
 * 第一个数据为c  第二个数据为b
 * 剩余10个数据为需要分类的数据
 * <p>
 * 请找到有效类型中包含数据最多的类型
 * 并输出该类型含有多少个数据
 * <p>
 * 输入描述
 * 输入12个数据用空格分割
 * 第一个数据为c  第二个数据为b
 * 剩余10个数据为需要分类的数据
 * <p>
 * 输出描述
 * 请找到有效类型中包含数据最多的类型
 * 并输出该类型含有多少个数据
 * <p>
 * 实例：
 * 输入
 * 3 4 256 257 258 259 260 261 262 263 264 265
 * 输出
 * 3
 * 说明
 * 这10个数据4个字节相加后的结果分别是
 * 1 2 3 4 5 6 7 8 9 10
 * 故对4取模的结果为
 * 1 2 3 0 1 2 3 0 1 2
 * c是3所以012都是有效类型
 * 类型为1和2的有3个数据
 * 类型为0和3的只有两个
 * <p>
 * 例子2
 * 输入
 * 1 4 256 257 258 259 260 261 262 263 264 265
 * 输出
 * 2
 * @date: 2022/6/12 10:08 上午
 * @version: V-1.0
 */
public class 数据分类_0611 {
    public static void main(String[] args) {
        String str = "3 4 256 257 258 259 260 261 262 263 264 265";
        System.out.println("输入：\n" + str);
        System.out.println("输出：");
        //输出 3
        getMostTypeCount(str);

        String str1 = "1 4 256 257 258 259 260 261 262 263 264 265";
        System.out.println("输入：\n" + str1);
        System.out.println("输出：");
        //输出 2
        getMostTypeCount(str1);
    }

    private static void getMostTypeCount(String str) {
        //按空格分割并转为int数组
        String[] strArr = str.split(" ");
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        //第一个第二个值分别为c、b
        int c = numArr[0];
        int b = numArr[1];
        //遍历处理剩余的10个数，i从2开始，求每个数字节和及取模得到的类型，将类型及出现的次数存入map中
        Map<Integer, Integer> typeCountMap = new HashMap<>();
        for (int i = 2; i < numArr.length; i++) {
            //关键：将值转为字节值并计算字节和，使用到ByteBuffer的方法分配四个字节大小
            byte[] numByte = ByteBuffer.allocate(4).putInt(numArr[i]).array();
            int sum = 0;
            for (byte b1 : numByte) {
                sum += b1;
            }
            //取模的结果，对应 类型
            int result = 0;
            result = sum % b;
            //小于c才有效，存入map中，并计数
            if (result < c) {
                if (!typeCountMap.containsKey(result)) {
                    typeCountMap.put(result, 1);
                } else {
                    typeCountMap.replace(result, typeCountMap.get(result) + 1);
                }
            }
        }
        //遍历处理完后，将Map的Entry存入List中，并根据value即次数降序排序，第一个值对应的value即为题目所求的最大次数
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(typeCountMap.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println(list.get(0).getValue());
    }
}
