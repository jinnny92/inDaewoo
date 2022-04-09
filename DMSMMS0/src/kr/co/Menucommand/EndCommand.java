package kr.co.Menucommand;

import java.util.Scanner;

public class EndCommand implements MenuCommand {

	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("시스템 종료");
		return false;
	}

}
