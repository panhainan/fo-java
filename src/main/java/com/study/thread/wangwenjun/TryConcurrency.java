package com.study.thread.wangwenjun;

/**
 * Created by fo on 2017/2/20.
 */
public class TryConcurrency {
    public static void main(String[] args) {
        Thread t1 = new Thread("Task-1-Thread") {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    println("Task 1 => " + i);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        for (int i = 0; i < 50; i++){
            println("Task 2 => " + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        try {
//            Thread.sleep(1000*60*5L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private static void println(String s) {
        System.out.println(s);
    }


}
