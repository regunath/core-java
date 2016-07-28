package com.ragu.blockingqueue.threadsignal;

import com.ragu.thread.util.ThreadUtil;

public class Consumer implements Runnable {
	SharedObject obj;
	long sleepTime;

	public Consumer(SharedObject obj) {
		this.obj = obj;
		this.sleepTime = 500;
	}

	public Consumer(SharedObject obj, long sleepTime) {
		this.obj = obj;
		this.sleepTime = sleepTime;
	}

	public void run() {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ThreadUtil.printCurrentTimeAndThreadAndMessage("Wokeup from sleep and trying to enter into the sync block");
		synchronized (obj) {
			try {
				ThreadUtil.printCurrentTimeAndThreadAndMessage("Got the lock and going on wait!");
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ThreadUtil.printCurrentTimeAndThreadAndMessage(obj.message);
		}

	}

}
