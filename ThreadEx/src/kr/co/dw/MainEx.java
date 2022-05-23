package kr.co.dw;

import java.util.Iterator;

import com.naver.ChildThread;
import com.naver.Dog;

import net.daum.Myrunnable;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread userThread = new ChildThread();
		//userThread.run();
		userThread.start();
		
		Runnable myrun = new Myrunnable();
		Thread myThread = new Thread(myrun); //이게 스레드 객체 아직 스레드 아님
		myThread.start(); //대기상태. 곧바로 실행되는게 아님 스레드스케쥴러필요
		//스레드는 순서를 모른다. 다만 나중에 종료 순서 조작이 가능하다. 
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//클래스라는 키워드가 없으니까 익명의 내부클레스(인터페이스만 익명의 내부클래스가 있는게 아니라 스레드도 익명의 내부 클래스가 있음)
			}
		};
		
		new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("익명의 클래스 이용: " +i);
				}
			}
		}.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 100; i++) {
					System.out.println("익명의 클래스 이용2: " +i);
				}
			}
		}).start();
		 //위와 똑같은 코드지만 이 코드를 더 많이 사용한다
		
		
		
		Dog d1 = new Dog();
		d1.me1();
		
		
		for (int i = 0; i < 100; i++) {
			System.out.println("main:" +i);
		}

	}

}
