package com.example.algorithmdemo.a0630.a200分新加题12;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a9阿里巴巴找黄金宝箱4_200_栈结构
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130771502
题目描述:
一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0-N的箱子，
每个箱子上面有一个数字，箱子排列成一个环，编号最大的箱子的下一个是编号为0的箱子。
请输出每个箱了贴的数字之后的第一个比它大的数，如果不存在则输出-1。
输入描述:
输入一个数字字串，数字之间使用逗号分隔，例如: 1,2,3,1
1 ≤ 字串中数字个数 ≤ 10000:
-100000 ≤ 每个数字值 ≤ 100000
输出描述:
下一个大的数列表，以逗号分隔，例如: 2,3,6,-1,6

用例:
输入
2,5,2
输出
5,-1,5
说明
第一个2的下一个更大的数是5;
数字5找不到下一个更大的数;
第二个2的下一个最大的数需要循环搜索，结果也是 5

思路参考：
https://blog.csdn.net/qfc_128220/article/details/127397884

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
System.out.println(getResult(arr));
}

public static String getResult(int[] arr) {
LinkedList<int[]> stack = new LinkedList<>();

int[] res = new int[arr.length];
Arrays.fill(res, -1);

findNextBig(arr, stack, res);

if (stack.size() != 1) findNextBig(arr, stack, res);

StringJoiner sj = new StringJoiner(",");
for (int v : res) {
sj.add(v + "");
}
return sj.toString();
}

public static void findNextBig(int[] arr, LinkedList<int[]> stack, int[] res) {
for (int i = 0; i < arr.length; i++) {
int ele = arr[i];
while (true) {
if (stack.size() == 0) {
stack.add(new int[] {ele, i});
break;
} else {
int[] peek = stack.get(stack.size() - 1);
int peekEle = peek[0];
int peekIdx = peek[1];

if (ele > peekEle) {
res[peekIdx] = ele;
stack.removeLast();
} else {
stack.add(new int[] {ele, i});
break;
}
}
}
}
}

 * @date: 2023/6/4 8:44
 * @version: V-1.0
 */
public class a9阿里巴巴找黄金宝箱4_200_栈结构 {
}
