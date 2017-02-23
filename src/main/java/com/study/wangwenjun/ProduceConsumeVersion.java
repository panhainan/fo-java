package com.study.wangwenjun;

/**
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
                System.out.println("produce -> " + i);

                //下面两个的前后顺序是否有影响？
                LOCK.notify();
                isProduced = true;
            } else {
                try {
                    LOCK.wait();
                    System.out.println("produce's waiting finished");
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
                System.out.println("consume -> " + i);
                LOCK.notify();
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                    System.out.println("consume's waiting finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final ProduceConsumeVersion pc = new ProduceConsumeVersion();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start();
    }


}
