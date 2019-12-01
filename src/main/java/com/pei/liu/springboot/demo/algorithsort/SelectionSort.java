package com.pei.liu.springboot.demo.algorithsort;

import java.util.Arrays;

/**
 * @program: demo
 * @description 选择排序：
 * 首先在未排序序列中找到最小（大）元素，
 * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
 * @author: pei.liu
 * @create: 2019-11-27 17:58
 **/
public class SelectionSort {

    private static int[] a = {2, 1, 7, 5, 9, 3, 4, 8, 5, 0, 6};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            int minIndex=i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex=j;
                }
            }
            int temp =a[minIndex];
            a[minIndex]=a[i];
            a[i]=temp;
        }
        System.out.println(Arrays.toString(a));
    }

}
