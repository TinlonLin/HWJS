package com.example.algorithmdemo.a0630.a100分新加题28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a4报文回路_100_逻辑分析
 * @desc:  Todo
 * https://blog.csdn.net/qfc_128220/article/details/130768658
题目描述:
协议中响应报文和查询报文，是维系组播通路的两个重要报文，在一条已经建立的组播通路中两个相邻的 HOST 和 ROUTER，
ROUTER 会给 HOST 发送查询报文，HOST 收到查询报文后给 ROUTER 回复一个响应报文，以维持相之间的关系，
一旦这关系断裂，那么这条组播通路就异常”了。
现通过某种手段，抓取到了 HOST 和 ROUTER 两者通讯的所有响应报文和查询报文，请分析该组播通路是否“正常”
输入描述:
第一行抓到的报文数量C (C≤100) ，后续C行依次输入设备节点D1和D2，表示从D1到D2发送了单向的报文，D1和D2用空格隔开。
输出描述:
组播通路是否“正常”，正常输出True， 异常输出False。

用例
输入
5
1 2
2 3
3 2
1 2
2 1
输出
True

输入
3
1 3
3 2
2 3
输出
False

思路：
根据题目意思，想要组播通路之间正常，则有数据传递的两个节点之间必须是双向的。

 * @date: 2023/6/4 8:27
 * @version: V-1.0
 */
public class a4报文回路_100_逻辑分析y {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
            HashMap<Integer, HashSet<Integer>> trans = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] tmp = sc.nextLine().split(" ");
                int send = Integer.parseInt(tmp[0]);
                int receive = Integer.parseInt(tmp[1]);
                trans.putIfAbsent(send, new HashSet<>());
                trans.putIfAbsent(receive, new HashSet<>());
                trans.get(send).add(receive);
            }
            getResult(trans);
        }

        public static void getResult(HashMap<Integer, HashSet<Integer>> trans) {
            for (Integer send : trans.keySet()) {
                for (Integer receive : trans.get(send)) {
                    if (!trans.get(receive).contains(send)) {
                        System.out.println("False");
                        return;
                    }
                }
            }
            System.out.println("True");
        }

}
