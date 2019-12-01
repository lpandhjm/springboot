package com.pei.liu.springboot.demo.question;

/**
 * @program: demo
 * @description
 * @author: pei.liu
 * @create: 2019-11-28 15:14
 **/
public class TryCatch {

    public static void main(String[] args) {
        System.out.println(getNumber(1));
    }



//    当 try 中 return 时 ，先是把i的值 保存到局部变量表，准备返回， 这时候执行++不会改变 局部变量表的结果；
//    但 当 finally 里也有return 时候，会忽略try中return，使用 finally中的 return

    private static  int getNumber(int i){
        try {
            return i++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return i;
        }

    }
}
