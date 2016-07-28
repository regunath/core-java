package com.ragu.concurrency.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.ragu.thread.util.ThreadUtil;

public class App {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();

		Random random = new Random();

		for (int i = 0; i < 4; i++) {
			Integer number = random.nextInt(10);
			FactorialCalculator calculator = new FactorialCalculator(number);
			Future<Integer> result = executor.submit(calculator);
			resultList.add(result);
		}
		
		ThreadUtil.printStr("Tasks started and waiting for the result");

		for (Future<Integer> future : resultList) {
			ThreadUtil.printStr("Inside loop!!!");
			try {
				ThreadUtil.printStr(
						"Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ThreadUtil.printStr("Main method completed");
		// shut down the executor service now
		executor.shutdown();
	}
}