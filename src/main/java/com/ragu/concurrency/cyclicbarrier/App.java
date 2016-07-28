package com.ragu.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.ragu.thread.util.ThreadUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final CyclicBarrier barrier = new CyclicBarrier(3);
		
		Thread t1 = new Thread(new MyThread1(barrier));
		Thread t2 = new Thread(new MyThread1(barrier));
		
		ThreadUtil.printCurrentTimeAndThreadAndMessage("Starting both the threads");
		
		t1.start();
		t2.start();
		
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ThreadUtil.printCurrentTimeAndThreadAndMessage("All done!!!");
	}

}
