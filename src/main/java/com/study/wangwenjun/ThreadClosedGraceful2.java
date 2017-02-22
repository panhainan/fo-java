package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/22
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class ThreadClosedGraceful2 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                /*if(isInterrupted()){
                    break;
                }*/
                //或者下面这种方法
                if (Thread.interrupted()) {
                    break;
                }
                System.out.println("...");
            }
            //
            System.out.println("interrupt.");

        }

    }

    public static void main(String[] args) {
        Worker worker = new Worker();

        worker.start();
        try {
            Thread.sleep(3_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();

    }

}
