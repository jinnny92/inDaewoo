package kr.co.command;

import java.util.Scanner;

import kr.co.dao.MemberDAO;
import kr.co.db.DB;
import kr.co.domain.MemberDTO;

public class DeleteUICommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("삭제할 회원의 아이디를 입력하세요");
		int id = sc.nextInt();
		sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, null, 0);
		MemberDAO dao = new MemberDAO();
		MemberDTO findDTO = dao.findDTOById(dto);
		
		if (findDTO != null) {
			DB.dto  = findDTO;
		} else {
			System.out.println("해당 회원의 정보를 찾을 수 없습니다");
		}
		
		return true;
	}

}
