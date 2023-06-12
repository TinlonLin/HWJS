package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b3贪吃蛇_200_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/127710711

 * @date: 2023/6/4 9:52
 * @version: V-1.0
 */
public class b3贪吃蛇_200_逻辑分析 {
    static String[][] matrix;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] operates = sc.nextLine().split(" ");

        Integer[] tmp =
                Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        n = tmp[0];
        m = tmp[1];

        matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.next();
            }
        }

        System.out.println(getResult(operates));
    }

    private static int getResult(String[] operates) {
        LinkedList<Integer[]> snake = new LinkedList<>();

        // 找到初始蛇头位置，并使用snake[0]来维护蛇头位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("H".equals(matrix[i][j])) {
                    snake.addLast(new Integer[] {i, j});
                }
            }
        }

        // 蛇头移动方向
        String direction = "L"; // 初始默认向左

        for (String operate : operates) {
            if ("G".equals(operate)) {
                // 如果为G，则表示验证direction方向移动一格
                Integer[] pos = snake.get(0);
                int res = go(pos[0], pos[1], snake, direction); // 具体移动逻辑
                if (res > 0) {
                    return res;
                }
            } else {
                direction = operate;
            }
        }

        return snake.size();
    }

    private static int go(int i, int j, LinkedList<Integer[]> snake, String direction) {
        // [r,c]是当前蛇头位置，[i,j]是上一次蛇头位置
        int r = i, c = j;

        switch (direction) {
            case "U":
                r--;
                break;
            case "D":
                r++;
                break;
            case "L":
                c--;
                break;
            case "R":
                c++;
                break;
        }

        if (r < 0 || r >= n || c < 0 || c >= m) {
            // 越界，游戏结束，返回贪吃蛇长度
            return snake.size();
        } else {
            if ("E".equals(matrix[r][c])) {
                // 如果蛇头去的位置是空地
                matrix[r][c] = "H";
                snake.addFirst(new Integer[] {r, c});
                Integer[] tmp = snake.removeLast();
                matrix[tmp[0]][tmp[1]] = "E";
            } else if ("F".equals(matrix[r][c])) {
                // 如果蛇头去的位置是食物
                snake.addFirst(new Integer[] {r, c});
                matrix[r][c] = "H";
            } else {
                // 吃到自己身体，游戏结束，返回贪吃蛇长度
                return snake.size();
            }
        }

        // 返回0表示继续下一步移动
        return 0;
    }
}
