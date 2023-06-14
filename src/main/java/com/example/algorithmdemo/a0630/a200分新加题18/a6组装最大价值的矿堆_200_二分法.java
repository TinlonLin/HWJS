package com.example.algorithmdemo.a0630.a200分新加题18;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a6组装最大价值的矿堆_200_二分法
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/130764202
题目描述:
一个设备由N种类型元器件组成(每种类型元器件只需要一个，类型type编号从0~N-1)，
每个元器件均有可靠性属性reliability，可靠性越高的器件其价格price越贵。
而设备的可靠性由组成设备的所有器件中可靠性最低的器件决定。
给定预算S，购买N种元器件( 每种类型元器件都需要购买一个)，在不超过预算的情况下，请给出能够组成的设备的最大可靠性。
输入描述:
S N // S总的预算，N元器件的种类
total // 元器件的总数，每种型号的元器件可以有多种;
此后有total行具体器件的数据
type reliability price // type 整数类型，代表元器件的类型编号从0 ~ N-1; reliabilty 整数类型 ，代表元器件的可靠性; price 整数类型 ，代表元器件的价格
输出描述:
符合预算的设备的最大可靠性，如果预算无法买齐N种器件，则返回 -1
备注
0 <= S,price <= 10000000
0 <= N <= 100
0 <= type <= N-1
0 <= total <= 100000
0 < reliability <= 100000

用例:
输入
500 3
6
0 80 100
0 90 200
1 50 50
1 70 210
2 50 100
2 60 150
输出
60
说明
预算500，设备需要3种元件组成，方案
类型0的第一个(可靠性80),
类型1的第二个(可靠性70),
类型2的第二个(可靠性60),
可以使设备的可靠性最大 60

输入
100 1
1
0 90 200
输出
-1
说明
组成设备需要1个元件，但是元件价格大于预算，因此无法组成设备，返回-1
 * @date: 2023/6/4 8:43
 * @version: V-1.0
 */
public class a6组装最大价值的矿堆_200_二分法 {
    // 器件类
    static class Device {
        int reliability;
        int price;

        public Device(int reliability, int price) {
            this.reliability = reliability;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt(); // 总预算
        int n = sc.nextInt(); // 器件的种类数

// 收集器件的可靠性
        TreeSet<Integer> reliabilities = new TreeSet<>();

// 各种类集合
        ArrayList<ArrayList<Device>> kinds = new ArrayList<>();
// 为每个具体种类创建一个集合，用于装对应种类的器件
        for (int i = 0; i < n; i++) kinds.add(new ArrayList<>());

        int total = sc.nextInt(); // 之后输入total行具体器件的数据

        for (int i = 0; i < total; i++) {
// 器件种类
            int type = sc.nextInt();

// 器件可靠性
            int reliability = sc.nextInt();
            reliabilities.add(reliability); // 收集器件的可靠性

// 器件价值
            int price = sc.nextInt();

// 将器件加入到对应的种类中
            kinds.get(type).add(new Device(reliability, price));
        }

        System.out.println(getResult(s, kinds, reliabilities));
    }

    public static int getResult(
            int s, ArrayList<ArrayList<Device>> kinds, TreeSet<Integer> reliabilities) {

        // ans记录题解
        int ans = -1;

        // 将每个种类内的器件按照可靠性升序
        for (ArrayList<Device> kind : kinds) {
            kind.sort((a, b) -> a.reliability - b.reliability);
        }

        // 将所有器件的可靠性集合，变为数组
        Integer[] maybe = reliabilities.toArray(new Integer[0]);

        // 二分选取可能的最大可靠性maybe
        int low = 0;
        int high = maybe.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            // 如果maybe[mid]可靠性可以保证所有种类器件都能选到，且价格之和小于s
            if (check(kinds, maybe[mid], s)) {
                // 则maybe[mid]可靠性就是一个可能解
                ans = maybe[mid];
                // 继续尝试更优解，即找更大的可靠性
                low = mid + 1;
            } else {
                // 否则，说明可靠性选高了，我们应该继续尝试更低的可靠性
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean check(ArrayList<ArrayList<Device>> kinds, int maxReliability, int s) {
        int sum = 0;
        for (ArrayList<Device> kind : kinds) {
            // 注意kind内的器件已经按照可靠性升序了
            // 我们需要在该kind种类内找到一个可靠性>=maxReliability的器件
            int idx = binarySearch(kind, maxReliability);

            // 如果idx<0，则说明idx是一个插入位置
            if (idx < 0) {
                idx = -idx - 1;
            }

            // 如果idx==kind.size()则说明kind内所有器件的可靠性都低于maxReliability，因此此kind器件选取不到，可以直接返回false
            if (idx == kind.size()) return false;

            // 否则，选取对应idx位置的器件，并计入价格到总价
            sum += kind.get(idx).price;
        }

        // 如果最终总价小于总预算s，则此maxReliability可行
        return sum <= s;
    }

    public static int binarySearch(ArrayList<Device> kind, int target) {
        int low = 0;
        int high = kind.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            Device device = kind.get(mid);

            if (device.reliability > target) {
                high = mid - 1;
            } else if (device.reliability < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -low - 1;
    }
}
