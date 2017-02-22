/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.panhainan.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by fo on 2017/1/12.
 */
public class TestThread extends Thread {

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    public static void main(String[] args) {
        new TestThread().start();
        new TestThread().start();
    }
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread name:" + Thread.currentThread().getName() + " Excute time:" + df.format(new Date()));

            try {
                TimeUnit.SECONDS.sleep(3);
//                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
