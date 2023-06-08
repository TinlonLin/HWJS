package com.example.algorithmdemo.a0630.a200分新加题12;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: a8找出两个整数数组中同时出现的整数_200_逻辑分析
 * @desc: Todo
 * https://blog.csdn.net/qfc_128220/article/details/130764650?spm=1001.2014.3001.5501
题目描述:
现有两个整数数组，需要你找出两个数组中同时出现的整数，并按照如下要求输出:
1.有同时出现的整数时，先按照同时出现次数（整数在两个数组中都出现并目出现次数较少的那个）进行归类，然后按照出现次数从小到大依次按行输出。
2.没有同时出现的整数时，输出NULL。
输入描述:
第一行为第一个整数数组，第二行为第二个整数数组，每行数中整数与整数之间以英文号分，整数的取值范用为[-200, 200]，数组长度的范用为[1, 10000]之间的整数。
输出描述:
按照出现次数从小到大依次按行输出，每行输出的格式为：
出现次数:该出现次数下的整数升序排序的结果
格式中的":"为英文冒号，整数间以英文逗号分隔。

用例
输入
5,3,6,-8,0,11
2,8,8,8,-1,15
输出
NULL
说明
两个整数数组没有同时出现的整数，输出NULL。

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int[] arr1 = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
int[] arr2 = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

getResult(arr1, arr2);
}

public static void getResult(int[] arr1, int[] arr2) {
// 统计arr1中各数字出现次数
HashMap<Integer, Integer> countMap1 = new HashMap<>();
for (int num : arr1) {
countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
}

// 统计arr2中各数字出现次数
HashMap<Integer, Integer> countMap2 = new HashMap<>();
for (int num : arr2) {
countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
}

// arr1和arr2是否存在相同的数字，假设不存在，即noSameNum = true
boolean noSameNum = true;

// 统计arr1和arr2的相同的数字，并记录对于数字出现的次数，注意sameCountKeys中次数是键，相同数字是值
HashMap<Integer, TreeSet<Integer>> sameCountKeys = new HashMap<>();
for (Integer num : countMap1.keySet()) {
if (countMap2.containsKey(num)) {
// 如果数字key在arr1和arr2中都有，则说明存在相同数字，此时noSameNum = false
noSameNum = false;
// 整数在两个数组中都出现并目出现次数较少的那个
int count = Math.min(countMap1.get(num), countMap2.get(num));
// sameCountKeys中次数是键，相同数字是值
sameCountKeys.putIfAbsent(count, new TreeSet<>());
sameCountKeys.get(count).add(num);
}
}

// 如果两个数组之间没有相同数字，则输出"NULL"
if (noSameNum) {
System.out.println("NULL");
return;
}

// 否则，按照相同数字的出现次数升序，来打印对应次数下的相同数字列表，注意相同数字列表存入的是TreeSet，因此自然升序
sameCountKeys.keySet().stream()
.sorted()
.forEach(
count -> {
StringJoiner sj = new StringJoiner(",", count + ":", "");
for (Integer num : sameCountKeys.get(count)) {
sj.add(num + "");
}
System.out.println(sj.toString());
});
}

 * @date: 2023/6/4 8:44
 * @version: V-1.0
 */
public class a8找出两个整数数组中同时出现的整数_200_逻辑分析 {
}
