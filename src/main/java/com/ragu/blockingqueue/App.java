package com.ragu.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.ragu.thread.util.ThreadUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> q = new LinkedBlockingQueue<String>();
		Thread prod = new Thread(new Producer(q));
		prod.setName("Producer");
		Thread con1 = new Thread(new Consumer(q));
		con1.setName("Consumer 1");
		Thread con2 = new Thread(new Consumer(q));
		con2.setName("Consumer 2");
		
		prod.start();
		
		con1.start();
		con2.start();
		
		ThreadUtil.startThreadStatusTimer(prod);
		ThreadUtil.startThreadStatusTimer(con1);
		ThreadUtil.startThreadStatusTimer(con2);
		
	}

}
