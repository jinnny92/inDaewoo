package kr.co.command;

import java.util.Scanner;

public class EndCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("종료");
		return false;
	}

}
