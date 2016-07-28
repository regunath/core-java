package com.ragu.blockingqueue.delayed;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

import com.ragu.thread.util.ThreadUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<DelayedObject> q = new DelayQueue<DelayedObject>();

		Thread prod = new Thread(new DelayQueueProducer(q));
		prod.setName("Producer");
		Thread con1 = new Thread(new DelayQueueConsumer(q));
		con1.setName("Consumer 1");
		
		prod.start();
		con1.start();
		
		//ThreadUtil.startThreadStatusTimer(prod);
		//ThreadUtil.startThreadStatusTimer(con1);
		
	}

}
