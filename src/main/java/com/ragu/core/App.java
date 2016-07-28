package com.ragu.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */


public class App {
	
	private enum ScoreCalculationType {
		BEST, LAST, AVERAGE;
		
		@Override
		public String toString(){
			return this.name();
		}
	}
	
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(App.class);

		logger.info("This is an information message");
		logger.error("this is a error message");
		logger.warn("this is a warning message");

		int i = 10;
		int j = 0;
		try {
			j = i / 0;
		} catch (ArithmeticException e) {
			logger.error("Errorooror : {}, {}", e.getMessage(), e.getStackTrace());
		}

		System.out.println("Hello World!" + j);
		
	}
	
}
