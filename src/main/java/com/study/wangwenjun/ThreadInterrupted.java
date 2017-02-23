package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/22
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class ThreadInterrupted {

    public static void main(String[] args) {
        /*Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t.start();
        Thread.sleep(1000L);
        System.out.println(t.isInterrupted());
        //System.out.println(t.isAlive());
        t.interrupt();
        System.out.println(t.isInterrupted());
        //System.out.println(t.isAlive());*/

        final Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        t.start();

        final Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.interrupt();
                System.out.println("interrupt.");
            }
        };
        t2.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
