package com.example.algorithmdemo.a0630.a200分新加题26;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @Date: 2023/7/12 0:02
 * @ClassName: a12周末爬山_200_广度优先搜索
 * @Desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130774056?spm=1001.2014.3001.5502
题目描述
周末小明准备去爬山锻炼，0代表平地，山的高度使用1到9来表示，
小明每次爬山或下山高度只能相差k及k以内，每次只能上下左右一个方向上移动一格，小明从左上角(0,0)位置出发
输入描述
第一行输入m n k(空格分隔)
代表m*n的二维山地图，k为小明每次爬山或下山高度差的最大值，
然后接下来输入山地图，一共m行n列，均以空格分隔。取值范围：
0 < m ≤ 500
0< n ≤ 500
0 < k < 5
输出描述
请问小明能爬到的最高峰多高，到该最高峰的最短步数，输出以空格分隔。
同高度的山峰输出较短步数。
如果没有可以爬的山峰，则高度和步数都返回0。
备注
所有用例输入均为正确格式，且在取值范围内，考生不需要考虑不合法的输入格式。

用例
输入
5 4 1
0 1 2 0
1 0 0 0
1 0 1 2
1 3 1 0
0 0 0 9
输出
2 2
说明
根据山地图可知，能爬到的最高峰在(0,2)位置，高度为2，最短路径为(0,0)-(0,1)-(0,2)，最短步数为2。

输入
5 4 3
0 0 0 0
0 0 0 0
0 9 0 0
0 0 0 0
0 0 0 9
输出
0 0
说明
根据山地图可知，每次爬山距离3，无法爬到山峰上，步数为0。

 * @Version: V-1.0
 */
public class a12周末爬山_200_广度优先搜索 {
    static int m;
    static int n;
    static int k;
    static int[][] matrix;
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 标记某个山峰已经访问过了, 由于山峰高度范围0~9,而k范围1~4, 则最大山峰高度为9+4 = 13, 因此访问过的山峰被重置为15的话，则该山峰必然不可能被再次访问
    static final int VISITED = 15;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult());
    }

    public static String getResult() {
        // key表示山峰高度，value表示到达此山峰高度的最短步数
        HashMap<Integer, Integer> minStepToHeight = new HashMap<>();
        // 到达matrix[0][0]高度的山峰，最短步数是0
        minStepToHeight.put(matrix[0][0], 0);

        // 深搜
        dfs(0, 0, 0, minStepToHeight);

        // 取得最大高度
        int maxHeight = minStepToHeight.keySet().stream().max((a, b) -> a - b).orElse(0);
        // 取得最大高度对应的最短步数
        int minStep = minStepToHeight.get(maxHeight);

        return maxHeight + " " + minStep;
    }

    public static void dfs(int x, int y, int step, HashMap<Integer, Integer> minStepToHeight) {
        // 上一个山峰的高度
        int lastHeight = matrix[x][y];

        // 四个方向运动
        for (int[] offset : offsets) {
            // 下一个山峰的位置
            int newX = x + offset[0];
            int newY = y + offset[1];

            if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;

            // 下一个山峰的高度
            int curHeight = matrix[newX][newY];

            // 如果两个山峰高度相差k以内
            if (Math.abs(curHeight - lastHeight) <= k) {
                // 则下一个山峰可以去，即步数+1
                step++;

                // 更新到达curHeight高度山峰的最短步数
                if (!minStepToHeight.containsKey(curHeight) || minStepToHeight.get(curHeight) > step) {
                    minStepToHeight.put(curHeight, step);
                }

                // 标记x,y位置的山峰已经爬过, 防止被重复爬
                matrix[x][y] = VISITED;

                // 深搜
                dfs(newX, newY, step, minStepToHeight);

                // 深搜完对应分支，则还原上一个山峰的高度
                matrix[x][y] = lastHeight;

                // 回退步数
                step--;
            }
        }
    }
}
