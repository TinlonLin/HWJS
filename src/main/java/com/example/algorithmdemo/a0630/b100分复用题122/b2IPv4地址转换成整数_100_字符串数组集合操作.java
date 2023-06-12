package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b2IPv4地址转换成整数_100_字符串数组集合操作
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127641506
题目描述：
存在一种虚拟IPv4地址，由4小节组成，每节的范围为0~255，以#号间隔，虚拟IPv4地址可以转换为一个32位的整数，例如：
128#0#255#255，转换为32位整数的结果为2147549183（0x8000FFFF）
1#0#0#0，转换为32位整数的结果为16777216（0x01000000）
现以字符串形式给出一个虚拟IPv4地址，限制第1小节的范围为1~128，即每一节范围分别为(1~128)#(0~255)#(0~255)#(0~255)，要求每个IPv4地址只能对应到唯一的整数上。
如果是非法IPv4，返回invalid IP
输入描述：
输入一行，虚拟IPv4地址格式字符串
输出描述：
输出一行，按照要求输出整型或者特定字符
备注：
输入不能确保是合法的IPv4地址，需要对非法IPv4（空串，含有IP地址中不存在的字符，非合法的#分十进制，十进制整数不在合法区间内）进行识别，返回特定错误

用例
输入
100#101#1#5
输出
1684340997

输入
1#2#3
输出
invalid IP

 * @date: 2023/6/4 8:46
 * @version: V-1.0
 */
public class b2IPv4地址转换成整数_100_字符串数组集合操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    private static String getResult(String s) {
        String[] ip = s.split("#");

        // ip地址由四部分组成，少于或多于四部分都不合法
        if (ip.length != 4) {
            return "invalid IP";
        }

        // 如果ip地址四部分某部分不合法，则ip不合法
        if (!isValid(ip[0], 1, 128)
                || !isValid(ip[1], 0, 255)
                || !isValid(ip[2], 0, 255)
                || !isValid(ip[3], 0, 255)) {
            return "invalid IP";
        }

        // 这里需要转为long，某些情况使用int会整型溢出
        return Long.parseLong(
                getHexString(ip[0]) + getHexString(ip[1]) + getHexString(ip[2]) + getHexString(ip[3]),
                16)
                + "";
    }

    // ip组成是否合法
    private static boolean isValid(String s, int from, int to) {
        // 如果包含非数字字符，则不合法
        if (!s.matches("^\\d+$")) {
            return false;
        }

        // 如果包含前导0，则不和法，如012
        int num = Integer.parseInt(s);
        if (!s.equals(num + "")) {
            return false;
        }

        // 如果不是规定范围，则不合法
        return num >= from && num <= to;
    }

    // 获取十进制数字符串对应的十六进制数字符串
    private static String getHexString(String num) {
        String hexStr = Integer.toHexString(Integer.parseInt(num));
        // 补足前导0
        if (hexStr.length() < 2) {
            hexStr = "0" + hexStr;
        }
        return hexStr;
    }
}
