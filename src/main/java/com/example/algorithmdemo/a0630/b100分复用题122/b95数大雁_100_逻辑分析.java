package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b95数大雁_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128025593

 * @date: 2023/6/4 9:40
 * @version: V-1.0
 */
public class b95数大雁_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String quack = sc.next();
        System.out.println(getResult(quack));
    }

    private static int getResult(String quack) {
        LinkedList<Integer> q = new LinkedList<>();

        int u = 0, a = 0, c = 0;

        ArrayList<Integer[]> ranges = new ArrayList<>();

        for (int i = 0; i < quack.length(); i++) {
            switch (quack.charAt(i)) {
                case 'q':
                    q.add(i);
                    break;
                case 'u':
                    if (u + 1 <= q.size()) u++;
                    break;
                case 'a':
                    if (a + 1 <= u) a++;
                    break;
                case 'c':
                    if (c + 1 <= a) c++;
                    break;
                case 'k':
                    if (c >= 1) {
                        ranges.add(new Integer[] {q.removeFirst(), i});
                        u--;
                        a--;
                        c--;
                    }
                    break;
                default:
                    return -1;
            }
        }

        if (ranges.size() == 0) return -1;

        int ans = 1;
        for (int i = 0; i < ranges.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < ranges.size(); j++) {
                if (ranges.get(i)[1] >= ranges.get(j)[0]) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
