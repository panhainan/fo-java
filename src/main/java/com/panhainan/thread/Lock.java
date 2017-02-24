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
    void lock() throws InterruptedException;
    void lock(long mills) throws InterruptedException, TimeOutException;
    void unlock();
    Collection<Thread> getBlockedTreads();
    int getBlockedSize();
}
