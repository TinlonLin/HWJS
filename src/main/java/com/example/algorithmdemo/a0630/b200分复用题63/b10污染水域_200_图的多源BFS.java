package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b10污染水域_200_图的多源BFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128169190

 * @date: 2023/6/4 9:55
 * @version: V-1.0
 */
public class b10污染水域_200_图的多源BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        getResult(arr);
    }

    private static void getResult(Integer[] arr) {
        int n = (int) Math.sqrt(arr.length);
        int total = arr.length;

        LinkedList<Integer[]> queue = new LinkedList<>();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[n * i + j];
                if (matrix[i][j] == 1) {
                    queue.add(new Integer[] {i, j});
                    total--;
                }
            }
        }

        if (queue.size() == 0 || queue.size() == arr.length) {
            System.out.println(-1);
            return;
        }

        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (queue.size() > 0 && total > 0) {
            Integer[] tmp = queue.removeFirst();
            int i = tmp[0];
            int j = tmp[1];

            int num = matrix[i][j];

            for (int[] offset : offsets) {
                int newI = i + offset[0];
                int newJ = j + offset[1];

                if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && matrix[newI][newJ] == 0) {
                    matrix[newI][newJ] = num + 1;
                    queue.add(new Integer[] {newI, newJ});
                    total--;
                    if (total == 0) {
                        System.out.println(num);
                        return;
                    }
                }
            }
        }
    }
}
