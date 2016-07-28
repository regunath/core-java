package com.ragu.blockingqueue.priority;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class PriorityApp {
	 
	   public static void main(String[] args) {
	 
	      final BlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>();
	      new Thread(new Producer(queue)).start();
	      new Thread(new Consumer(queue)).start();
	 
	   }
	}
	 
	class Producer implements Runnable {
	   BlockingQueue<Integer> queue;
	   Producer(BlockingQueue<Integer> queue) {
	      this.queue = queue;
	   }
	 
	   public void run() {
	      for (int i = 0; i<5; i++) {
	         try {
	            queue.put(ThreadLocalRandom.current().nextInt(0,1000));
	         } catch (Exception e) {
	         }
	      }
	   }
	}
	 
	class Consumer implements Runnable {
	   BlockingQueue<Integer> queue;
	   Consumer(BlockingQueue<Integer> queue) {
	      this.queue = queue;
	   }
	 
	   public void run() {
	      for (int i = 0; i<5; i++) {
	         try {
	            System.out.println(queue.take());
	         } catch (Exception e) {
	         }
	      }
	   }
	}
