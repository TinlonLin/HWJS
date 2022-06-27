package com.example.algorithmdemo.ExerciseDemo.code0625_状态机;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 五键键盘的输出_0625
 * @desc: 五键键盘的输出
 * https://blog.csdn.net/qq_43886548/article/details/123459660?spm=1001.2014.3001.5506
 * 5键键盘的输出
 * 有一个特殊的5键键盘，上面有a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键。
 * a键在屏幕上输出一个字母a；
 * ctrl-c将当前选择的字母复制到剪贴板；
 * ctrl-x将当前选择的字母复制到剪贴板，并清空选择的字母；
 * ctrl-v将当前剪贴板里的字母输出到屏幕；
 * ctrl-a选择当前屏幕上的所有字母。注意：
 * 1 剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
 * 2 当屏幕上没有字母时，ctrl-a无效
 * 3 当没有选择字母时，ctrl-c和ctrl-x无效
 * 4 当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出
 *
 * 给定一系列键盘输入，输出最终屏幕上字母的数量。
 *
 * 输入描述:
 * 输入为一行，为简化解析，用数字1 2 3 4 5代表a，ctrl-c，ctrl-x，ctrl-v，ctrl-a五个键的输入，数字用空格分隔
 * 输出描述:
 * 输出一个数字，为最终屏幕上字母的数量
 *
 * 示例1：
 * 输入
 * 1 1 1
 * 输出
 * 3
 * 说明
 * 连续键入3个a，故屏幕上字母的长度为3
 *
 * 示例2：
 * 输入
 * 1 1 5 1 5 2 4 4
 * 输出
 * 2
 * 说明
 * 输入两个a后ctrl-a选择这两个a，再输入a时选择的两个a先被清空，所以此时屏幕只有一个a，
 * 后续的ctrl-a，ctrl-c选择并复制了这一个a，最后两个ctrl-v在屏幕上输出两个a，
 * 故屏幕上字母的长度为2（第一个ctrl-v清空了屏幕上的那个a）
 * @date: 2022/6/21 11:16 下午
 * @version: V-1.0
 */


public class 五键键盘的输出_0625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operateStr = sc.nextLine();
        getOutputCount(operateStr);
    }

    private static void getOutputCount(String operateStr) {
        //输出的字母数量
        int count = 0;
        //复制的字母数量
        int copyCount = 0;
        //选中的字母数量
        int selectCount = 0;

        for (char operate : operateStr.toCharArray()) {
            if (operate == '1') {
                //a
                count = selectCount > 0 ? 1 : count + 1;
                selectCount = 0;
            } else if (operate == '2') {
                //复制
                copyCount = selectCount;
            } else if (operate == '3') {
                //剪切
                count -= selectCount;
                copyCount = selectCount;
                selectCount = 0;
            } else if (operate == '4') {
                //粘贴
                count -= selectCount;
                selectCount = 0;
                count += copyCount;
            } else if (operate == '5') {
                //全选
                selectCount = count;
            }
        }
        System.out.println(count);
    }
}
