package kr.co.Menucommand;

import java.util.Scanner;

import kr.co.dw.DMScommand.DMSDeleteCommand;
import kr.co.dw.DMScommand.DMSDeleteUICommand;
import kr.co.dw.DMScommand.DMSEndCommand;
import kr.co.dw.DMScommand.DMSInsertCommand;
import kr.co.dw.DMScommand.DMSInsertUICommand;
import kr.co.dw.DMScommand.DMSListCommand;
import kr.co.dw.DMScommand.DMSUpdateCommand;
import kr.co.dw.DMScommand.DMSUpdateUICommand;


public class DMSCommand implements MenuCommand {

	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		boolean isTrue = true;
		
		DMSCommand[] dms = {
				new DMSInsertUICommand(),
				new DMSUpdateUICommand(),
				new DMSDeleteUICommand(),
				new DMSListCommand(),
				new DMSEndCommand()
				
				
		};
		
		DMSCommand[] dms2 = {
				new DMSInsertCommand(),
				new DMSUpdateCommand(),
				new DMSDeleteCommand()
				
				
		};
		
		
		while (isTrue) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("0: 입력, 1: 수정, 2: 삭제, 3: 조회, 4: 종료");
			int menu = sc.nextInt();
			sc.nextLine();
			
			isTrue = dms[menu].process(sc);
			
			try {
				dms2[menu].process(sc);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				
			}
			
		}
		
		
		return true;
	}

}
