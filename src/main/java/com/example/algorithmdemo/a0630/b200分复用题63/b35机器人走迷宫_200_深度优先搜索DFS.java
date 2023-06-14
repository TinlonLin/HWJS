package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b35机器人走迷宫_200_深度优先搜索DFS
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711610
题目描述:
房间由XY的方格组成，例如下图为64的大小。每一个方格以坐标(x，y)描述。
机器人固定从方格(0，0)出发，只能向东或者向北前进。出口固定为房间的最东北角，如下图的方格(5，3)。用例保证机器人可以从入口走到出口。
房间有些方格是墙壁，如(4，1)，机器人不能经过那儿。
有些地方是一旦到达就无法走到出口的，如标记为B的方格，称之为陷阱方格。
有些地方是机器人无法到达的的，如标记为A的方格，称之为不可达方格，不可达方格不包括墙壁所在的位置。
如下示例图中，陷阱方格有2个，不可达方格有3个。
请为该机器人实现路径规划功能：给定房间大小、墙壁位置，请计算出陷阱方格与不可达方格分别有多少个。
https://img-blog.csdnimg.cn/170a796301fe490bac53249f390187ec.png
输入描述:
第一行为房间的X和Y（0 < X,Y <= 1000）
第二行为房间中墙壁的个数N（0 <= N < X*Y）
接着下面会有N行墙壁的坐标
同一行中如果有多个数据以一个空格隔开，用例保证所有的输入数据均合法。（结尾不带回车换行）
输出描述:
陷阱方格与不可达方格数量，两个信息在一行中输出，以一个空格隔开。（结尾不带回车换行）

用例
输入
6 4
5
0 2
1 2
2 2
4 1
5 1
输出
2 3
说明
该输入对应上图示例中的迷宫，陷阱方格有2个，不可达方格有3个

输入
6 4
4
2 0
2 1
3 0
3 1
输出
0 4
说明
该输入对应的迷宫如下图，没有陷阱方格，不可达方格有4个，分别是(4,0) (4,1) (5,0) (5,1)
https://img-blog.csdnimg.cn/8715eacbb3bb4a6fb91ee3e17cd910e0.png
 * @date: 2023/6/4 10:04
 * @version: V-1.0
 */
public class b35机器人走迷宫_200_深度优先搜索DFS {
    static int x;
    static int y;
    static int n;
    static int[][] walls;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int
        // 行数
        x = sc.nextInt();
        // 列数
        y = sc.nextInt();
        // 墙数
        n = sc.nextInt();

        // 墙位置
        walls = new int[n][2];
        for (int i = 0; i < n; i++) {
            walls[i][0] = sc.nextInt();
            walls[i][1] = sc.nextInt();
        }

        getResult();
    }

    public static void getResult() {
        matrix = new int[x][y];

        for (int[] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            // 墙点值为1，非墙点值为0
            matrix[i][j] = 1;
        }

        // 可达点值为2
        matrix[x - 1][y - 1] = 2;

        dfs(0, 0);

        // 陷阱数量
        int trap = 0;
        // 不可达点数量
        int unreach = 0;
        //遍历房间寻找-1和0的数量
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    unreach++;
                } else if (matrix[i][j] == -1) {
                    trap++;
                }
            }
        }

        System.out.println(trap + " " + unreach);
    }

    public static boolean dfs(int i, int j) {
        if (i >= x || j >= y) {
            return false;
        }
        if (matrix[i][j] == 1) {
            return false;
        }
        if (matrix[i][j] == -1) {
            return false;
        }
        if (matrix[i][j] == 2) {
            return true;
        }

        if (matrix[i][j] == 0) {
            boolean east = dfs(i + 1, j);
            boolean north = dfs(i, j + 1);

            if (east || north) {
                // 如果向东可达或者向北可达，则当前点可达，将值设为2
                matrix[i][j] = 2;
            } else {
                // 如果向东，向北都不可达，则当前前也是不可达点，将值设为-1
                matrix[i][j] = -1;
            }
        }

        return matrix[i][j] == 2;
    }
}
