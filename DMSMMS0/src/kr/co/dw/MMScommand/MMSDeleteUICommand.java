package kr.co.dw.MMScommand;

import java.util.Scanner;

import kr.co.Menucommand.MMSCommand;
import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.db.MMSDB;
import kr.co.dw.member.domain.MemberDTO;

public class MMSDeleteUICommand extends MMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("삭제할 회원의 아이디를 입력하세요");
		int id = sc.nextInt();
		sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, null, 0);
		MemberDAO dao = new MemberDAO();
		MemberDTO findDTO = dao.findDTOById(dto);
		
		if (findDTO != null) {
			MMSDB.dto  = findDTO;
		} else {
			System.out.println("해당 회원의 정보를 찾을 수 없습니다");
		}
		
		return true;
	}

}
