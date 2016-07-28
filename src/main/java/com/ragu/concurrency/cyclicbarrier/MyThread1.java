package com.ragu.concurrency.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.ragu.thread.util.ThreadUtil;

public class MyThread1 implements Runnable {

	CyclicBarrier barrier;

	public MyThread1(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	Random ran = new Random();

	public void run() {
		ThreadUtil.printCurrentTimeAndThreadAndMessage("Starting...");
		
		try {
			Thread.sleep(ran.nextInt(100000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ThreadUtil.printCurrentTimeAndThreadAndMessage("Assuming that it has completed its 1 job, and waiting for other threads to come here");
		
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		ThreadUtil.printCurrentTimeAndThreadAndMessage("Completed!!!");

	}

}
