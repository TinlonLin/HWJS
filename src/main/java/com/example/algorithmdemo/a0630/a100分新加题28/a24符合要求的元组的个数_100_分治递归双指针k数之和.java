package com.example.algorithmdemo.a0630.a100分新加题28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tinlonlin@gmail.com
 * @Date: 2023/6/9 21:29
 * @ClassName: a24符合要求的元组的个数_100_分治递归双指针k数之和
 * @Desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130771177
题目描述:
给定一个整数数组 nums、一个数字k，一个整数目标值 target，请问nums中是否存在k个元素使得其相加结果为target，
请输出所有符合条件且不重复的k元组的个数
数据范围
2 ≤ nums.length ≤ 200
-10^9 ≤ nums[i] ≤ 10^9
-10^9 ≤ target ≤ 10^9
2 ≤ k ≤ 100
输入描述:
第一行是nums取值：2 7 11 15
第二行是k的取值：2
第三行是target取值：9
输出描述:
输出第一行是符合要求的元组个数：1
补充说明：[2,7]满足，输出个数是1

用例
输入
-1 0 1 2 -1 -4
3
0
输出
2
说明
[-1,0,1]，[-1,-1,2]满足条件

输入
2 7 11 15
2
9
输出
1
说明
[2,7]符合条件

解析：
求k数字之和
https://blog.csdn.net/qfc_128220/article/details/131133325?spm=1001.2014.3001.5501
https://blog.csdn.net/qfc_128220/article/details/131126492?spm=1001.2014.3001.5501


 * @Version: V-1.0
 */
public class a24符合要求的元组的个数_100_分治递归双指针k数之和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(sc.nextLine());
        int target = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(nums, k, target));
    }

    public static int getResult(int[] nums, int k, int target) {
        if (k > nums.length) return 0;
        Arrays.sort(nums);
        return kSum(nums, k, target, 0, 0, 0);
    }

    // k数之和
    public static int kSum(int[] nums, int k, int target, int start, int count, long sum) {
        if (k < 2) return count;

        if (k == 2) {
            return twoSum(nums, target, start, count, sum);
        }

        for (int i = start; i <= nums.length - k; i++) {
// 剪枝
            if (nums[i] > 0 && sum + nums[i] > target) break;

// 去重
            if (i > start && nums[i] == nums[i - 1]) continue;
            count = kSum(nums, k - 1, target, i + 1, count, sum + nums[i]);
        }

        return count;
    }

    // 两数之和
    public static int twoSum(int[] nums, int target, int start, int count, long preSum) {
        int l = start;
        int r = nums.length - 1;

        while (l < r) {
            long sum = preSum + nums[l] + nums[r];

            if (target < sum) {
                r--;
            } else if (target > sum) {
                l++;
            } else {
                count++;
// 去重
                while (l + 1 < r && nums[l] == nums[l + 1]) l++;
// 去重
                while (r - 1 > l && nums[r] == nums[r - 1]) r--;
                l++;
                r--;
            }
        }

        return count;
    }
}
