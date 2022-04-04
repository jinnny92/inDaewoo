package kr.co.command;

import java.util.Scanner;

import kr.co.dao.MemberDAO;
import kr.co.db.DB;

public class DeleteCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		// TODO Auto-generated method stub
		
		if (DB.dto != null) {
			MemberDAO dao = new MemberDAO();
			dao.delete(DB.dto);
		}
		
		DB.dto = null;
		
		return true;
	}

}
