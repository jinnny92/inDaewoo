package kr.co.dw.DMScommand;

import java.util.Scanner;

import kr.co.Menucommand.DMSCommand;
import kr.co.dw.dms.db.DmsDB;
import kr.co.dw.dms.domain.DmsDTO;

public class DMSInsertUICommand extends DMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("아이디를 입력하세요");
		int did = sc.nextInt();
		sc.nextLine();
		
		System.out.println("부서를 입력하세요");
		String dname = sc.nextLine();
		
		DmsDB.dto = new DmsDTO(did, dname);
		
		return true;
	}
}
