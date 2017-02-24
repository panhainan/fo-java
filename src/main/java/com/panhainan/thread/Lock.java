package com.panhainan.thread;

import java.util.Collection;

/**
 * @Author: Hainan Pan (FireOct)
 * @Date: 2017/2/24
 * @Email: panhainan@yeah.net
 * @QQ: 1016593477
 * @WebSite: http://panhainan.com
 */
public interface Lock {

    class TimeOutException extends  Exception{
        public TimeOutException(String message) {
            super(message);
        }
    }

    /**
     * 获取锁资源
     *
     * @throws InterruptedException
     */
    void lock() throws InterruptedException;

    /**
     * 在规定的mills毫秒时间内获取锁资源（如果没有获取到，则抛出超时异常）
     * @param mills 限制获取锁的时间，单位毫秒。（如果mills<=0，则直接相当于直接执行lock方法）
     * @throws InterruptedException
     * @throws TimeOutException
     */
    void lock(long mills) throws InterruptedException, TimeOutException;

    /**
     * 释放锁资源
     */
    void unlock();

    /**
     * 获取当前阻塞的线程集合
     * @return
     */
    Collection<Thread> getBlockedTreads();

    /**
     * 获取当前阻塞的线程集合数量
     * @return
     */
    int getBlockedSize();
}
