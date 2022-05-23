package kr.co.Menucommand;

import java.util.Scanner;

import kr.co.dw.MMScommand.MMSDeleteCommand;
import kr.co.dw.MMScommand.MMSDeleteUICommand;
import kr.co.dw.MMScommand.MMSEndCommand;
import kr.co.dw.MMScommand.MMSInsertCommand;
import kr.co.dw.MMScommand.MMSInsertUICommand;
import kr.co.dw.MMScommand.MMSListCommand;
import kr.co.dw.MMScommand.MMSUpdateCommand;
import kr.co.dw.MMScommand.MMSUpdateUICommand;

public class MMSCommand implements MenuCommand {

	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		boolean isTrue = true;
		
		MMSCommand[] mms = {
				new MMSInsertUICommand(),
				new MMSUpdateUICommand(),
				new MMSDeleteUICommand(),
				new MMSListCommand(),
				new MMSEndCommand()
		};
		
		MMSCommand[] mms2 = {
				new MMSInsertCommand(),
				new MMSUpdateCommand(),
				new MMSDeleteCommand()
		};
		
		while (isTrue) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("0: 입력, 1: 수정, 2: 삭제, 3: 조회, 4: 종료");
			int menu = sc.nextInt();
			sc.nextLine();
			
			isTrue = mms[menu].process(sc);
			
			try {
				mms2[menu].process(sc);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				
			}
			
		}
		
		
		return true;
	}

}
