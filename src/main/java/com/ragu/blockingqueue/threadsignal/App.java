package com.ragu.blockingqueue.threadsignal;

import com.ragu.blockingqueue.threadsignal.Consumer;
import com.ragu.blockingqueue.threadsignal.Producer;
import com.ragu.thread.util.ThreadUtil;

public class App {

	public static void main(String[] args) {

		SharedObject lock = new SharedObject();

		Thread prod = new Thread(new Producer(lock));
		prod.setName("Producer");
		Thread con = new Thread(new Consumer(lock));
		con.setName("Consumer1");
		Thread con1 = new Thread(new Consumer(lock));
		con1.setName("Consumer2");

		prod.start();
		con.start();
		con1.start();

		ThreadUtil.startThreadStatusTimer(prod, 1000);
		ThreadUtil.startThreadStatusTimer(con, 1000);
		ThreadUtil.startThreadStatusTimer(con1, 1000);
	}

}
