package com.panhainan.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/24
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public class BooleanLock implements Lock {

    /**
     * true:锁已被使用
     * false:锁未被使用，可以被抢占
     */
    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    private Thread currentThread;

    public BooleanLock() {
        this.initValue = initValue;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue) {
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }

        currentThread = Thread.currentThread();
        blockedThreadCollection.remove(currentThread);
        System.out.println(currentThread.getName() + " have the lock Moniter");
        this.initValue = true;
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <= 0) {
            lock();
        }
        long haveRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue) {
            if (haveRemaining <= 0) {
                throw new TimeOutException("Time out.");
            }
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
            haveRemaining = endTime - System.currentTimeMillis();
        }
        currentThread = Thread.currentThread();
        blockedThreadCollection.remove(currentThread);
        System.out.println(currentThread.getName() + " have the lock moniter");
        this.initValue = true;
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {
            System.out.println(currentThread.getName() + " release the lock Moniter");
            this.initValue = false;
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedTreads() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
