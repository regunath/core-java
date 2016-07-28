package com.ragu.core;

import com.ragu.exception.InvalidAccessTokenException;
import com.ragu.exception.ObjectNotFoundException;

public class ExceptionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1");
		try{
			throw new Exception("error!!!");
		}catch (Exception e){
			ObjectNotFoundException re = new InvalidAccessTokenException()
			.setId("ddd");
			re.addSuppressed(e);
			throw re;
		}
	}
}
