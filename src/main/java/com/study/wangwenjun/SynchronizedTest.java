package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class SynchronizedTest {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        try {
                            Thread.sleep(200_000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}
