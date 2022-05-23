package kr.co.dw.MMScommand;

import java.util.Scanner;

import kr.co.Menucommand.MMSCommand;
import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.db.MMSDB;
import kr.co.dw.member.domain.MemberDTO;

public class MMSInsertUICommand extends MMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("아이디를 입력하세요");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		sc.nextLine();
		
		MMSDB.dto = new MemberDTO(id, name, age);
		
		return true;
	}

}
