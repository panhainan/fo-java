package com.study.wangwenjun;

/**
 * @Use:
 *      1.sleep是Thread的方法，wait是Object的方法
 *      2.sleep不会释放对象锁（或者object monitor），wait会立即释放锁并将object monitor加入到waiting队列中
 *      3.使用sleep不需要依赖monitor，而wait需要
 *      4.sleep方法不需要唤醒，而wait需要唤醒（wait(seconds)方法除外）
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class DifferenceOfWaitAndSleep {

    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        //m1();
        //m2();

        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    //DifferenceOfWaitAndSleep.m11();
                    DifferenceOfWaitAndSleep.m2();
                }
            }.start();
        }
    }



    public static void  m1(){
        try {
            System.out.println(Thread.currentThread().getName()+" enter sleep.");
            Thread.sleep(20_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void  m11(){
        synchronized(LOCK) {
            try {
                System.out.println(Thread.currentThread().getName() + " enter sleep.");
                Thread.sleep(20_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m2(){
        //如果没有synchronized包裹，则会出现IllegalMonitorStateException异常
        synchronized(LOCK){
            try {
                System.out.println(Thread.currentThread().getName()+" enter wait.");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
