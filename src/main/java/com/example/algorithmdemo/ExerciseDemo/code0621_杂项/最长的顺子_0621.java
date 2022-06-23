package com.example.algorithmdemo.ExerciseDemo.code0621_杂项;

import java.util.*;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: 最长的顺子_0622
 * @desc: 最长的顺子
 * 斗地主起源于湖北十堰房县，据说是一位叫吴修全的年轻人根据当地流行的扑克玩法“跑得快”改编的，如今已风靡整个中国，并流行于互联网上。
 * 牌型:单顺，又称顺子，最少5张牌，最多12张牌(3...A)不能有2，也不能有大小王，不计花色。
 * 例如 3-4-5-6-7-8，7-8-9-10-J-Q，3-4-5-6-7-8-9-10-J-Q-K-A
 * 可用的牌 3<4<5<6<7<8<9<10<J<Q<K<A<2<B(小王)<C(大王)，每种牌除大小王外有四种花色(共有13*4+2张牌)
 * 输入：1、手上有的牌 2、已经出过的牌(包括对手出的和自己出的牌)
 * 输出：对手可能构成的最长的顺子(如果有相同长度的顺子，输出牌面最大的那个那一个)，如果无法构成顺子，则输出 NO-CHAIN
 * 输入描述:
 * 输入的第一行为当前手中的牌
 * 输入的第二行为已经出过的牌
 * 输出描述:
 * 最长的顺子
 * 示例:
输入
3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A
4-5-6-7-8-8-8
 * 输出
 * 9-10-J-Q-K-A
 * https://blog.nowcoder.net/n/370233d952834c60ae1df50138d4d39b
 * @date: 2022/6/19 8:47 下午
 * @version: V-1.0
 */
public class 最长的顺子_0621 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String curCardStr = sc.nextLine();
        String passCardStr = sc.nextLine();
        getLongestChain(curCardStr, passCardStr);
    }

    private static void getLongestChain(String curCardStr, String passCardStr) {
        //只统计能构成顺子的牌
        //将已知的牌存到一个List里
        List<Integer> cardList = new ArrayList<>();
        String[] curCardArr = curCardStr.split("-");
        for (int i = 0; i < curCardArr.length; i++) {
            if (!"B".equals(curCardArr[i]) && !"C".equals(curCardArr[i]) && !"2".equals(curCardArr[i])){
                cardList.add(getCardValue(curCardArr[i]));
            }
        }
        String[] passCardArr = curCardStr.split("-");
        for (int i = 0; i < passCardArr.length; i++) {
            if (!"B".equals(curCardArr[i]) && !"C".equals(curCardArr[i]) && !"2".equals(curCardArr[i])){
                cardList.add(getCardValue(passCardArr[i]));
            }
        }
        //升序处理
        Collections.sort(cardList);
        //将所有牌及张数（默认四张）存到Map中,LinkedHashMap可以保证输入元素的顺序
        Map<Integer,Integer> cardCountMap = new LinkedHashMap<>();
        for (int i = 3; i <= 14 ; i++) {
            cardCountMap.put(i,4);
        }
        //遍历cardList，已出现的牌在map中减去对应的次数
        for (Integer integer : cardList) {
            if (cardCountMap.containsKey(integer)) {
                cardCountMap.replace(integer,cardCountMap.get(integer) - 1);
            }
        }
        //将剩余的牌存到一个list中,每张牌只要一张
        List<Integer> remainCardList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : cardCountMap.entrySet()) {
            if (integerIntegerEntry.getValue() != 0) {
                remainCardList.add(integerIntegerEntry.getKey());
            }
        }

        //如果remainCardList不足五张牌，不能构成顺子
        if (remainCardList.size() < 5) {
            System.out.println("NO-CHAIN");
            return;
        }

        //牌数大于等于5，遍历remainCardList,找顺子
        //使用list存储
        List<List<Integer>> chainList = new ArrayList<>();
        int start = 0;
        int end = 4;
        while (start <= remainCardList.size() - 5) {
            int distance = end - start;
            if (remainCardList.get(start) + distance == remainCardList.get(end)) {
                //存在顺子则使用一个list存储
                List<Integer> singleList = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    singleList.add(remainCardList.get(i));
                    chainList.add(singleList);
                }
            }
            if (end < remainCardList.size() -1) {
                //继续寻找以当前start开头的顺子
                end++;
            } else {
                //寻找下一个start开头的顺子
                start++;
                end = start + 4;
            }
        }

        //如果没有顺子，输出NO-CHAIN，存在则先找到最长的顺子再拼接输出
        if (chainList.size() == 0) {
            System.out.println("NO-CHAIN");
        } else {

            chainList.sort(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    if (o1.size() == o2.size()) {
                        return o2.get(0) - o1.get(0);
                    }
                    return o2.size() - o1.size();
                }
            });
            System.out.println(chainList.toString());
            List<Integer> longestChainList = chainList.get(0);
            StringBuilder builder = new StringBuilder();
            for (Integer integer : longestChainList) {
                builder.append(getCard(integer)).append("-");
            }
            System.out.println(builder.substring(0,builder.length() - 1).toString());
        }



    }

    private static int getCardValue(String cardStr) {
        //牌转数字
        switch (cardStr) {
            case "J" : return 11;
            case "Q" : return 12;
            case "K" : return 13;
            case "A" : return 14;
            default: return Integer.parseInt(cardStr);
        }
    }

    private static String getCard(int card) {
        //数字转牌
        switch (card) {
            case 11 : return "J";
            case 12 : return "Q";
            case 13 : return "K";
            case 14 : return "A";
            default: return String.valueOf(card);
        }
    }


}
