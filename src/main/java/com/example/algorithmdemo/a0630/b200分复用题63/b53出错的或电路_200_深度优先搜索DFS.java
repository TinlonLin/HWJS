package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b53出错的或电路_200_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127271472

 * @date: 2023/6/4 10:13
 * @version: V-1.0
 */
public class b53出错的或电路_200_深度优先搜索DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String bin1 = sc.next();
        String bin2 = sc.next();

        System.out.println(getResult(n, bin1, bin2));
    }

    /**
     * @param n 二进制长度
     * @param bin1 可能产生错误交换的二进制
     * @param bin2 不会发生错误的二进制
     * @return 产生错误结果的情况有几种
     */
    public static int getResult(int n, String bin1, String bin2) {
        // 找出bin2值为0的位，并统计对应位上bin1的值为0的有x个
        int x = 0;
        // 找出bin2值为0的位，并统计对应位上bin1的值为1的有y个
        int y = 0;
        // 统计bin1总共有多少个1
        int a = 0;
        // 统计bin1总共有多少个0
        int b = 0;

        for (int i = 0; i < n; i++) {
            if (bin1.charAt(i) == '0') {
                b++;
                if (bin2.charAt(i) == '0') {
                    x++;
                }
            } else {
                a++;
                if (bin2.charAt(i) == '0') {
                    y++;
                }
            }
        }

        return x * a + y * b - x * y;
    }
}
