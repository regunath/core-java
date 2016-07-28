package com.ragu.concurrency.lock;

public class Thread2 implements Runnable {
	SharedObj obj;
	
	public Thread2(SharedObj obj) {
		this.obj = obj;
	}

	public void run() {
		obj.method2();
	}

}
