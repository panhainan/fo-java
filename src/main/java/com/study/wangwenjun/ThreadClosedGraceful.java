package com.study.wangwenjun;

/**
 * @Use: 优雅的关闭线程
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/22
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class ThreadClosedGraceful {

    private static class Worker extends Thread {

        private volatile boolean start = true;

        @Override
        public void run() {
            int i = 0;
            while (start) {
                //
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(++i + "s");
            }

        }

        public void shutDown() {
            this.start = false;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();

        worker.start();
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutDown();
    }
}
