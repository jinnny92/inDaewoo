package kr.co.command;

import java.util.Scanner;

import kr.co.dao.MemberDAO;
import kr.co.db.DB;

public class InsertCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		dao.insert(DB.dto);
		
		DB.dto = null;
		
		return true;
	}

}
