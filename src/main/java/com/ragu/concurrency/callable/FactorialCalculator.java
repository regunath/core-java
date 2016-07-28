package com.ragu.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.ragu.thread.util.ThreadUtil;

public class FactorialCalculator implements Callable<Integer> {
	private Integer number;

	public FactorialCalculator(Integer number) {
		this.number = number;
	}

	public Integer call() throws Exception {
		
		Thread.sleep(10000);
		int result = 1;
		if ((number == 0) || (number == 1)) {
			result = 1;
		} else {
			for (int i = 2; i <= number; i++) {
				result *= i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		ThreadUtil.printStr("Result for number - " + number + " -> " + result);
		return result;
	}

}
