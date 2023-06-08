package com.example.algorithmdemo.a0630.a200分新加题12;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a7寻找最大价值的矿堆_200_深度优先搜索DFS栈实现
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130774841
题目描述:
给你一个由 '0' (空地)、'1' (银矿)、'2'(金矿) 组成的的地图，矿堆只能由上下左右相邻的金矿或银矿连接形成。超出地图范围可以认为是空地。
假设银矿价值1，金矿价值2 ，请你找出地图中最大价值的矿堆并输出该矿堆的价值。
输入描述:
地图元素信息如：
22220
00000
00000
11111
地图范围最大 300*300
0 ≤ 地图元素 ≤ 2
输出描述:
矿堆的最大价值

用例:
输入
22220
00000
00000
01111
输出
8

输入
22220
00020
00010
01111
输出
15

输入
20000
00020
00000
00111
输出
3

// 地图矩阵
static ArrayList<ArrayList<Integer>> matrix;
// 记录地图矩阵的行数row，列数col
static int row;
static int col;
// 上下左右，四个方向的偏移量
static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
matrix = new ArrayList<>();
while (sc.hasNextLine()) {
String line = sc.nextLine();
// 由于本题没有说明输入截止条件，因此使用空行作为输入截止条件
if ("".equals(line)) {
System.out.println(getResult());
break;
} else {
matrix.add(
new ArrayList<>(
Arrays.stream(line.split("")).map(Integer::parseInt).collect(Collectors.toList())));
}
}
}

public static int getResult() {
row = matrix.size();
if (row == 0) return 0;
col = matrix.get(0).size();
// 记录最大矿堆价值
int ans = 0;
// 遍历矩阵元素
for (int i = 0; i < row; i++) {
for (int j = 0; j < col; j++) {
// 如果点(i,j)没有被访问过，且点(i,j)上有矿，则进入深搜
if (matrix.get(i).get(j) > 0) {
ans = Math.max(ans, dfs(i, j));
}
}
}
return ans;
}

public static int dfs(int i, int j) {
LinkedList<int[]> stack = new LinkedList<>();
stack.add(new int[] {i, j});
int sum = 0;
while (stack.size() > 0) {
int[] pos = stack.removeLast();
int x = pos[0], y = pos[1];
sum += matrix.get(x).get(y);
matrix.get(x).set(y, 0);
for (int[] offset : offsets) {
int newX = x + offset[0];
int newY = y + offset[1];
if (newX >= 0 && newX < row && newY >= 0 && newY < col && matrix.get(newX).get(newY) > 0) {
stack.add(new int[] {newX, newY});
}
}
}
return sum;
}

 * @date: 2023/6/4 8:43
 * @version: V-1.0
 */
public class a7寻找最大价值的矿堆_200_深度优先搜索DFS栈实现 {
}
