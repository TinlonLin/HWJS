package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.LinkedList;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b51矩阵扩散_200_图论图的多源BFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128192372

 * @date: 2023/6/4 10:13
 * @version: V-1.0
 */
public class b51矩阵扩散_200_图论图的多源BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr =
                Arrays.stream(sc.next().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
    }

    /**
     * @param m m m×n的二维数组
     * @param n n m×n的二维数组
     * @param i 扩散点位置为i,j
     * @param j 扩散点位置为i,j
     * @param k 扩散点位置为k,l
     * @param l 扩散点位置为k,l
     * @return 扩散所有点需要的时间
     */
    public static int getResult(int m, int n, int i, int j, int k, int l) {
        int[][] matrix = new int[m][n];
        matrix[i][j] = 1;
        matrix[k][l] = 1;

        // count记录未被扩散的点的数量
        int count = m * n - 2;

        // 多源BFS实现队列
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[] {i, j});
        queue.addLast(new int[] {k, l});

        // 上下左右偏移量
        int[][] offsets = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int day = 1;
        // 如果扩散点没有了，或者所有点已被扩散，则停止循环
        while (queue.size() > 0 && count > 0) {
            int[] tmp = queue.removeFirst();
            int x = tmp[0];
            int y = tmp[1];

            // 我们假设初始扩散点的1代表第1秒被扩散到的，则下一波被扩散点的值就是1+1，即第2秒被扩散到的
            day = matrix[x][y] + 1;

            for (int[] offset : offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 0) {
                    // 将点被扩散的时间记录为该点的值
                    matrix[newX][newY] = day;
                    // 被扩散到的点将变为新的扩散源
                    queue.addLast(new int[] {newX, newY});
                    // 未被扩散点的数量--
                    count--;
                }
            }
        }

        return day - 1;
    }
}
