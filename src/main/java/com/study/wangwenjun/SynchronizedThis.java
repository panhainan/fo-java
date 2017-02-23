package com.study.wangwenjun;

/**
 * @Use:成员方法加synchronized锁住的是该对象
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class SynchronizedThis {

    private final Object LOCK = new Object();

    public synchronized void m1() {
        System.out.println("m1:" + Thread.currentThread().getName());
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2() {
        System.out.println("m2:" + Thread.currentThread().getName());
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 因为锁住的和m1,m2的this对象不一样，该处锁住的是LOCK对象，所以会直接运行，而不会像m1,m2一样会需要抢占this对象锁
     */
    public void m3() {
        synchronized (LOCK) {
            System.out.println("m3:" + Thread.currentThread().getName());
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
