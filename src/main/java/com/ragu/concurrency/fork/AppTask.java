package com.ragu.concurrency.fork;

import java.util.concurrent.ForkJoinPool;

public class AppTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool forkJoinPool = new ForkJoinPool();

		MyRecursiveTask myRecursivetsk = new MyRecursiveTask(100);

		forkJoinPool.invoke(myRecursivetsk);
	}

}
