package kr.co.dw.service.test;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public void ba() {
		// TODO Auto-generated method stub
		System.out.println("::::::::::::::::pointcuts");

	}

	@Override
	public void ba(String msg) {
		// TODO Auto-generated method stub
		
		System.out.println(":::::::::::pointcuts:::::::::::::");
		
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
	}

}
