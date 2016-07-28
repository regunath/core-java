package com.ragu.thread.util;

public class DummyThread implements Runnable {
	private int sec;
	
	public DummyThread() {
		this.sec = 5;
	}

	public DummyThread(int sec) {
		super();
		this.sec = sec;
	}

	public void run() {
		ThreadUtil.printCurrentTimeAndThreadAndMessage("Started");
		long begin = System.currentTimeMillis();
		long end = begin + 10000 * sec;
		
		for (; end > System.currentTimeMillis();) {
			//DO nothing
		}
		ThreadUtil.printCurrentTimeAndThreadAndMessage("Completed");

	}

}
