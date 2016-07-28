package com.ragu.concurrency.core;

public class MySyncService {
	
	Object lock1 = new Object();
	Object lock2 = new Object();

	public void sync() throws InterruptedException{
		synchronized (this){
			System.out.println("Sync Thread " + Thread.currentThread().getName() + "Sleeping");
			Thread.sleep(10000);
		}
		this.sync1();
		System.out.println("Sync Thread " + Thread.currentThread().getName() + "Done!!!");
	}
	
	public void sync1() throws InterruptedException{
		synchronized (this){
			System.out.println("Sync1 Thread " + Thread.currentThread().getName() + " Sleeping");
			Thread.sleep(10000);
			System.out.println("Sync1 Thread " + Thread.currentThread().getName() + " Done!!!");
		}
	}
	
}
