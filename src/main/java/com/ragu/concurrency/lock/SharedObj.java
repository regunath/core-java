package com.ragu.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedObj {

	private final Lock lock1 = new ReentrantLock();
	private final Lock lock2 = new ReentrantLock();
	
	void method1(){
		synchronized (lock1) {
			try {
				System.out.println("method1 " + Thread.currentThread().getName());
				Thread.sleep(2000);
				if(checkLock(lock1, lock2)){
					synchronized (lock2) {
						Thread.sleep(5000);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("done!!!method1 " + Thread.currentThread().getName());
		}
		//System.out.println(Thread.currentThread().getName() + "calling method2 ");
		//this.method2();
	}
	
	void method2(){
		synchronized (lock2) {
			try {
				System.out.println("method2 " + Thread.currentThread().getName());
				if(checkLock(lock1, lock2)){
					synchronized (lock1) {
						Thread.sleep(5000);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("done!!!method2 " + Thread.currentThread().getName());
		}
		//System.out.println(Thread.currentThread().getName() + "calling method1 ");
		//this.method1();
	}
	
	public boolean checkLock(Lock lock1, Lock lock2) {
        Boolean myLock = false;
        Boolean yourLock = false;
        try {
            myLock = lock1.tryLock();
            yourLock = lock2.tryLock();
        } finally {
            if (! (myLock && yourLock)) {
                if (myLock) {
                    lock1.unlock();
                }
                if (yourLock) {
                    lock2.unlock();
                }
            }
        }
        return myLock && yourLock;
    }

}
