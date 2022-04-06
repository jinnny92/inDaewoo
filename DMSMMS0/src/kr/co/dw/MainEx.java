package kr.co.dw;

import java.util.Scanner;

import kr.co.Menucommand.DMSCommand;
import kr.co.Menucommand.EndCommand;
import kr.co.Menucommand.MMSCommand;
import kr.co.Menucommand.MenuCommand;


public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean isTrue = true;
		
		MenuCommand[] com = {
					new DMSCommand(),
					new MMSCommand(),
					new EndCommand()
				
		};
		
		while (isTrue) {
			System.out.println("관리 메뉴를 선택하세요");
			System.out.println("0: 부서관리, 1: 회원 관리, 2: 종료");
			int menu = sc.nextInt();
			sc.nextLine();
			
			isTrue = com[menu].process(sc);
		}
		
		
		sc.close();
	}
	

}
