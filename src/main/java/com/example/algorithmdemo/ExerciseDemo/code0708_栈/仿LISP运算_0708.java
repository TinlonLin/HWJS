package com.example.algorithmdemo.ExerciseDemo.code0708_栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 仿LISP运算_0708
 * @desc: 仿LISP运算
 * https://blog.csdn.net/qq_34465338/article/details/124446240
 *
LISP语言唯一的语法就是括号要配对
形如（OP P1 p2...）括号内的元素由单个空格分割。
其中第一个元素OP为操作符，后续元素均为其参数，参数个数取决于操作符类型
注意：参数P1，P2也可能是另外一个嵌套的（OP P1 P2...）
当前OP类型为 add/sub/mul/div（全小写），分别代表整数的加减乘除
简单起见，所有OP的参数个数均为2
举例;
输入：(mul 3 -7) 输出：-21
输入：(add 1 2) 输出：3
输入：(sub (mul 2 4) (div 9 3)) 输出：5
输入：(div 1 0) 输出：error

题目涉及数字均为整数，可能为负，不考虑32位溢出翻转，计算过程中也不会发生32位溢出翻转
除零错误时，输出“error”，除法遇除不尽，向下取整，即3/2=1

输入描述:
输入为不超过512的字符串，用例保证无语错误
输出描述
输出计算结果或“error”

示例1
输入：
(div 12 (sub 45 45))
输出：
error

示例2
输入：
(add 1 (div -7 3))
输出：
-2
、
思路：
1.通过空格对输入字符串分割
2.对步骤1获取的数组遍历，将数字和符号分别存入各自队列中
符号 add：加法 sub：减法 mul：乘 div：除法
3.遇到“)” 开始计算，从数组中取租后两个数字，从符号数组中取最后符号计算
 *
 * @date: 2022/6/21 11:27 下午
 * @version: V-1.0
 */
public class 仿LISP运算_0708 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //按空格分割
        String[] str = sc.nextLine().split(" ");
        getCalResult(str);
    }

    private static void getCalResult(String[] str) {
        //符号队列
        Deque<String> opDeque = new ArrayDeque<>();
        //数字队列
        Deque<Integer> numDeque = new ArrayDeque<>();
        //是否错误，除数为0
        boolean isError = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i].contains("(add")) {
                opDeque.push("+");
            } else if (str[i].contains("(sub")) {
                opDeque.push("-");
            } else if (str[i].contains("(mul")) {
                opDeque.push("*");
            } else if (str[i].contains("(div")) {
                opDeque.push("/");
            } else if (str[i].contains(")")) {
                //前面的数字字符串
                String numStr = "";
                for (int j = 0; j < str[i].length(); j++) {
                    //多个)需要计算多次
                    if (')' == str[i].charAt(j)) {
                        if (numStr.length() != 0) {
                            numDeque.push(Integer.parseInt(numStr));
                            //将数字字符串置空
                            numStr = "";
                        }
                        int b = numDeque.pop();
                        int a = numDeque.pop();
                        String op = opDeque.pop();
                        //除数为0终止循环，输出error
                        if ("/".equals(op) && 0 == b) {
                            isError = true;
                            break;
                        } else {
                            numDeque.push(cal(a, b, op));
                        }
                    } else {
                        //未到“)”都为数字，拼接
                        numStr += str[i].charAt(j);
                    }
                }
            } else {
                numDeque.push(Integer.parseInt(str[i]));
            }
//            if (isError) {
//                break;
//            }
        }

        if (isError) {
            System.out.println("error");
        } else {
            System.out.println(numDeque.pop());
        }
    }
    /** 计算 */
    private static int cal(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                //向下取整
                return Math.floorDiv(a, b);
            default:
                return 0;
        }
    }
}
