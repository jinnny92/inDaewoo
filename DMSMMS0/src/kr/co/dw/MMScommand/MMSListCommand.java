package kr.co.dw.MMScommand;

import java.util.List;
import java.util.Scanner;

import kr.co.Menucommand.MMSCommand;
import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.domain.MemberDTO;

public class MMSListCommand extends MMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.list();
		
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.println(dto);
			
		}
		
		return true;
	}

}
