package com.example.algorithmdemo.ExerciseDemo.code0616_贪心;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: ZhaoPIn_test
 * @desc: 招聘
输入
2
5
1 2
2 3
3 4
4 5
5 6
输出
3
输入：
2
4
1 2
3 5
4 7
6 8
输出：2
 * @date: 2022/6/19 4:17 下午
 * @version: V-1.0
 */
public class 招聘_test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int perCount = Integer.parseInt(scanner.nextLine());
        int totalCout = Integer.parseInt(scanner.nextLine());
        List<Ms> msList = new ArrayList<>();
        for (int i = 0; i < totalCout; i++) {
            int[] arr = Arrays.asList(scanner.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            Ms ms = new Ms();
            ms.start = arr[0];
            ms.end = arr[1];
            msList.add(ms);
        }
        Collections.sort(msList);
        List<Msg> msgList = new ArrayList<>();
        for (Ms ms : msList) {
            boolean has = false;
            for (Msg msg : msgList) {
                if (msg.end <= ms.start && msg.count < perCount) {
                    has = true;
                    msg.end = ms.end;
                    msg.count++;
                    break;
                }
            }
            if (!has) {
                Msg msgNew = new Msg();
                msgNew.end = ms.end;
                msgNew.count = 1;
                msgList.add(msgNew);
            }
        }
        System.out.println(msgList.size());
    }

    private static class Msg {
        int end;
        int count;
    }

    private static class Ms implements Comparable<Ms> {
        int start;
        int end;

        @Override
        public int compareTo(Ms ms) {
            return this.end - ms.end;
        }
    }
}
