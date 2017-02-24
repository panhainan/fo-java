package com.study.wangwenjun;

/**
 * @Use: Synchronized无法被中断
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/24
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class SynchronizedProblem {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread("T1"){
            @Override
            public void run() {
                SynchronizedProblem.work();
            }
        };
        t1.start();
        Thread.sleep(1000L);
        Thread t2 = new Thread("T2"){
            @Override
            public void run() {
                SynchronizedProblem.work();
            }
        };
        t2.start();
        Thread.sleep(1000L);
        t1.interrupt();
        System.out.println(t1.isInterrupted());


    }


    public static synchronized void work(){
        System.out.println(Thread.currentThread());
        while (true){

        }
    }
}
