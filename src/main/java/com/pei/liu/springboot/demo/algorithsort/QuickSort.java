package com.pei.liu.springboot.demo.algorithsort;

import java.util.Arrays;

/**
 * @program: demo
 * @description 快速排序
 * @author: pei.liu
 * @create: 2019-11-25 19:48
 **/
public class QuickSort {

    /**
     * 原理：
     * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
     * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
     */
    public static void main(String[] args) {
//        1、先从数列中取出一个数作为基准数
//        2.分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
//        3.再对左右区间重复第二步，直到各区间只有一个数
        int[] a = {6,2,9,6,1,3,8,7,4,5,10,6,2,1,6};
        int low = 0,high=a.length-1;
        quick(a,low,high);

    }

    public static  void quick(int []a, int low, int high){
        System.out.println("区间["+low+","+high+"]");
        System.out.println("交换前:    "+Arrays.toString(a));
        if(low>=high){
            return;
        }
        //基准数
        int p=a[low];
        int i=low,j=high;
        while (i < j) {
            //从右边找一个小于基数的数字
            while (a[j] >= p && i < j) {
                j--;
            }
            //从左边找一个大于基数的数字 ,
            while (a[i] <=p && i < j) {
                i++;
            }
            //找到后交换位置
            swap(a, i, j);
        }
        //此时i==j
        //需要从新设置 基准数
        a[low]=a[i];
        a[i]=p;
        //左右递归
        quick(a,low,i-1);
        quick(a,i+1,high);
    }

    private static void swap(int[] a, int i, int j) {
        if(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }
}
