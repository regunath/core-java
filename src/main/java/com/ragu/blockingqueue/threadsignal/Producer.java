package com.ragu.blockingqueue.threadsignal;

import com.ragu.thread.util.ThreadUtil;

public class Producer implements Runnable {

	SharedObject obj;

	public Producer(SharedObject obj) {
		this.obj = obj;
	}

	public void run() {
		try {
			Thread.sleep(2000);
			ThreadUtil.printCurrentTimeAndThreadAndMessage("Wokeup from sleep and trying to enter into the sync block");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (obj) {
			obj.setMessage("Message : + " + Math.random());
			ThreadUtil.printCurrentTimeAndThreadAndMessage("Message is ready, notify all");
			//obj.notifyAll();
			obj.notify();
		}
	}

}
