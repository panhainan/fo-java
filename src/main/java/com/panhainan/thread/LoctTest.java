package com.panhainan.thread;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/24
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class LoctTest {

    public static void main(String[] args) {

        final BooleanLock booleanLock = new BooleanLock();

        for (int i = 0; i < 4; i++) {
            new Thread("T"+i){
                @Override
                public void run() {
                    try {
                        booleanLock.lock();
                        work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        booleanLock.unlock();
                    }

                }
            }.start();
        }

    }

    public static void work() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" is working.");
        Thread.sleep(10_000L);
    }
}
