package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/22
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 */
public class CreateThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ":start...");
                    Thread.sleep(10_000L);//Java1.7的写法
                    System.out.println(Thread.currentThread().getName() + ":done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        };//new

        //Thread.sleep(5_1000L);
        System.out.println(Thread.currentThread().getName());

        System.out.println(System.currentTimeMillis());
        //t.setDaemon(true);
        t.start();//runnable   -> running -> dead|blocked
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
    }
}
