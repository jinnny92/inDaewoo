package kr.co.command;

import java.util.Scanner;

import kr.co.db.DB;
import kr.co.domain.MemberDTO;

public class InsertUICommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("아이디를 입력하세요");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		sc.nextLine();
		
		DB.dto = new MemberDTO(id, name, age);
		
		return true;
	}

}
