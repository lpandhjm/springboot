package com.pei.liu.springboot.demo.algorithsort;

import java.util.Arrays;

/**
 * @program: demo
 * @description 冒泡排序
 * @author: pei.liu
 * @create: 2019-11-25 19:11
 **/
public class Bubble {

    public static void main(String[] args) {

        /**
         * 冒泡排序算法原理：
         * 比较相邻的元素。如果第一个比第二个大，就交换他们两个
         * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数
         * 针对所有的元素重复以上的步骤，除了最后一个
         * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
         */
        int[] a = {1, 3, 4, 2, 4, 5, 9, 6, 11, 3, 2, 4};
        System.out.println(Arrays.toString(a));
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}

