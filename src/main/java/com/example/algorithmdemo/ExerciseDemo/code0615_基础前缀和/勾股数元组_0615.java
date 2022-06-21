package com.example.algorithmdemo.ExerciseDemo.code0615_基础前缀和;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: GouGuYuanShuZu_0615
 * @desc: 勾股数元组
 * https://blog.csdn.net/weixin_44219664/article/details/123615350
 * 如果3个正整数(a,b,c)满足a2 + b2 = c2的关系，则称(a,b,c)为勾股数（著名的勾三股四弦
 * 五），为了探索勾股数的规律，我们定义如果勾股数(a,b,c)之间两两互质（即a与b，a与c，b与
 * c之间均互质，没有公约数），则其为勾股数元祖（例如(3,4,5)是勾股数元祖，(6,8,10)则不
 * 是勾股数元祖）。请求出给定范围[N,M]内，所有的勾股数元祖。
 * <p>
 * 输入描述:
 * 起始范围 N
 * 结束范围 M
 * 输出描述：
 * 格式：a b c ，要求 a<b<c
 * 示例1
 * 输入：
 * 1
 * 20
 * 输出：
 * 3 4 5
 * 5 12 13
 * 8 15 17
 * 示例2
 * 输入：
 * 5
 * 10
 * 输出：
 * NA
 * @date: 2022/6/15 7:31 上午
 * @version: V-1.0
 */
public class 勾股数元组_0615 {
    public static void main(String[] args) {
        int N = 1;
        int M = 20;
        System.out.println("输入：\n" + N + "\n" + M);
        System.out.println("输出：");
        getGouGuShuYuanZu(N, M);

        int N1 = 1;
        int M1 = 3;
        System.out.println("输入：\n" + N1 + "\n" + M1);
        System.out.println("输出：");
        getGouGuShuYuanZu(N1, M1);
    }

    private static void getGouGuShuYuanZu(int N, int M) {
        //寻找勾股数，并使用List<integer>存储单个勾股数元组，使用List<List<Integer>>存储所有的元组，存入前需要判断是否已有该元组
        //因为输出要求，a<b<c，循环时，b=a+1,c=b+1即可，这样结果最终结果可以保证唯一及升序
        List<List<Integer>> totalList = new ArrayList<>();
        for (int a = N; a <= M - 2; a++) {
            for (int b = a + 1; b <= M - 1; b++) {
                for (int c = b + 1; c <= M; c++) {
                    //存储单个勾股数组合
                    List<Integer> singleList = new ArrayList<>();
                    //首先要是勾股数
                    if (a * a + b * b == c * c) {
                        //然后需要两两互质
                        if (isHuZhi(a, b) && isHuZhi(a, c) && isHuZhi(b, c)) {
                            singleList.add(a);
                            singleList.add(b);
                            singleList.add(c);
                            //将该组合加入总的集合里
                            totalList.add(singleList);
                        }
                    }
                }
            }
        }
        //如果totalList为空则不存勾股数元组，输出NA
        if (totalList.isEmpty()) {
            System.out.println("NA");
            return;
        }
        //System.out.println(totalList.toString());

        //最后拼接输出
        for (List<Integer> integers : totalList) {
            StringBuilder builder = new StringBuilder();
            builder.append(integers).append(" ");
            System.out.println(builder.toString().trim());
        }
    }

    private static boolean isHuZhi(int a, int b) {
        //判断两个数是否互质，即除了1和本身外如果还存在其他公因数则不互质
        for (int i = 2; i < a && i < b; i++) {
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }
}
