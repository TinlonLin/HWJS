package com.example.algorithmdemo.ExerciseDemo.code0602_字符串;

import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2022/6/2 0:26
 * @ClassName: InputOfEnglish_0602
 * @Desc: 英文输入法
 * https://blog.csdn.net/weixin_44219664/article/details/123883815?spm=1001.2014.3001.5506
 * @Version: V-1.0
 * 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词
 * 按字典序输出联想到的单词序列，如果联想不到，输出用户输入的单词前缀
 * 注意：英文单词联想区分大小写 缩略形式如don't判定为两个单词，
 * 输出的单词序列不能有重复单词，且只能是英文单词，不能有标点符号
 * 输入两行：
 * 首行输入一段由英文单词和标点构成的语句str
 * 下一行为一个英文单词的前缀pre
 * 输出描述：
 * 输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割
 * 正则：
 * \W: 与任何非单词字符匹配。与"[^A-Za-z0-9_]"等效。
 * \w: 匹配任何字类字符，包括下划线。与"[A-Za-z0-9_]"等效
 */
public class InputOfEnglish_0602 {
    public static void main(String[] args) {
        String str1 = "I Love you";
        String pre1 = "He";
        System.out.println("输入1：\n"+str1+"\n"+pre1);
        System.out.println("输出1：");
        getAssociatedWord(str1, pre1);

        String str2 = "The furthest distance in the world,Is not between life and death,But " +
                "when I stand in front of you,Yet you don't know that I love you.";
        String pre2 = "f";
        System.out.println("输入2\n："+str2+"\n"+pre2);
        System.out.println("输出2：");
        getAssociatedWord(str2, pre2);
    }

    private static void getAssociatedWord(String str, String pre) {
        //使用TreeSet存储单词，具有排序和去重的功能
        TreeSet<String>  stringTreeSet = new TreeSet<>();
        //先将输入字符串根据标点符号拆分成String数组
        //String[] strArr = str.split(" |'|,|\\.");
        String[] strArr = str.split("\\W+");
        for (int i = 0; i < strArr.length; i++) {
            stringTreeSet.add(strArr[i]);
        }

        //遍历stringSet，如果其中的值包含前缀，则拼接输出，否则输出前缀
        StringBuilder builder = new StringBuilder();
        for (String s : stringTreeSet) {
            if (s.startsWith(pre)) {
                builder.append(s).append(" ");
            }
        }
        String result = "";
        if (builder.length() != 0) {
            result = builder.substring(0, builder.length()-1);
        } else {
            result = pre;
        }
        System.out.println(result);
    }
}
