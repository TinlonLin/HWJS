package com.example.algorithmdemo.ExerciseDemo.code0613_排序;

import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: DivideClass_0613
 * @desc: 分班（寻找同班小朋友）
 * https://blog.csdn.net/weixin_41010318/article/details/120784031
 * 幼儿园两个班的小朋友排队时混在了一起
 * 每个小朋友都知道自己跟前面一个小朋友是不是同班
 * 请你帮忙把同班的小朋友找出来
 * 小朋友的编号为整数
 * 与前面一个小朋友同班用Y表示
 * 不同班用N表示
 * 输入描述：
 * 输入为空格分开的小朋友编号和是否同班标志
 * 比如 6/N 2/Y 3/N 4/Y
 * 表示一共有4位小朋友
 * 2和6是同班 3和2不同班 4和3同班
 * 小朋友总数不超过999
 *  0< 每个小朋友编号 <999
 *  不考虑输入格式错误
 *
 *  输出两行
 *  每一行记录一班小朋友的编号  编号用空格分开
 *  并且
 *  1. 编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行
 *  2. 如果只有一个班的小朋友 第二行为空
 *  3. 如果输入不符合要求输出字符串ERROR
 *
 *  示例：
 *  输入
 *  1/N 2/Y 3/N 4/Y
 *  输出
 *  1 2
 *  3 4
 *  说明：
 *  2的同班标记为Y因此和1同班
 *  3的同班标记位N因此和1,2不同班
 *  4的同班标记位Y因此和3同班
 * @date: 2022/6/12 10:10 上午
 * @version: V-1.0
 */
public class 分班_0613 {
    public static void main(String[] args) {
        //正常1
        String str = "6/N 2/Y 3/N 4/Y";
        System.out.println("输入：\n"+str);
        System.out.println("输出：");
        getTwoClassStuNum(str);
        //正常2
        String str1 = "1/N 2/Y 3/N 4/Y";
        System.out.println("输入：\n"+str1);
        System.out.println("输出：");
        getTwoClassStuNum(str1);
        //只有一个班
        String str2 = "6/N";
        System.out.println("输入：\n"+str2);
        System.out.println("输出：");
        getTwoClassStuNum(str2);
        //输入为空，非法
        String str3 = "";
        System.out.println("输入：\n"+str3);
        System.out.println("输出：");
        getTwoClassStuNum(str3);
    }

    private static void getTwoClassStuNum(String str) {
        //输入为空，非法
        if (0 == str.length()) {
            System.out.println("ERROR");
            return;
        }
        //根据空格拆分出编号及是否是同班
        String[] strArr = str.split(" ");
        //每个班的学号不会重复，使用treeSet存储学生编号
        TreeSet<Integer> c1 = new TreeSet<>();
        TreeSet<Integer> c2 = new TreeSet<>();
        //遍历拆分出的字符串数组，根据/拆分，根据标识分班
        //判断是否一班
        boolean is1 = true;
        for (int i = 0; i < strArr.length; i++) {
            //根据/拆分出，学号,是否1班
            String[] s = strArr[i].split("/");
            int stuNum = Integer.parseInt(s[0]);
            //第一个值的学号默认加入第一个set
            if (i == 0) {
                c1.add(Integer.parseInt(s[0]));
                continue;
            }
            if ("N".equals(s[1])) {
                //负负得正
                is1 = !is1;
            }
            //三元表达式
            (is1 ? c1 : c2) .add(stuNum);
        }
        //分班完毕，根据情况拼接输出，先拼接c1班
        StringBuilder b1 = new StringBuilder();
        for (Integer integer : c1) {
            b1.append(integer).append(" ");
        }
        //当c2班不为空时，拼接2班
        if (!c2.isEmpty()) {
            StringBuilder b2 = new StringBuilder();
            for (Integer integer : c2) {
                b2.append(integer).append(" ");
            }
            //比较c1和c2的第一个值，小的先输出
            if (c1.first() < c2.first()) {
                System.out.println(b1.toString().trim());
                System.out.println(b2.toString().trim());
            } else {
                System.out.println(b2.toString().trim());
                System.out.println(b1.toString().trim());
            }
        } else {
            //c2为空，第二行输出空
            System.out.println(b1.toString().trim());
            System.out.println("");
        }
    }
}
