package com.ragu.concurrency.lock;

public class DefaultLockApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyClass myClass = new MyClass();
        myClass.method1();

	}

}

class MyClass {

    synchronized void method1() {
           System.out.println("Inside method1");
           this.method2();

    }

    synchronized void method2() {
           System.out.println("Inside method2");
    }

}

