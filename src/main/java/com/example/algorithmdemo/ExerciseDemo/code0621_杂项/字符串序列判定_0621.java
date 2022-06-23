package com.example.algorithmdemo.ExerciseDemo.code0621_杂项;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 字符串序列判定_0621
 * @desc: 字符串序列判定
 * 输入两个字符串S和L，都只包含英文小写字母。S长度<=100,L长度<=500000。判定S是否是L的有效字串。
 * 判定规则：
 * S中的每个字符在L中都能找到（可以不连续），且S在L中字符的前后顺序与S中顺序要保持一致。
 * 例如：S=’ace’是L='abcde’的一个子序列且有效字符是a,c,e,而aec不是有效子序列，且有效字符只有ae
 *
 * 输入描述：
 * 输入两个字符串S和L，都只包含英文小写字母。S长度<=100,L长度<=500000。先输入S,再输入L，每个字符串占一行。
 * 输出描述：
 * S串最后一个有效字符在L中的位置（首位从0开始计算，无有效字符返回-1）
 * 示例：
 * 输入
 * ace
 * abcde
 * 输出
 * 4
 * https://blog.csdn.net/Aimee_c/article/details/119979113
 * @date: 2022/6/21 11:10 下午
 * @version: V-1.0
 */
public class 字符串序列判定_0621 {
    public static void main(String[] args) {
        String S = "ace";
        String L = "abcde";
        System.out.println("输入：\n" + S +"\n" + L);
        System.out.println("输出：");
        getIndexOfLastEffectiveChar(S,L);
    }

    private static void getIndexOfLastEffectiveChar(String S, String L) {
        if (isSubSequence(S, L)) {
            System.out.println(L.indexOf(S.charAt(S.length() - 1)));
        } else {
            System.out.println(-1);
        }
    }
    //双指针判定S是否为L的子串
    private static boolean isSubSequence(String S, String L) {
        int i = 0;
        int j = 0;
        while (i < S.length() && j < L.length()) {
            if (S.charAt(i) == L.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == S.length()) {
            return true;
        }
        return false;
    }
}
