package com.ragu.concurrency.myvolatile;

import com.ragu.thread.util.ThreadUtil;

public class App {

	volatile static long volatileCount = 0; 
	static long nonVolatileCount = 0;
	public static void main(String[] args) {

		ThreadUtil.printCurrentTimeAndThread();
		
		for(long i =0; i<=1000000000; i++){
			volatileCount++;
		}
		
		System.out.println("Count value : " + volatileCount);
		ThreadUtil.printCurrentTimeAndThread();
		
		ThreadUtil.printCurrentTimeAndThread();
		
		for(long i =0; i<=1000000000; i++){
			nonVolatileCount++;
		}
		
		System.out.println("Count value : " + nonVolatileCount);
		ThreadUtil.printCurrentTimeAndThread();
		
	}

}
