package com.study.wangwenjun;

/**
 * @Use: 解决存在多个消费或者生产者线程时会出现假死现象
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class ProduceConsumeVersion2 {

    final private Object LOCK = new Object();
    private boolean isProduced = false;
    private int i = 0;

    public void produce() {
        synchronized (LOCK) {
            while (isProduced) {
                try {
                    //System.out.println(Thread.currentThread().getName()+" produce's waiting start");
                    LOCK.wait();
                    //System.out.println(Thread.currentThread().getName()+" produce's waiting end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //没有生产,则生产一个
            i++;
            System.out.println(Thread.currentThread().getName()+" produce -> " + i);
            //唤醒等待的线程，让其处于就绪状态，等此线程执行完成后即可抢占LOCK锁资源进行执行状态
            LOCK.notifyAll();
            isProduced = true;
        }
    }

    public void consume() {
        synchronized (LOCK) {
            while (!isProduced) {
                try {
                    //System.out.println(Thread.currentThread().getName()+" consume's waiting start");
                    LOCK.wait();
                    //System.out.println(Thread.currentThread().getName()+" consume's waiting end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //已经生产了，则消费
            System.out.println(Thread.currentThread().getName()+" consume -> " + i);
            LOCK.notifyAll();
            isProduced = false;
        }
    }

    public static void main(String[] args) {
        final ProduceConsumeVersion2 pc = new ProduceConsumeVersion2();

        for (int i = 0;i<=5;i++){
            new Thread("P"+i) {
                @Override
                public void run() {
                    while (true) {
                        pc.produce();
                    }
                }
            }.start();
        }
        for (int i = 0;i<=2;i++){
            new Thread("C"+i) {
                @Override
                public void run() {
                    while (true) {
                        pc.consume();
                    }
                }
            }.start();
        }
    }


}
