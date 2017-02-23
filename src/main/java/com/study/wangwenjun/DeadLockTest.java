package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class DeadLockTest {

    public static void main(String[] args) {

        final OtherService service = new OtherService();
        final DeadLock deadLock = new DeadLock(service);

        service.setDeadLock(deadLock);
        new Thread("T1") {
            @Override
            public void run() {
                while (true) {
                    deadLock.m1();
                }
            }
        }.start();
        new Thread("T2") {
            @Override
            public void run() {
                while (true) {
                    service.s2();
                }
            }
        }.start();
    }
}
