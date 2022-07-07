package com.example.algorithmdemo.ExerciseDemo.code0708_栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 解压报文_0708
 * @desc: 解压报文
 * https://blog.csdn.net/qq_34465338/article/details/125329898?spm=1001.2014.3001.5506
 *
为了提升数据传输的效率，会对传输的报文进行压缩处理。
输入一个压缩后的报文，请返回它解压后的原始报文。
压缩规则：n[str]，表示方方括号内部的str正好重复n次。注意n为正整数（0<n<=100）
str质保函小写英文字母，不考虑异常情况。

输入描述：
输入压缩后的报文
1)不考虑无效输入，报文没有额外的空格，方括号总是符合格式要求的
2)原始报文不包含数字，所有的数字只表示重复的次数n，例如不会出现像5b或2[8]的输入
输出描述：
解压后的原始报文
注：原始报文长度不会超过1000，不考虑异常的情况

示例1：
输入：
3[k]2[mn]
输出：
kkkmnmn

示例2：
输入：
3[m2[c]]
输出：
mccmccmcc

思路：
括号问题联想到栈，使用双向队列Deque实现
1.遍历字符串，将数字和字母存入各自队列
2.遇到 ] 时，取队列最上面的数字和字母，进行解压
3.将步骤2解压出的字符与子队列中最上层的字符拼接，用于下次解压
4.重复步骤1，直至遍历完整个字符串
 *
 * @date: 2022/6/21 11:27 下午
 * @version: V-1.0
 */
public class 解压报文_0708 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String zippedStr = sc.nextLine();
        getUnzipStr(zippedStr);
    }

    private static void getUnzipStr(String zippedStr) {
        //解压后的字符串
        StringBuilder res = new StringBuilder();
        //处理多位数
        String numStr = "";
        //数字队列
        Deque<Integer> numDeque = new ArrayDeque<>();
        //处理后的字母队列
        Deque<StringBuilder> letterDeque = new ArrayDeque<>();
        for (int i = 0; i < zippedStr.length(); i++) {
            char c = zippedStr.charAt(i);
            if (Character.isDigit(c)) {
                //数字前的字母暂不处理
                if (res.length() != 0) {
                    letterDeque.push(res);
                    res = new StringBuilder();
                }
                numStr += c;
            } else if ('[' == c) {
                //数字放入数字队列
                numDeque.push(Integer.parseInt(numStr));
                numStr = "";
            } else if (']' == c) {
                //遇到],则取出最上面的数字解压
                int n = numDeque.pop();
                if (res.length() != 0) {
                    letterDeque.push(res);
                    res = new StringBuilder();
                }
                //取出最上面的字母
                StringBuilder tmpLetter = letterDeque.pop();
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    //对字母解压（拼接n个）
                    builder.append(tmpLetter);
                }
                if (letterDeque.isEmpty()) {
                    letterDeque.push(builder);
                } else {
                    letterDeque.push(letterDeque.pop().append(builder));
                }
            } else {
                res.append(c);
            }
        }
//        for (StringBuilder builder : letterDeque) {
//            System.out.println(builder.toString());
//        }
        System.out.println(letterDeque.peekFirst().toString());
    }
}
