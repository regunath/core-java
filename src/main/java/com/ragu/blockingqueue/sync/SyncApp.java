package com.ragu.blockingqueue.sync;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;

import com.ragu.thread.util.ThreadUtil;

public class SyncApp {
	 
	   public static void main(String[] args) {
	 
	      final BlockingQueue queue = new SynchronousQueue();
	      Thread p1 = new Thread(new Producer(queue));
	      
	      p1.setName("Producer 1");
	      p1.start();
//	      Thread p2 = new Thread(new Producer(queue));
//	      p2.setName("Producer 2");
//	      p2.start();
	      Thread c1 = new Thread(new Consumer(queue));
	      c1.setName("Consumer 1");
	      c1.start();
	      
	      ThreadUtil.startThreadStatusTimer(p1);
	      //ThreadUtil.startThreadStatusTimer(p2);
	   }
	}
	 
	class Producer implements Runnable {
	   BlockingQueue<String> queue;
	   Producer(BlockingQueue<String> queue) {
	      this.queue = queue;
	   }
	 
	   public void run() {
	      for (int i = 0; i<5; i++) {
	         try {
	        	System.out.println(queue.size());
	            queue.put(Thread.currentThread().getName() + "-" +ThreadLocalRandom.current().nextInt(0,1000));
	            System.out.println(queue.size());
	         } catch (Exception e) {
	         }
	      }
	   }
	}
	 
	class Consumer implements Runnable {
	   BlockingQueue<String> queue;
	   Consumer(BlockingQueue<String> queue) {
	      this.queue = queue;
	   }
	 
	   public void run() {
	      for (;queue.isEmpty();) {
	         try {
	            ThreadUtil.printStr(queue.take());
	            Thread.sleep(2000);
	         } catch (Exception e) {
	         }
	      }
	   }
	}
