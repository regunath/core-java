package com.ragu.blockingqueue.delayed;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

import com.ragu.thread.util.ThreadUtil;

public class DelayQueueProducer implements Runnable {

	private final BlockingQueue<DelayedObject> queue;

	public DelayQueueProducer(BlockingQueue<DelayedObject> q) {
		queue = q;
	}

	private final Random random = new Random();

	public void run() {
		while (true) {
			try {
				// Put some Delayed object into the DelayQueue.
				int delay = random.nextInt(100000);
				DelayedObject object = new DelayedObject(UUID.randomUUID().toString(), delay);
				ThreadUtil.printStr("Put object = " + object);
				queue.put(object);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
