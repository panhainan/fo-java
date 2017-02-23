package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class SynchronizedRunnable implements Runnable {

    private final int MAX = 500;
    private int index = 1;

    @Override
    public void run() {
        while (true) {
            //方法一：采用synchronized方法
            if (ticket()) {
                break;
            }

            //方法二：采用synchronized代码块
            /*synchronized(this){
                if (index>MAX){
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+" 的号码是："+(index++));
            }*/
        }
    }

    private synchronized boolean ticket() {
        if (index > MAX) {
            return true;
        } else {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
            return false;
        }
    }
}
