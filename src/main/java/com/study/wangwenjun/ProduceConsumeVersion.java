package com.study.wangwenjun;

/**
 * @Use: 存在多个消费或者生产者线程时会出现假死现象
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/23
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class ProduceConsumeVersion {

    final private Object LOCK = new Object();
    private boolean isProduced = false;
    private int i = 0;

    public void produce() {
        synchronized (LOCK) {
            if (!isProduced) {
                //没有生产,则生产一个
                i++;
                System.out.println(Thread.currentThread().getName()+" produce -> " + i);
                //唤醒等待的线程，让其处于就绪状态，等此线程执行完成后即可抢占LOCK锁资源进行执行状态
                LOCK.notify();
                isProduced = true;
            } else {
                try {
                    System.out.println(Thread.currentThread().getName()+" produce's waiting start");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName()+" produce's waiting end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                //已经生产了，则消费
                System.out.println(Thread.currentThread().getName()+" consume -> " + i);
                LOCK.notify();
                isProduced = false;
            } else {
                try {
                    System.out.println(Thread.currentThread().getName()+" consume's waiting start");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName()+" consume's waiting end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final ProduceConsumeVersion pc = new ProduceConsumeVersion();
        //TODO:存在问题，多个生产者或者消费者时会出现假死状态，所有线程放弃CPU的执行权
        new Thread("P1") {
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();
        /*new Thread("P2") {
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();*/
        new Thread("C1") {
            @Override
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start();
        /*new Thread("C2") {
            @Override
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start();*/
    }


}
