package kr.co.dw.DMScommand;

import java.util.Scanner;

import kr.co.Menucommand.DMSCommand;
import kr.co.dw.dms.dao.DmsDAO;
import kr.co.dw.dms.db.DmsDB;
import kr.co.dw.dms.domain.DmsDTO;

public class DMSDeleteUICommand extends DMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("삭제할 회원의 아이디를 입력하세요");
		int did = sc.nextInt();
		sc.nextLine();
		
		DmsDTO dto = new DmsDTO(did, null);
		DmsDAO dao = new DmsDAO();
		DmsDTO findDTO = dao.findDTOById(dto);
		
		if (findDTO != null) {
				DmsDB.dto = findDTO;
		} else {
			System.out.println("해당 회원이 존재하지 않습니다");
		}
		
		return true;
	}
	

}
