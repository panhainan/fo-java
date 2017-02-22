package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/22
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 1;
    private final int MAX  = 500;
    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (index > MAX) {
                    break;
                }

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+" 的号码是："+(index++));
            }
        }
    }
}
