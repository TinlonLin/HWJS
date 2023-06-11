package com.example.algorithmdemo.a0630.a100分新加题27;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2023/6/11 15:55
 * @ClassName: a26生日礼物_100_二分法二分查找
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130770597
题目描述
小牛的孩子生日快要到了，他打算给孩子买蛋糕和小礼物，蛋糕和小礼物各买一个，他的预算不超过x元。蛋糕cake和小礼物gift都有多种价位的可供选择。
请返回小牛共有多少种购买方案。
输入描述
第一行表示cake的单价，以逗号分隔
第二行表示gift的单价，以逗号分隔
第三行表示x预算
输出描述
输出数字表示购买方案的总数
备注
1 ≤ cake.length ≤ 10^5
1 ≤ gift.length ≤10^5
1 ≤ cake[i]，gift[i] ≤ 10^5
1 ≤ X ≤ 2*10^5

用例
输入
10,20,5
5,5,2
15
输出
6
说明
解释: 小牛有6种购买方案，所选蛋糕与所选礼物在数组中对应的下标分别是：
第1种方案: cake [0] + gift [0] = 10 + 5 = 15;
第2种方案: cake [0] + gift [1]= 10 + 5 = 15;
第3种方案: cake [0] + gift [2] = 10 + 2 = 12;
第4种方案: cake [2] + gift [0] = 5 + 5 = 10;
第5种方案: cake [2] + gift [1]= 5 + 5 = 10;
第6种方案: cake [2] + gift [2] = 5 + 2 = 7。

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int[] cakes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
int[] gifts = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
int x = Integer.parseInt(sc.nextLine());

System.out.println(getResult(cakes, gifts, x));
}

public static long getResult(int[] cakes, int[] gifts, int x) {
Arrays.sort(cakes);

int ans = 0;
for (int gift : gifts) {
if (x <= gift) continue;

int maxCake = x - gift;
int i = Arrays.binarySearch(cakes, maxCake);

if (i >= 0) {
ans += i + 1;
} else {
i = -i - 1;
ans += i;
}
}

return ans;
}

 * @Version: V-1.0
 */
public class a26生日礼物_100_二分法二分查找 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cakes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] gifts = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(cakes, gifts, x));
    }

    public static long getResult(int[] cakes, int[] gifts, int x) {
        Arrays.sort(cakes);

        int ans = 0;
        for (int gift : gifts) {
            if (x <= gift) continue;

            int maxCake = x - gift;
            int i = Arrays.binarySearch(cakes, maxCake);

            if (i >= 0) {
                ans += i + 1;
            } else {
                i = -i - 1;
                ans += i;
            }
        }

        return ans;
    }
}
