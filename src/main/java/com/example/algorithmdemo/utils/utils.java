package com.example.algorithmdemo.utils;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.text.DecimalFormat;

/**
 * @author: TinlonLin
 * @email: tilolin@qq.com
 * @classname: utils
 * @desc: Todo
 * @date: 2022/7/16 12:03 下午
 * @version: V-1.0
 */
public class utils {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long startMemory = runtime.freeMemory();
        long startTime = System.currentTimeMillis();
        //待运行方法
        System.out.println((1+2));
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + (endTime - startTime) + "ms");
        long endMemory = runtime.freeMemory();
        DecimalFormat df = new DecimalFormat("###.0");
        System.out.println("占用内存：" + df.format((startMemory - endMemory) / (1024.0 * 1024.0)) + "MB");
    }

    public static void getRumTimeAndMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long startMemory = runtime.freeMemory();
        long startTime = System.currentTimeMillis();
        //待运行方法
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + (endTime - startTime) + "ms");
        long endMemory = runtime.freeMemory();
        DecimalFormat df = new DecimalFormat("###.0");
        System.out.println("占用内存：" + df.format((startMemory - endMemory) / (1024.0 * 1024.0)) + "MB");
    }
}
