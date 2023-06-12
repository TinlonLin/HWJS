package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b50约瑟夫问题_100_约瑟夫环问题
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127979790

 * @date: 2023/6/4 9:07
 * @version: V-1.0
 */
public class b50约瑟夫问题_100_约瑟夫环问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] input_arr =
                Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int len = Integer.parseInt(sc.nextLine());

        int m = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(input_arr, len, m));
    }

    private static String getResult(Integer[] input_arr, int len, int m) {
        LinkedList<Integer> dq = new LinkedList<>(Arrays.asList(input_arr));

        ArrayList<Integer> output_arr = new ArrayList<>();

        int i = 1;
        while (len > 0) {
            Integer out = dq.removeFirst();

            if (i == m) {
                output_arr.add(out);
                m = out;
                i = 1;
                len--;
            } else {
                dq.add(out);
                i++;
            }
        }

        StringJoiner sj = new StringJoiner(",");
        for (Integer ele : output_arr) {
            sj.add(ele + "");
        }
        return sj.toString();
    }
}
