package com.naver;

import java.util.Iterator;

public class ChildThread extends Thread { //클래스는 아무 의미가 없다. 객체를 만들어야 호출이 됨
	@Override
	public void run() {
		Dog d2 = new Dog();
		d2.me1();
		
		for (int i = 0; i < 100; i++) {
			System.out.println("childThread:" + i);
		}
	}
}
