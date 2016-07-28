package com.ragu.thread.util;

import java.util.Timer;
import java.util.TimerTask;

public class SimpleThreadStates {

    public static void main(String[] args) throws Exception{

        final Thread t = new Thread(new MyTask());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ThreadUtil.printStr("Thread state - "+t.getState());
            }
        }, 0, 1000);

        Thread.sleep(2*1000);

        t.start();
    }

    public static class MyTask implements Runnable{

    	public void run() {
            try {
                doProcessingInSeconds(5);
                Thread.sleep(5 * 1000);
                lockOnClassObject(5, SimpleThreadStates.class);
                Thread.sleep(100);
                synchronized (SimpleThreadStates.class){
                    ThreadUtil.printStr("Coming to synchronized block after the lock is released");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void doProcessingInSeconds(int n){
        long begin = System.currentTimeMillis();
        long end = begin + 1000*n;
        for(;end > System.currentTimeMillis();){
        }
    }

    /**
     * if flag is true then it emulates block else just call
     * @param flag
     */
    private static void lockOnClassObject(final int n, final Class clazz) throws Exception{

        Runnable r = new Runnable(){

        	public void run() {
                synchronized (clazz){
                    try {
                        Thread.sleep(n * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(r).start();
    }
}