package com.ragu.blockingqueue.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;

import com.ragu.thread.util.ThreadUtil;

public class DequeApp {

	public static void main(String[] args) {

		final BlockingDeque<String> dequeue = new LinkedBlockingDeque<String>();
		Thread p1 = new Thread(new FrontProducer(dequeue));
		p1.setName("Front Producer 1");
		p1.start();
		Thread p2 = new Thread(new BackProducer(dequeue));
		p2.setName("Back Producer 2");
		p2.start();
		Thread c1 = new Thread(new FrontConsumer(dequeue));
		c1.setName("Front Consumer 1");
		c1.start();
		Thread c2 = new Thread(new BackConsumer(dequeue));
		c2.setName("Back Consumer 2");
		c2.start();

		// ThreadUtil.startThreadStatusTimer(p1);
		// ThreadUtil.startThreadStatusTimer(p2);
	}
}

class FrontProducer implements Runnable {
	BlockingDeque<String> queue;

	FrontProducer(BlockingDeque<String> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				queue.addFirst(Thread.currentThread().getName() + "-" + ThreadLocalRandom.current().nextInt(0, 1000));
			} catch (Exception e) {
			}
		}
	}
}

class BackProducer implements Runnable {
	BlockingDeque<String> queue;

	BackProducer(BlockingDeque<String> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				queue.addLast(Thread.currentThread().getName() + "-" + ThreadLocalRandom.current().nextInt(0, 1000));
			} catch (Exception e) {
			}
		}
	}
}

class FrontConsumer implements Runnable {
	BlockingDeque<String> queue;

	FrontConsumer(BlockingDeque<String> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				ThreadUtil.printStr(queue.takeFirst());
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}

		ThreadUtil.printStr("Front consumer done!!!");
	}
}

class BackConsumer implements Runnable {
	BlockingDeque<String> queue;

	BackConsumer(BlockingDeque<String> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				ThreadUtil.printStr(queue.takeLast());
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}
		ThreadUtil.printStr("Back consumer done!!!");
	}
}
