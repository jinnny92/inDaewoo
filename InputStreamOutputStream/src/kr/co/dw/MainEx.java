package kr.co.dw;

import com.naver.Dog;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog d1 = new Dog();
//		d1.me1();
//		d1.me2();
//		d1.me3();
//		d1.me4();
		// d1.me5();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				d1.me5();
			}
		}).start();
	}

}
