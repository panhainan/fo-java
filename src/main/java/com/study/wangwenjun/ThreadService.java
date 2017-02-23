package com.study.wangwenjun;

/**
 * @Use: 强行的停止线程-利用守护线程跟随执行线程的关闭而关闭的特性
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/22
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class ThreadService {

    private Thread executeThread;
    private boolean finished = false;

    public void execute(final Runnable task) {
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task);
                //设置为executeThread线程的守护线程
                runner.setDaemon(true);
                runner.start();
                try {
                    //让runner线程可以执行下去
                    runner.join();
                    //正常执行完成则正常退出
                    finished = true;
                } catch (InterruptedException e) {
                    //遇到executeThread线程的中断信号（即executeThread线程结束），则runner守护线程也会结束
                    //e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutDown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时，需要结束他！");
                //执行线程结束，守护线程则必会结束
                executeThread.interrupt();
                break;
            }
            //TODO: 既没有超时，也没有结束，就短暂的休眠一下？？？ why
            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("执行线程被打断！");
                break;
            }
        }
        finished = false;
    }
}
