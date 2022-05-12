package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public class ReplyUIBoardCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		
		//num값을 주면 repRoot나 Step값이 필요하지만 화면에서 보여주지 않고 나중에 저장할때 dao에서 신경쓸것이기에 BoardDAO는 필요가 없다.
		//화면을 보여줄때는 그 값들은 신경 안써도됨.
		//하지만 바인딩은 해야함. 해야지 나중에 답글 다 달고 난 다음에 전송을 할 때 원래 값에 대한 num값을 보내줘야함. 그리고 DB쪽에서 원래쪽에 num값을  조회를 함. 그러면 이제 repRoot값이나 Step갑이 나오는 것임
		
		request.setAttribute("orgnum", num);
		
		return new CommandAction("/jsp/board/reply.jsp", false);
	}

}
