package com.pei.liu.springboot.demo.jdk;

/**
 * @program: demo
 * @description Volatile demo
 * @author: pei.liu
 * @create: 2019-11-29 17:08
 **/
public class VolatileDemo {

    private static boolean ready;
    private static int number=0;

    private static class Reader extends Thread{
        @Override
        public void run(){
            while(!ready){
                System.out.println("暂停");
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args){
        new Reader().start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 42;
        ready = true;
    }


}

