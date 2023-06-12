package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b4最大社交距离_200_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128160300

 * @date: 2023/6/4 9:53
 * @version: V-1.0
 */
public class b4最大社交距离_200_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        Integer[] array =
                Arrays.stream(str.substring(1, str.length() - 1).split(","))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);

        System.out.println(getResult(array, n));
    }

    private static int getResult(Integer[] seatOrLeave, int seatNum) {
        LinkedList<Integer> seat = new LinkedList<>();
        int ans = -1;

        for (Integer sol : seatOrLeave) {
            int onSeat = seat.size();

            // 出场，即sol!=1
            if (sol != 1) {
                // 删除出场位置
                seat.remove(new Integer(-sol));
                continue;
            }

            // 进场，即sol==1
            if (onSeat == 0) {
                // 如果还没人坐，则进来的这个人坐0号座位
                ans = 0;
                seat.add(ans);
            } else if (onSeat == 1) {
                // 如果只有一个人在坐，那么这个人肯定坐在0号位，则下一个人肯定坐到seatNum-1号位
                ans = seatNum - 1;
                seat.add(ans);
            } else {
                // 如果有两个座位或以上被占用，则我们应该让下一个人坐在最大区间的中间位置
                // 比如已占有座位号0,2,4,9，则有区间0~2，2~4，4~9，需要注意的是0是始终占用的，9不一定，因此我们需要考虑边界9的情况
                // 我们只需要求出最大区间，然后记录该区间的起始位置start，以及区间长度一半长度maxDis，即可得出下一个人的最佳座位号
                int maxDis = 0;
                int start = -1;

                for (int i = 1; i < seat.size(); i++) {
                    int p = seat.get(i - 1);
                    int c = seat.get(i);

                    // 如果p座位和c座位紧邻，则中间没有空位，因此直接下一个区间
                    if (c == p + 1) continue;

                    int dis = (int) Math.ceil((c - p - 1) / 2.0);
                    if (dis > maxDis) {
                        maxDis = dis;
                        start = p;
                    }
                }

                // seat的0号位的人肯定不会走（题目说的），但是seatNum-1号的人可能会走，因此我们还需要考虑 seat.at(-1) ~ seatNum - 1 区间
                int brand_dis = seatNum - 1 - seat.getLast();
                if (brand_dis > maxDis) {
                    maxDis = brand_dis;
                    start = seat.getLast();
                }

                ans = start + maxDis;
                if (ans != -1) {
                    seat.push(ans);
                    seat.sort((a, b) -> a - b);
                }
            }
        }
        return ans;
    }
}
