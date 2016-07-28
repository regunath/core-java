package com.ragu.concurrency.core;

public class MyThread extends Thread {

	MySyncService service;
	
	public MyThread(MySyncService service) {
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			service.sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
