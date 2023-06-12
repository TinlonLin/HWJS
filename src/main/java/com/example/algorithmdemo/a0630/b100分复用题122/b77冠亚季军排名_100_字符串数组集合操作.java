package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b77冠亚季军排名_100_字符串数组集合操作
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/128009862

 * @date: 2023/6/4 9:31
 * @version: V-1.0
 */
public class b77冠亚季军排名_100_字符串数组集合操作 {

    private static class Country {
        String name;
        int gold;
        int silver;
        int bronze;

        public Country(String name, int gold, int silver, int bronze) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Country[] countries = new Country[n];
        for (int i = 0; i < n; i++) {
            Country c = new Country(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            countries[i] = c;
        }

        getResult(countries);
    }

    private static void getResult(Country[] countries) {
        Arrays.sort(
                countries,
                (a, b) ->
                        b.gold != a.gold
                                ? b.gold - a.gold
                                : b.silver != a.silver
                                ? b.silver - a.silver
                                : b.bronze != a.bronze ? b.bronze - a.bronze : a.name.compareTo(b.name));

        for (Country country : countries) {
            System.out.println(country.name);
        }
    }
}

