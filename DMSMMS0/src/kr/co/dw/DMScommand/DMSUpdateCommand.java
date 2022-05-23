package kr.co.dw.DMScommand;

import java.util.Scanner;

import kr.co.Menucommand.DMSCommand;
import kr.co.dw.dms.dao.DmsDAO;
import kr.co.dw.dms.db.DmsDB;

public class DMSUpdateCommand extends DMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		
		if (DmsDB.dto != null) {
			DmsDAO dao = new DmsDAO();
			dao.update(DmsDB.dto);
		}
		
		DmsDB.dto = null;
		
		return true;
	}

}
