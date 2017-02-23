package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class DeadLock {

    private OtherService otherService;

    private final Object LOCK = new Object();

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    public void m1() {
        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName() + "=========m1");
            otherService.s1();
        }
    }

    public void m2() {
        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName() + "=========m2");
        }
    }
}
