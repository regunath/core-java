package com.ragu.concurrency.core;

public class MyApp {

	public static void main(String[] args) {
		MySyncService s = new MySyncService();
		Thread t = new MyThread(s);
		t.setName("Thread---1");
		Thread intt = new Thread(new MyIntThread(s));
		intt.setName("Thread--2");
		
		t.start();
		intt.start();

	}

}
