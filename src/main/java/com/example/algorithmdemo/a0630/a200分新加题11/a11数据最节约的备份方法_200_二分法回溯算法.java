package com.example.algorithmdemo.a0630.a200分新加题11;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a11数据最节约的备份方法_200_二分法回溯算法
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/131019925
题目描述:
有若干个文件，使用刻录光盘的方式进行备份，假设每张光盘的容量是500MB，求使用光盘最少的文件分布方式
所有文件的大小都是整数的MB，且不超过500MB；文件不能分割、分卷打包
输入描述:
一组文件大小的数据
输出描述:
使用光盘的数量
备注
不用考虑输入数据不合法的情况；假设最多100个输入文件。

用例:
输入
100,500,300,200,400
输出
3
说明
(100,400),(200,300),(500) 3张光盘即可。
输入和输出内容都不含空格。

输入
1,100,200,300
输出
2

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Integer[] nums =
Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
System.out.println(getResult(nums));
}

public static int getResult(Integer[] nums) {
// 将文件大小降序
Arrays.sort(nums, (a, b) -> b - a);
// 至少分组
int min = 1;
// 至多分组
int max = nums.length;
// 记录题解
int ans = max;

// 二分
while (min <= max) {
int mid = (min + max) >> 1;
// 看nums是否可以分为mid组，每组之和小于等于500
if (check(mid, nums)) {
// 可以分成功，则mid就是一个可能解
ans = mid;
// 继续尝试更小解
max = mid - 1;
} else {
// 不可以分成功，则mid取消了，即分组少了，下次应该尝试更大分组数
min = mid + 1;
}
}
return ans;
}

public static boolean check(int count, Integer[] nums) {
// nums数组中的数是否可以分为count组，每组之和<=500
// 这个问题可以使用回溯算法，将count组想象成count个桶，每个桶容量500，nums数组元素就是小球，我们需要将所有小球放到count个桶中，保证每个桶容量不超
int[] buckets = new int[count];
return partition(buckets, nums, 0);
}

public static boolean partition(int[] buckets, Integer[] nums, int index) {
if (index == nums.length) {
return true;
}

int select = nums[index];
for (int i = 0; i < buckets.length; i++) {
if (i > 0 && buckets[i] == buckets[i - 1]) continue; // 此处判断会极大优化性能
if (buckets[i] + select <= 500) {
buckets[i] += select;
if (partition(buckets, nums, index + 1)) return true;
buckets[i] -= select;
}
}
return false;
}

 * @date: 2023/6/4 8:45
 * @version: V-1.0
 */
public class a11数据最节约的备份方法_200_二分法回溯算法 {
}
