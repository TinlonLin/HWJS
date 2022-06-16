package com.example.algorithmdemo.ExerciseDemo.code0617_贪心;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: XinDaoFenPei_0617
 * @desc: 信道分配
算法工程师小明面对着这样一个问题，需要将通信用的信道分配给尽量多的用户：
 * 信道的条件及分配规则如下：
 * 1) 所有信道都有属性：”阶”。阶为r的信道的容量为2^r比特；
 * 2) 所有用户需要传输的数据量都一样：D比特；
 * 3) 一个用户可以分配多个信道，但每个信道只能分配给一个用户；
 * 4) 只有当分配给一个用户的所有信道的容量和>=D，用户才能传输数据；
 * 给出一组信道资源，最多可以为多少用户传输数据？
 * 输入描述:
 * 第一行，一个数字R。R为最大阶数。
 * 0<=R<20
 * 第二行，R+1个数字，用空格隔开。 代表每种信道的数量Ni。按照阶的值从小到大排列。
 * 0<=i<=R, 0<=Ni<1000.
 * 第三行，一个数字D。 D为单个用户需要传输的数据量。
 * 0<D<1000000
 * 输出描述:
 * 一个数字，代表最多可以供多少用户传输数据。
 * 示例1
 * 输入
 * 5
 * 10 5 0 1 3 2
 * 30
 * 输出
 * 4
 * 说明
 * 最大阶数为5.
 * 信道阶数： 0  1  2  3   4   5
 * 信道容量： 1  2  4  8  16  32
 * 信道个数：10  5  0  1   3   2
 * 单个用户需要传输的数据量为30
 * 可能存在很多分配方式，举例说明：
 * 分配方式1：
 * 1) 32*1 = 32
 * 2) 32*1 = 32
 * 3) 16*2 = 32
 * 4) 16*1 + 8*1 + 2*3 = 30
 * 剩下2*2 + 1*10=14不足以再分一个用户了。
 * 分配方式2：
 * 1) 16*1 + 8*1 + 2*3 = 30
 * 2) 16*1 + 2*2 + 1*10 = 30
 * 3) 32*1 = 32
 * 4) 32*1 = 32
 * 剩下16*1=16不足以再分一个用户了。
 * 分配方式3：
 * 1) 16*1 + 8*1 + 2*3 = 30
 * 2) 16*1 + 2*2 + 1*10 = 30
 * 3) 16*1 + 32*1 = 48
 * 4) 32*1 = 32
 * 恰好用完。
 * 虽然每种分配方式剩下的容量不同，但服务的用户数量是一致的。因为这个问题中我们只关心服务的用户数，所以我们认为这些分配方式等效。
 * @date: 2022/6/16 9:34 下午
 * @version: V-1.0
 */
public class XinDaoFenPei_0617 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = Integer.parseInt(scanner.nextLine()); // 最大阶数

        String[] NiStrs = scanner.nextLine().split(" ");
        int[][] Nis = new int[R + 1][2]; // 每种信道的数量Ni。按照阶的值从小到大排列
        for (int i = 0; i < Nis.length; i++) {
            Nis[i][0] = (int) Math.pow(2, i);
            Nis[i][1] = Integer.parseInt(NiStrs[i]);
        }

        int D = Integer.parseInt(scanner.nextLine()); // 单个用户需要传输的数据量

        int count = 0;
        Map<Integer, Integer> shizhi = new HashMap<>();
        for (int[] ni : Nis) {
            int Ni = ni[0];
            int Ni_count = ni[1];

            if (Ni_count == 0) {
                continue;
            }

            if (Ni >= D) {
                count += Ni_count;
                continue;
            }

            int mo = D % Ni;
            int shang = D / Ni;
            int need_count = mo == 0 ? shang : shang + 1;

            count += Ni_count / need_count;

            // 剩余个数
            int Ni_count_left = Ni_count - (Ni_count / need_count) * need_count;

            if (shizhi.size() != 0) {
                int temp = 0;
                for (Map.Entry<Integer, Integer> en : shizhi.entrySet()) {
                    temp += en.getKey() * en.getValue();
                }

                // 单个用户还剩多少数据量
                int D_left = D - temp;
                int mo_left = D_left % Ni;
                int shang_left = D_left / Ni;
                int need_count_left = mo_left == 0 ? shang_left : shang_left + 1;

                if (Ni_count_left >= need_count_left) {
                    shizhi.clear();
                    count++;
                    Ni_count_left -= need_count_left;
                }

            }

            if (Ni_count_left > 0) {
                shizhi.put(Ni, Ni_count_left);
            }
        }

        System.out.println(count);
    }


}
