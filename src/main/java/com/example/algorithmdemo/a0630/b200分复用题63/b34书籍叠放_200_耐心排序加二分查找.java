package com.example.algorithmdemo.a0630.b200分复用题63;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b34书籍叠放_200_耐心排序加二分查找
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127711745

 * @date: 2023/6/4 10:03
 * @version: V-1.0
 */
public class b34书籍叠放_200_耐心排序加二分查找 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        // (?<=]),(?=\[) 正则表达式含义是：找这样一个逗号，前面跟着]，后面跟着[
        // 其中(?<=) 表示前面跟着
        // 其中(?=) 表示后面跟着
        Integer[][] books =
                Arrays.stream(input.substring(1, input.length() - 1).split("(?<=]),(?=\\[)"))
                        .map(
                                s ->
                                        Arrays.stream(s.substring(1, s.length() - 1).split(","))
                                                .map(Integer::parseInt)
                                                .toArray(Integer[]::new))
                        .toArray(Integer[][]::new);

        System.out.println(getResult(books));
    }

    public static int getResult(Integer[][] books) {
        // 长度升序，若长度相同，则宽度降序
        Arrays.sort(books, (a, b) -> Objects.equals(a[0], b[0]) ? b[1] - a[1] : a[0] - b[0]);
        Integer[] widths = Arrays.stream(books).map(book -> book[1]).toArray(Integer[]::new);
        return getMaxLIS(widths);
    }

    // 最长递增子序列
    public static int getMaxLIS(Integer[] nums) {
        //  dp数组元素dp[i]含义是：长度为i+1的最优子序列的尾数
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp.get(dp.size() - 1)) {
                dp.add(nums[i]);
                continue;
            }

            if (nums[i] < dp.get(0)) {
                dp.set(0, nums[i]);
                continue;
            }

            int idx = Collections.binarySearch(dp, nums[i]);
            if (idx < 0) {
                dp.set(-idx - 1, nums[i]);
            }
        }

        return dp.size();
    }
}
