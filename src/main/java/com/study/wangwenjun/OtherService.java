package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class OtherService {

    private DeadLock deadLock;
    private final Object LOCK = new Object();

    public void s1() {
        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName() + "=========s1");
        }
    }

    public void s2() {
        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName() + "=========s2");
            deadLock.m2();
        }
    }

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
}
