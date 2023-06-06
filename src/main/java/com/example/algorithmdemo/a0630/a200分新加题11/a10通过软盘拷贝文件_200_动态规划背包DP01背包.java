package com.example.algorithmdemo.a0630.a200分新加题11;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a10通过软盘拷贝文件_200_动态规划背包DP01背包
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130765207?spm=1001.2014.3001.5501
题目描述：
有一名科学家想要从一台古董电脑中拷贝文件到自己的电脑中加以研究。
但此电脑除了有一个3.5寸软盘驱动器以外，没有任何手段可以将文件持贝出来，而且只有一张软盘可以使用。
因此这一张软盘是唯一可以用来拷贝文件的载体。
科学家想要尽可能多地将计算机中的信息拷贝到软盘中，做到软盘中文件内容总大小最大。
已知该软盘容量为1474560字节。文件占用的软盘空间都是按块分配的，每个块大小为512个字节。
一个块只能被一个文件使用。拷贝到软盘中的文件必须是完整的，且不能采取任何压缩技术。
输入描述：
第1行为一个整数N，表示计算机中的文件数量。1 ≤ N ≤ 1000.
接下来的第2行到第N+1行(共N行)，每行为一个整数，表示每个文件的大小Si，单位为字节。
0 ≤ i < N,0 ≤ Si
输出描述：
科学家最多能拷贝的文件总大小
备注：
为了充分利用软盘空间，将每个文件在软盘上占用的块记录到本子上。即真正占用软盘空间的只有文件内容本身。

用例：
输入
3
737270
737272
737288
输出
1474542
说明
3个文件中，每个文件实际占用的大小分别为737280字节、737280字节、737792字节。
只能选取前两个文件，总大小为1474542字节。虽然后两个文件总大小更大且未超过1474560字节，
但因为实际占用的大小超过了1474560字节，所以不能选后两个文件。

输入
6
400000
200000
200000
200000
400000
400000
输出
1400000
说明
从6个文件中，选择3个大小为400000的文件和1个大小为200000的文件，得到最大总大小为1400000。
也可以选择2个大小为400000的文件和3个大小为200000的文件，得到的总大小也是1400000

背包滚动数组：
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

int[] arr = new int[n];
for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

System.out.println(getResult(n, arr));
}

public static int getResult(int n, int[] arr) {
int bag = 1474560 / 512; // 背包承重（块）

int[] dp = new int[bag + 1];

for (int i = 0; i < n; i++) {
int weight = (int) Math.ceil(arr[i] / 512.0); // 物品的重量（块）
int worth = arr[i]; // 物品的价值（字节）
for (int j = bag; j >= weight; j--) {
dp[j] = Math.max(dp[j], dp[j - weight] + worth);
}
}

return dp[bag];
}

 * @date: 2023/6/4 8:44
 * @version: V-1.0
 */
public class a10通过软盘拷贝文件_200_动态规划背包DP01背包 {
}
