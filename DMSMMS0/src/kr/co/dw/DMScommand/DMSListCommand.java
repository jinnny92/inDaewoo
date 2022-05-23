package kr.co.dw.DMScommand;

import java.util.List;
import java.util.Scanner;

import kr.co.Menucommand.DMSCommand;
import kr.co.dw.dms.dao.DmsDAO;
import kr.co.dw.dms.domain.DmsDTO;

public class DMSListCommand extends DMSCommand {
	@Override
	public boolean process(Scanner sc) {
		// TODO Auto-generated method stub
		DmsDAO dao = new DmsDAO();
		List<DmsDTO> list = dao.list();
		
		for (int i = 0; i < list.size(); i++) {
			DmsDTO dto = list.get(i);
			System.out.println(dto);
		}
		
		return true;
	}


}
