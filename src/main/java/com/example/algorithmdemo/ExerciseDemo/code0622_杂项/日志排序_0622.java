package com.example.algorithmdemo.ExerciseDemo.code0622_杂项;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 日志排序_0622
 * @desc: 日志排序
运维工程师采集到某产品线网运行一天产生的日志n条
现需根据日志时间先后顺序对日志进行排序
日志时间格式为H:M:S.N
H表示小时(0~23)
M表示分钟(0~59)
S表示秒(0~59)
N表示毫秒(0~999)
时间可能并没有补全
也就是说
01:01:01.001也可能表示为1:1:1.1

输入描述
第一行输入一个整数n表示日志条数
1<=n<=100000
接下来n行输入n个时间

输出描述
按时间升序排序之后的时间
如果有两个时间表示的时间相同
则保持输入顺序

示例：
输入：
2
01:41:8.9
1:1:09.211
输出
1:1:09.211
01:41:8.9
示例
输入
3
23:41:08.023
1:1:09.211
08:01:22.0
输出
1:1:09.211
08:01:22.0
23:41:08.023
示例
输入
2
22:41:08.023
22:41:08.23
输出
22:41:08.023
22:41:08.23
时间相同保持输入顺序
 * https://www.nowcoder.com/questionTerminal/0f64518fea254c0187ccf0ea05019672
 * https://icode.best/i/16802040242113
 * @date: 2022/6/21 11:12 下午
 * @version: V-1.0
 */
public class 日志排序_0622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] timeStrArr = new String[n];
        for (int i = 0; i < n; i++) {
            timeStrArr[i] = sc.nextLine();
        }
        getSortedTime(n, timeStrArr);
    }

    private static void getSortedTime(int n, String[] timeStrArr) {
        //将字符串存入List并自定义根据整数值排序
        List<String> timeStrList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            timeStrList.add(timeStrArr[i]);
        }

        timeStrList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getIntTime(o1) - getIntTime(o2);
            }
        });
        //排序后依次输出
        for (String s : timeStrList) {
            System.out.println(s);
        }
    }

    //根据字符串计算串对应的整数值
    private static int getIntTime(String  timeStr) {
        String[] partTimeArr = timeStr.split(":");
        String[] part1TimeArr = partTimeArr[2].split("\\.");
        int h = Integer.parseInt(partTimeArr[0]);
        int m = Integer.parseInt(partTimeArr[1]);
        int s = Integer.parseInt(part1TimeArr[0]);
        int ms = Integer.parseInt(part1TimeArr[1]);
        return h * 60 * 60 * 1000 + m * 60 * 1000 + s * 1000 + ms;
    }
}
