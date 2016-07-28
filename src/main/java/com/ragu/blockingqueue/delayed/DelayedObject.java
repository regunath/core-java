package com.ragu.blockingqueue.delayed;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedObject implements Delayed {

	public String message;
	public long startTime;

	public DelayedObject(String message, long startTime) {
		this.message = message;
		this.startTime = startTime;
	}

	public int compareTo(Delayed o) {
		if (this.startTime < ((DelayedObject) o).startTime) {
			return -1;
		}
		if (this.startTime > ((DelayedObject) o).startTime) {
			return 1;
		}
		return 0;
	}

	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return "[Message - " + this.message + ", startTime - " + this.startTime + "]";
	}

}
