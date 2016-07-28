package com.ragu.concurrency.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ragu.thread.util.DummyThread;
import com.ragu.thread.util.ThreadUtil;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		//ExecutorService e = Executors.newCachedThreadPool(
		
		Thread task = null;
		System.out.println(Thread.currentThread().isDaemon());
		for (int i = 0; i <= 10; i++){
			task = new Thread(new DummyThread());
			task.setName("Thread : {" + i + "}");
			//ThreadUtil.startThreadStatusTimer(task, 1000); //the threads doesnt have any more reference 
			e.execute(task);
			//e.submit(task);
			//task.setDaemon(true);
		}
		
		e.shutdown();
		
	}

}
