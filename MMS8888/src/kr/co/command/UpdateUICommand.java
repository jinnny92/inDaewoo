package kr.co.command;

import java.util.Scanner;

import kr.co.dao.MemberDAO;
import kr.co.db.DB;
import kr.co.domain.MemberDTO;

public class UpdateUICommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("수정할 회원의 아이디를 입력하세요");
		int id = sc.nextInt();
		sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		MemberDTO findDTO = dao.findDTOById(new MemberDTO(id, null, 0));
		
		if (findDTO != null) {
			System.out.println(findDTO);
			System.out.println("수정할 이름을 입력하세요(없으면 엔터)");
			String name = sc.nextLine();
			if (!name.equals("")) {
				findDTO.setName(name);
			}
			System.out.println(findDTO);
			System.out.println("수정할 나이를 입력하세요(없으면 -1)");
			int age = sc.nextInt();
			sc.nextLine();
			if (age != -1) {
				findDTO.setAge(age);
			}
			DB.dto = findDTO;
			
		} else {
			System.out.println("존재하지 않는 회원입니다");
		}
		
		return true;
	}

}
