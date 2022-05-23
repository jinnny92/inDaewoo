package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import kr.co.dw.member.dto.CommandAction;

public class InsertUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		return new CommandAction("member/jsp/insert.jsp", false);
		//~ui.do가 나오면  Dispatcher방식(데이터가 살아남아야하기 때문)
	}

}
