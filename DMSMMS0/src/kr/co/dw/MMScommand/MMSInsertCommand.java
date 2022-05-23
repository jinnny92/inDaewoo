package kr.co.dw.MMScommand;

import java.util.Scanner;

import kr.co.Menucommand.MMSCommand;
import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.db.MMSDB;

public class MMSInsertCommand extends MMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		dao.insert(MMSDB.dto);
		
		MMSDB.dto = null;
		
		return true;
	}

}
