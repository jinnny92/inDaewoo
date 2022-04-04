package kr.co.command;

import java.util.List;
import java.util.Scanner;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class ListCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
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
