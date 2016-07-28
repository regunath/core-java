package com.ragu.concurrency.core;

public class MyIntThread implements Runnable {

	MySyncService t;
	
	public MyIntThread(MySyncService t) {
		this.t = t;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			t.sync1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
