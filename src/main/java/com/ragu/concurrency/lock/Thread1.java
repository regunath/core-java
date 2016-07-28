package com.ragu.concurrency.lock;

public class Thread1 implements Runnable {

	SharedObj obj;
	
	public Thread1(SharedObj obj) {
		this.obj = obj;
	}

	public void run() {
		obj.method1();
	}
}
