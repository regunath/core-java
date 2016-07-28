package com.ragu.blockingqueue.threadsignal;

public class SharedObject {
	
	boolean status;
	boolean wasSignaled = false;
	String message;

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	

}
