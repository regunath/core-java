package com.ragu.concurrency.lock;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ragu.thread.util.ThreadUtil;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SharedObj obj = new SharedObj();
		
		final Thread t1= new Thread(new Thread1(obj));
		t1.setName("T1");
		
		final Thread t2= new Thread(new Thread2(obj));
		t2.setName("T2");
		
		t1.start();
		Thread.sleep(500);
		t2.start();
		
        //ThreadUtil.startThreadStatusTimer(t1);
		//ThreadUtil.startThreadStatusTimer(t2);
        
		//ScheduledExecutorService e = Executors.newScheduledThreadPool(2);
		//e.schedule(t1, 10, TimeUnit.SECONDS);
        //Thread.sleep(500);
        //e.execute(t2);
        
        //e.shutdown();
        //e.awaitTermination(100, TimeUnit.MICROSECONDS);
		System.out.println("Main Done!!!");
	}

	private static void checkStatusTimer(final Thread t1, final Thread t2) {
		new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
            	System.out.println("\t\t\t\t\t\t\t\t\t\tThread1 state - "+t1.getState());
            }
        }, 0, 100);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\t\t\t\t\t\t\t\t\t\tThread2 state - "+t2.getState());
            }
        }, 0, 100);
	}

}
