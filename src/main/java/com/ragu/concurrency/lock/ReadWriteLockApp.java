package com.ragu.concurrency.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockApp {
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private final Lock readLock = readWriteLock.readLock();

	private final Lock writeLock = readWriteLock.writeLock();

	private final List<String> list = new ArrayList<String>();

	public void set(String o) {
		writeLock.lock();
		try {
			list.add(o);
			System.out.println("Adding element by thread " + Thread.currentThread().getName());
		} finally {
			writeLock.unlock();
		}
	}

	public String get(int i) {
		readLock.lock();
		try {
			System.out.println("Printing elements by thread " + Thread.currentThread().getName());
			return list.get(i);
		} finally {
			readLock.unlock();
		}
	}

	public static void main(String[] args) {
		ReadWriteLockApp strArayList = new ReadWriteLockApp();
		strArayList.set("1");
		strArayList.set("2");
		strArayList.set("3");

		System.out.println("Printing the First Element : " + strArayList.get(1));
	}
}
