package com.study.wangwenjun;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/22
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class ThreadClosedForce {

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(new Runnable() {
            @Override
            public void run() {
                // load a very heavy resource.
                // 理论上半小时搞定，但是现在搞不定
                /*while (true) {

                }*/
                try {
                    Thread.sleep(5_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutDown(10_000L);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
