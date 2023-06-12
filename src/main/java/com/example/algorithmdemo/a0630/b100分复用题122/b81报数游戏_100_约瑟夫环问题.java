package com.example.algorithmdemo.a0630.b100分复用题122;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: b81报数游戏_100_约瑟夫环问题
 * @desc: Todo
 * https://fcqian.blog.csdn.net/article/details/127215504

 * @date: 2023/6/4 9:34
 * @version: V-1.0
 */
public class b81报数游戏_100_约瑟夫环问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(getResult(m));
    }

    private static String getResult(int m) {
        if (m <= 1 || m >= 100) {
            return "ERROR!";
        }

        CycleLinkedList list = new CycleLinkedList();
        for (int i = 1; i <= 100; i++) {
            list.append(i);
        }

        int idx = 1;
        Node cur = list.head;

        while (list.size >= m) {
            if (idx == m) {
                idx = 1;
                cur = list.remove(cur);
            } else {
                idx++;
                cur = cur.next;
            }
        }

        return list.toString();
    }

    private static class Node {
        int val;
        Node prev;
        Node next;

        private Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private static class CycleLinkedList {
        Node head;
        Node tail;
        int size = 0;

        private void append(int val) {
            Node node = new Node(val, null, null);

            if (this.size > 0) {
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = node;
            } else {
                this.head = node;
                this.tail = node;
            }
            this.head.prev = this.tail;
            this.tail.next = this.head;
            this.size++;
        }

        private Node remove(Node cur) {
            Node pre = cur.prev;
            Node nxt = cur.next;

            pre.next = nxt;
            nxt.prev = pre;

            cur.next = cur.prev = null;

            if (this.head == cur) {
                this.head = nxt;
            }

            if (this.tail == cur) {
                this.tail = pre;
            }
            this.size--;
            return nxt;
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(",");

            Node cur = this.head;
            for (int i = 0; i < this.size; i++) {
                sj.add(cur.val + "");
                cur = cur.next;
            }

            return sj.toString();
        }
    }
}




