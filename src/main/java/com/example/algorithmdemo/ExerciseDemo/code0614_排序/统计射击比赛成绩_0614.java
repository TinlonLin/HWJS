package com.example.algorithmdemo.ExerciseDemo.code0614_排序;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: CountShotScore_0614
 * @desc: 统计设计比赛成绩
 * https://blog.csdn.net/weixin_47243236/article/details/122355215?spm=1001.2014.3001.5506
 * 题目描述：
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高三个分数之和进行降序排名，输出降序排名后的选手id序列。
 * 题目解析：
 * 给一个数字表示射击的次数，然后给几个选手进行（乱序）射击，生成对应的成绩！
 * 条件如下：
 * 一个选手可以有多个射击成绩的分数，且次序不固定
 * 如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手
 * 如果选手的成绩之和相等，则相等的选手按照其id降序排列
 * 输入描述：
 * 输入第一行，一个整数N，表示该场比赛总共进行了N次射击，产生N个成绩分数（2<=N<=100）
 * 输入第二行，一个长度为N整数序列，表示参与每次射击的选手id（0<=id<=99）
 * 输入第三行，一个长度为N整数序列，表示参与每次射击选手对应的成绩（0<=成绩<=100）
 * 输出描述：
 * 符合题设条件的降序排名后的选手ID序列
 * <p>
 * 示例
 * 输入：
 * 13
 * 3,3,7,4,4,4,4,7,7,3,5,5,5
 * 53,80,68,24,39,76,66,16,100,55,53,80,55
 * 输出：
 * 5,3,7,4
 * 说明:
 * 该场射击比赛进行了13次，参赛的选手为{3,4,5,7}
 * 3号选手成绩53,80,55 最高三个成绩的和为188
 * 4号选手成绩24,39,76,66 最高三个成绩的和为181
 * 5号选手成绩53,80,55 最高三个成绩的和为188
 * 7号选手成绩68,16,100 最高三个成绩的和为184
 * 比较各个选手最高3个成绩的和，有3号=5号>7号>4，由于3号和5号成绩相等，且id 5>3，所以输出 5,3,7,4
 * @date: 2022/6/14 12:20 上午
 * @version: V-1.0
 */
public class 统计射击比赛成绩_0614 {
    public static void main(String[] args) {
        int n = 13;
        String idStr = "3,3,7,4,4,4,4,7,7,3,5,5,5";
        String scoreStr = "53,80,68,24,39,76,66,16,100,55,53,80,55";
        System.out.println("输入：\n"+n+"\n"+idStr+"\n"+scoreStr);
        System.out.println("输出：");
        getDescId(n, idStr, scoreStr);

        int n1 = 6;
        String idStr1 = "3,3,4,4,7,7";
        String scoreStr1 = "53,80,68,24,39,76";
        System.out.println("输入：\n"+n1+"\n"+idStr1+"\n"+scoreStr1);
        System.out.println("输出：");
        getDescId(n1, idStr1, scoreStr1);
    }

    private static void getDescId(int n, String idStr, String scoreStr) {
        //将输入字符串拆分，并转为int存入List中
        String[] idArr = idStr.split(",");
        String[] scoreArr = scoreStr.split(",");
        List<Integer> idList = new ArrayList<>();
        List<Integer> scoreList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idList.add(Integer.parseInt(idArr[i]));
            scoreList.add(Integer.parseInt(scoreArr[i]));
        }
        //首先使用map统计id及其出现的次数，将次数小于三的id去掉
        Map<Integer, Integer> idCountMap = new HashMap<>();
        for (Integer integer : idList) {
            if (!idCountMap.containsKey(integer)) {
                idCountMap.put(integer, 1);
            } else {
                idCountMap.replace(integer, idCountMap.get(integer) + 1);
            }
        }
        //遍历idCountMap的entrySet,如果value小于3，使用Iterator删除
        Iterator<Map.Entry<Integer, Integer>> iterator = idCountMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() < 3) {
                iterator.remove();
            }
        }
        //特殊情况，如果次数都小于3，则输出空
        if (idCountMap.isEmpty()) {
            System.out.println("");
            return;
        }
        //剩余的都是成绩数大于等于3的
        //遍历idCountMap的keySet，统计每个id的分数，并排序取最大三个数的和，并把id和总和存入map中便于后边排序
        Map<Integer, Integer> idScoreMap = new HashMap<>();
        for (Integer integer : idCountMap.keySet()) {
            //遍历idList，其中值等于integer的下标也是对应scoreList的下标，将其每个id对应的所有成绩存入一个List中
            List<Integer> singleScoreList = new ArrayList<>();
            for (int i = 0; i < idList.size(); i++) {
                if (integer.equals(idList.get(i))) {
                    singleScoreList.add(scoreList.get(i));
                }
            }
            //先排序，降序处理
            singleScoreList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            //取前三个值求和，并将id以及和存入map
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += singleScoreList.get(i);
            }
            idScoreMap.put(integer, sum);
        }
        //将idScoreMap的entrySet存入List，首先根据value降序排序，value相同按照id降序排序
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(idScoreMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o2.getKey() - o1.getKey();
                }
                return o2.getValue() - o1.getValue();
            }
        });
        //排序后拼接list的keySet输出
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            builder.append(entry.getKey()).append(",");
        }
        System.out.println(builder.substring(0, builder.length() - 1).toString());
    }
}
