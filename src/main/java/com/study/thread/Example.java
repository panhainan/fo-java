package com.study.thread;

class Counter{
    long count = 0;

    public synchronized void add(long value){
        this.count += value;
        System.out.println("Thread " +Thread.currentThread().getName()+" count:"+count);
    }
}
 class CounterThread extends Thread{

    protected Counter counter = null;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    public void run() {
        for(int i=0; i<10; i++){
            counter.add(i);
        }
    }
}
public class Example {

    public static void main(String[] args){
        Counter counter = new Counter();
        Thread  threadA = new CounterThread(counter);
        Thread  threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
    }
}