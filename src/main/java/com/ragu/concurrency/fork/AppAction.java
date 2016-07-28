package com.ragu.concurrency.fork;

import java.util.concurrent.ForkJoinPool;

public class AppAction {

	public static void main(String[] args) {
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(50);

		forkJoinPool.invoke(myRecursiveAction);
	}

}
