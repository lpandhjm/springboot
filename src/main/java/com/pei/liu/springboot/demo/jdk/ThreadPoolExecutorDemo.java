package com.pei.liu.springboot.demo.jdk;

import java.util.List;
import java.util.concurrent.*;

/**
 * @program: demo
 * @description
 * @author: pei.liu
 * @create: 2019-11-29 19:20
 **/
public class ThreadPoolExecutorDemo {

    /**
     * 核心线程数
     */
    private static  int CORE_POOL_SIZE=2;

    /**
     * 最大线程数
     */
    private static  int MAX_POOL_SIZE=5;

    /**
     * 空余线程存活时间（当线程数量大于核心线程数量时候，多余线程空闲时间超过这时间就会销毁）
     */
    private  static  Long KEEP_ALIVE_TIME=1L;

    /**
     *  任务等待（排队）策略
     * SynchronousQueue  不排队，直接提交运行
     * ArrayBlockingQueue 有界队列
     * LinkedBlockingQueue 无界队列，一直缓存任务
     */
    private static  BlockingQueue BLOCKING_QUEUE =new ArrayBlockingQueue(100);






    /**
     *  重写下线程池名称
     */
    private  static ThreadFactory THREAD_FACTORY=new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {

            return new Thread(r, "自定义线程池名字");
        }
    };


    /**
     * 当队列满了 饱和策略
     * ThreadPoolExecutor.AbortPolicy           抛出 RejectedExecutionException来拒绝新任务的处理（默认）
     * ThreadPoolExecutor.CallerRunsPolicy      调用线程执行任务，
     * ThreadPoolExecutor.DiscardPolicy         不处理，直接丢弃
     * ThreadPoolExecutor.DiscardOldestPolicy   此策略将丢弃最早的未处理的任务请求
     */



    private static ThreadPoolExecutor threadPoolExecutor ;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

         threadPoolExecutor = new ThreadPoolExecutor(
                        CORE_POOL_SIZE,
                        MAX_POOL_SIZE,
                        KEEP_ALIVE_TIME,
                        TimeUnit.SECONDS, BLOCKING_QUEUE
                );

        for (int i = 0; i < 10; i++) {
//            threadPoolExecutor.execute(runnableA);
//            通过submit提交任务会返回一个Future对象，可以通过get（）方法来阻塞线程等待线程执行完毕。

            UserDemo userDemo =new UserDemo("liupei",26);
            Runnable runnableA =new A(userDemo);
            Future<UserDemo> future =  threadPoolExecutor.submit(runnableA,userDemo);
            System.out.println("原先的user"+userDemo);
            System.out.println("future里的User"+future.get());
        }
        B b =new B();
        Future<UserDemo> future= threadPoolExecutor.submit(b);
        System.out.println("callable使用,future里的值"+future.get());

//        可以通过shoutdownNow来终止线程池，并返回没有执行的队列
        List<Runnable> runnableList = threadPoolExecutor.shutdownNow();
        System.out.println("终止线程池，返回没有执行的线程队列"+runnableList.size());
    }

    static class A implements  Runnable{
        UserDemo userDemo;
        public A(UserDemo userDemo) {
            this.userDemo=userDemo;
        }

        @Override
        public void run() {
//            可以在这里重设线程名字
//            Thread.currentThread().setName("xxx");
            try {
                Thread.sleep(200L);
                userDemo.setName("hjm");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程执行完毕");

            }

        }

        static class  B implements Callable{

            @Override
            public UserDemo call() throws Exception {
                return new UserDemo("liupei",26);
            }
        }

        static class UserDemo {
            private  String name;
            private int age;

            public UserDemo(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public UserDemo setName(String name) {
                this.name = name;
                return this;
            }

            public int getAge() {
                return age;
            }

            public UserDemo setAge(int age) {
                this.age = age;
                return this;
            }

            @Override
            public String toString() {
                return "UserDemo{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }

    }


