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

    /**
     * 当前所有没有获得锁的线程集合
     */
    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    /**
     * 当前已经获得锁的线程
     */
    private Thread currentGetLockThread;

    public BooleanLock() {
        //初始化，设置锁资源为可抢占状态
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        //判断锁资源-initValue 是否被抢占
        while (initValue) {
            //当前锁资源-initValue已被抢占，则当前线程加入到阻塞线程集合中，并进入等待状态
            //1.当前线程加入到阻塞线程集合中，如果已存在则不添加
            if (!blockedThreadCollection.contains(Thread.currentThread())) {
                blockedThreadCollection.add(Thread.currentThread());
            }
            //2.当前线程进入等待状态
            this.wait();
        }
        //当前锁资源-initValue未被抢占，当前线程则将锁资源-initValue抢占下来
        //1.设置当前拿到锁的线程
        currentGetLockThread = Thread.currentThread();
        //2.将当前拿到锁的线程从阻塞线程集合中移除
        blockedThreadCollection.remove(currentGetLockThread);
        System.out.println(currentGetLockThread.getName() + " have the lock Moniter");
        //3.将锁资源设置为已被抢占状态
        this.initValue = true;
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        //安全检查，如果mills参数小于等于零，则让其直接进入lock方法
        if (mills <= 0) {
            lock();
        }
        //剩余毫秒数初始化为传入的参数值
        long haveRemaining = mills;
        //计算出结束请求锁时间
        long endTime = System.currentTimeMillis() + mills;
        //判断锁资源-initValue 是否被抢占
        while (initValue) {
            //1.判断是否已经到达请求结束的时间
            if (haveRemaining <= 0) {
                //到达请求的截止时间，将当前线程从阻塞线程中移除，并抛出超时的异常
                blockedThreadCollection.remove(Thread.currentThread());
                throw new TimeOutException("Time out.");
            }
            //2.当前线程加入到阻塞线程集合中，如果已存在则不添加
            if (!blockedThreadCollection.contains(Thread.currentThread())) {
                blockedThreadCollection.add(Thread.currentThread());
            }
            //3.当前线程进入等待状态
            this.wait();
            //4.刷新请求剩余毫秒数
            haveRemaining = endTime - System.currentTimeMillis();
        }
        //当前锁资源-initValue未被抢占，当前线程则将锁资源-initValue抢占下来
        //1.设置当前拿到锁的线程
        currentGetLockThread = Thread.currentThread();
        //2.将当前拿到锁的线程从阻塞线程集合中移除
        blockedThreadCollection.remove(currentGetLockThread);
        System.out.println(currentGetLockThread.getName() + " have the lock monitor");
        //3.将锁资源设置为已被抢占状态
        this.initValue = true;
    }

    @Override
    public synchronized void unlock() {
        //判断当前线程是否为当前已抢占到锁的线程
        if (Thread.currentThread() == currentGetLockThread) {
            //是，则有权限释放锁资源，并唤醒其他阻塞线程
            System.out.println(currentGetLockThread.getName() + " release the lock monitor");
            this.initValue = false;
            this.notifyAll();
        }
        //否，没有权限释放锁
    }

    @Override
    public Collection<Thread> getBlockedTreads() {

        //为避免当前阻塞线程集合被修改，返回一个不能被修改的（即只读）阻塞线程集合
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
