package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b3VLAN资源池_100_逻辑分析
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127418341
题目描述：
VLAN是一种对局域网设备进行逻辑划分的技术，为了标识不同的VLAN，引入VLAN ID(1-4094之间的整数)的概念。
定义一个VLAN ID的资源池(下称VLAN资源池)，资源池中连续的VLAN用开始VLAN-结束VLAN表示，不连续的用单个整数表示，所有的VLAN用英文逗号连接起来。
现在有一个VLAN资源池，业务需要从资源池中申请一个VLAN，需要你输出从VLAN资源池中移除申请的VLAN后的资源池。
输入描述：
第一行为字符串格式的VLAN资源池，第二行为业务要申请的VLAN，VLAN的取值范围为[1,4094]之间的整数。
输出描述：
从输入VLAN资源池中移除申请的VLAN后字符串格式的VLAN资源池，输出要求满足题目描述中的格式，并且按照VLAN从小到大升序输出。
如果申请的VLAN不在原VLAN资源池内，输出原VLAN资源池升序排序后的字符串即可。
备注
输入VLAN资源池中VLAN的数量取值范围为[2-4094]间的整数，资源池中VLAN不重复且合法([1,4094]之间的整数)，输入是乱序的。

用例
输入
1-5
2
输出
1,3-5
说明
原VLAN资源池中有VLAN 1、2、3、4、5，从资源池中移除2后，剩下VLAN 1、3、4、5，按照题目描述格式并升序后的结果为1,3-5。

输入
20-21,15,18,30,5-10
15
输出
5-10,18,20-21,30
说明
原VLAN资源池中有VLAN 5、6、7、8、9、10、15、18、20、21、30，从资源池中移除15后，
资源池中剩下的VLAN为 5、6、7、8、9、10、18、20、21、30，
按照题目描述格式并升序后的结果为5-10,18,20-21,30。

输入
5,1-3
10
输出
1-3,5
说明
原VLAN资源池中有VLAN 1、2、3，5，申请的VLAN 10不在原资源池中，将原资源池按照题目描述格式并按升序排序后输出的结果为1-3,5。

 * @date: 2023/6/4 8:46
 * @version: V-1.0
 */
public class b3VLAN资源池_100_逻辑分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] vlanArr = sc.nextLine().split(",");
        int remove = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(vlanArr, remove));
    }

    private static String getResult(String[] vlanArr, int remove) {
        LinkedList<Integer[]> vlanList =
                Arrays.stream(vlanArr)
                        .map(v -> Arrays.stream(v.split("-")).map(Integer::parseInt).toArray(Integer[]::new))
                        .sorted((a, b) -> a[0] - b[0])
                        .collect(Collectors.toCollection(LinkedList::new));

        for (int i = 0; i < vlanList.size(); i++) {
            Integer[] vlan = vlanList.get(i);

            int from = vlan[0];

            if (vlan.length > 1) {
                int to = vlan[1];

                if (remove < from || remove > to) {
                    continue;
                }

                vlanList.remove(i);

                if (remove == from) {
                    vlanList.add(i, generateRange(remove + 1, to));
                } else if (remove == to) {
                    vlanList.add(i, generateRange(from, remove - 1));
                } else {
                    vlanList.add(i, generateRange(remove + 1, to));
                    vlanList.add(i, generateRange(from, remove - 1));
                }
                break;
            } else if (from == remove) {
                vlanList.remove(i);
                break;
            }
        }

        StringJoiner ans = new StringJoiner(",");

        vlanList.stream()
                .map(
                        vlan -> {
                            StringJoiner sj = new StringJoiner("-");
                            for (Integer v : vlan) {
                                sj.add(v + "");
                            }
                            return sj.toString();
                        })
                .forEach(ans::add);
        return ans.toString();
    }

    private static Integer[] generateRange(int from, int to) {
        if (from < to) {
            return new Integer[] {from, to};
        } else {
            return new Integer[] {from};
        }
    }
}
