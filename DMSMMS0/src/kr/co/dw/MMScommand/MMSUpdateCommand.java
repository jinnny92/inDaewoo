package kr.co.dw.MMScommand;

import java.util.Scanner;

import kr.co.Menucommand.MMSCommand;
import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.db.MMSDB;

public class MMSUpdateCommand extends MMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		if (MMSDB.dto != null) {
			MemberDAO dao = new MemberDAO();
			dao.update(MMSDB.dto);
		}
		MMSDB.dto = null;
		return true;
	}


}
