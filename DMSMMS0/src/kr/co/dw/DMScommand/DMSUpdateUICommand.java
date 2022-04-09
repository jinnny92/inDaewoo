package kr.co.dw.DMScommand;

import java.util.Scanner;

import kr.co.Menucommand.DMSCommand;
import kr.co.dw.dms.dao.DmsDAO;
import kr.co.dw.dms.db.DmsDB;
import kr.co.dw.dms.domain.DmsDTO;

public class DMSUpdateUICommand extends DMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("수정할 회원의 아이디를 입력하세요");
		int did = sc.nextInt();
		sc.nextLine();
		
		DmsDAO dao = new DmsDAO();
		DmsDTO findDTO = dao.findDTOById(new DmsDTO(did, null));
		
		if (findDTO != null) {
			System.out.println(findDTO);
			System.out.println("수정할 부서를 입력하세요(없으면 엔터)");
			String dname = sc.nextLine();
			
			if (!dname.equals("")) {
				findDTO.setDname(dname);
			}
			
			DmsDB.dto = findDTO;
		}else {
			System.out.println("수정할 회원이 존재하지 않습니다");
		}
		
		return true;
	}
}
