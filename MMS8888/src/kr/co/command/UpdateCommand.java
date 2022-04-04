package kr.co.command;

import java.util.Scanner;

import kr.co.dao.MemberDAO;
import kr.co.db.DB;

public class UpdateCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		// TODO Auto-generated method stub
		if (DB.dto != null) {
			MemberDAO dao = new MemberDAO();
			dao.update(DB.dto);
		}
		DB.dto = null;
		return true;
	}

}
