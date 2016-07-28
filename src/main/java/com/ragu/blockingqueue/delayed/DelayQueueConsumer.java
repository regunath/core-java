package com.ragu.blockingqueue.delayed;

import java.util.concurrent.BlockingQueue;

public class DelayQueueConsumer implements Runnable {

	private final BlockingQueue<DelayedObject> queue;

	DelayQueueConsumer(BlockingQueue<DelayedObject> q) {
		queue = q;
	}

	public void run() {
		while (true) {
			try {
				// Take elements out from the DelayQueue object.
				DelayedObject object = queue.take();
				System.out.printf("[%s] - Take object = %s%n", Thread.currentThread().getName(), object);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
