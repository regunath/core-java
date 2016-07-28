package com.ragu.thread.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public final class ThreadUtil {
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	static {
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
	}

	public static String getDateFormat(Date d) {
		return sdf.format(d);
	}

	public static void startThreadStatusTimer(final Thread t1) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("\t\t\t\t\t\t\t\t\t\tThread(" + t1.getName() + ") state - " + t1.getState());
			}
		}, 0, 1000);
	}

	public static void startThreadStatusTimer(final Thread t1, int ms) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("\t\t\t\t\t\t\t\t\t\tThread(" + t1.getName() + ") state - " + t1.getState());
			}
		}, 0, ms);
	}

	public static void printStr(String s) {
		System.out.println("[" + getDateFormat(new Date()) + "] - {" + Thread.currentThread().getName() + "} - " + s);
	}

	public static void printCurrentTimeAndThread() {
		System.out.println("[" + getDateFormat(new Date()) + "] - {" + Thread.currentThread().getName() + "}");
	}

	public static void printCurrentTimeAndThreadAndMessage(String message) {
		System.out.println("[" + getDateFormat(new Date()) + "] - {" + Thread.currentThread().getName() + "} - { "
				+ message + " }");
	}

}
