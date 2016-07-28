package com.ragu.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	Exchanger<String> exchanger = new Exchanger<String>();

	private class Producer implements Runnable {
		private String queue;

		public void run() {
			try {
				// create tasks & fill the queue
				// exchange the full queue for a empty queue with Consumer
				System.out.println("Producer trying to exchange!!");
				queue = exchanger.exchange("Ready Queue");
				System.out.println(Thread.currentThread().getName() + " now has " + queue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private class Consumer implements Runnable {

		private String queue;

		public void run() {
			try {
				// do procesing & empty the queue
				// exchange the empty queue for a full queue with Producer
				Thread.sleep(5000);
				System.out.println("Consumer awaken!!");
				queue = exchanger.exchange("Empty Queue");
				System.out.println(Thread.currentThread().getName() + " now has " + queue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void start() {
		new Thread(new Producer(), "Producer").start();
		new Thread(new Consumer(), "Consumer").start();
	}

	public static void main(String[] args) {
		new ExchangerExample().start();
	}

}