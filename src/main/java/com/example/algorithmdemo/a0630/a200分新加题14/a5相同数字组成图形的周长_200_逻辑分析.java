package com.example.algorithmdemo.a0630.a200分新加题14;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a5相同数字组成图形的周长_200_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130161763
题目描述:
有一个64×64的矩阵，每个元素的默认值为0，现在向里面填充数字，相同的数字组成一个实心图形，
如下图所示是矩阵的局部（空白表示填充0）：
https://img-blog.csdnimg.cn/52ca08262cb9437dab0b430f7f370a9b.png
数字1组成了蓝色边框的实心图形，数字2组成了红色边框的实心图形。
单元格的边长规定为1个单位。
请根据输入，计算每个非0值填充出来的实心圆形的周长。
输入描述:
第一行输入N，表示N个图形，N > 0 且 N < 64 × 64
矩阵左上角单元格坐标记作(0, 0)，第一个数字表示行号，第二个数字表示列号
接下来是N行，每行第一个数是矩阵单元格填充的数字，后续每两个一组，表示填充该数字的单元格坐标
答题者无需考虑数据格式非法的场景，题目用例不考察数据格式
题目用例保证同一个填充值只会有一行输入数据
输出描述:
一共输出N个数值，每个数值表示某一行输入表示图形的周长
输出顺序需和输入的隔行顺序保持一致，即第1个数是输入的第1个图形的周长，第2个数是输入的第2个图形的周长，以此类推。

用例:
输入
2
1 1 3 2 2 2 3 2 4 3 2 3 3 3 4 4 1 4 2 4 3 4 4 5 2 5 3
2 3 7 3 8 4 5 4 6 4 7 4 8 5 4 5 5 5 6 5 7 5 8 6 4 6 5 6 6 6 7 6 8 7 4 7 5 7 6 7 7 7 8
输出
18 20
题目解析:
我的解题思路如下：
首先初始化一个64×64的二维数组，数组元素初始化为0。
然后，根据输入将二维数组指定坐标上的元素的值修改为指定值。
接着，继续遍历每个图形下的元素，看该元素的四个方向上的元素的值是否为当前图形的值，
比如图形中某元素值为1，但是其上方元素的值为0，那么此时图形的周长+1。
另外，需要注意的是，如果图形元素的上下左右方向的元素越界了，那么也要为对应图形的周长+1。

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = Integer.parseInt(sc.nextLine());
Integer[][] lines = new Integer[n][];
for (int i = 0; i < n; i++) {
lines[i] =
Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
}
System.out.println(getResult(lines));
}

static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

public static String getResult(Integer[][] lines) {
// 记录每个图形的边长
ArrayList<Integer> ans = new ArrayList<>();
// 定义一个64*64的矩阵
int[][] matrix = new int[64][64];
// 向64*64的矩阵中填充数字
for (Integer[] line : lines) {
// 每行第一个数是矩阵单元格填充的数字
int num = line[0];
// 后续每两个一组，表示填充该数字的单元格坐标
for (int i = 1; i < line.length; i += 2) {
int x = line[i];
int y = line[i + 1];
matrix[x][y] = num; // 填充数字
}
}
// 遍历每个图形的坐标
for (Integer[] line : lines) {
int num = line[0];
int p = 0; // 周长

for (int i = 1; i < line.length; i += 2) {
int x = line[i];
int y = line[i + 1];

// 遍历图形中元素的上下左右
for (int[] offset : offsets) {
int offsetX = offset[0];
int offsetY = offset[1];

int newX = x + offsetX;
int newY = y + offsetY;

// 如果图形元素的上或下或左或右没有越界
if (newX >= 0 && newX < 64 && newY >= 0 && newY < 64) {
// 则如果图形元素的上或下或左或右不是图形值，那么当前图形的边长+1
if (matrix[newX][newY] != num) p++;
} else {
// 如果图形元素的上或下或左或右越界了，则当前图形边长也+1
p++;
}
}
}
ans.add(p);
}
StringJoiner sj = new StringJoiner(" ");
for (Integer an : ans) {
sj.add(an + "");
}
return sj.toString();
}

 * @date: 2023/6/4 8:42
 * @version: V-1.0
 */
public class a5相同数字组成图形的周长_200_逻辑分析 {
}
